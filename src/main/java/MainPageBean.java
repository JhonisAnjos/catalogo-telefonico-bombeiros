import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import dev.jhonisanjos.entities.Contato;
import dev.jhonisanjos.entities.Endereco;
import dev.jhonisanjos.enums.EstadoEnum;
import dev.jhonisanjos.enums.GrauHierarquicoEnum;
import dev.jhonisanjos.services.ContatoService;

@Named
@ViewScoped
public class MainPageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Contato contato;

	private List<Contato> contatos;

	@Inject
	private ContatoService contatoService;

	public void prepareInsert() {
		this.contato = new Contato();
		this.contato.setEndereco(new Endereco());
	}

	public void save() {
		try {
			this.contatoService.save(contato);
			this.contatos = null;
			this.addMessageInfo("Contato salvo com sucesso!");
			PrimeFaces.current().ajax().update(Arrays.asList("frm:contatosDataTable", "frm:messages"));
		} catch (Exception e) {
			e.printStackTrace();
			this.addMessageError("Erro inesperado, contate o administador do sistema.");
		}

	}

	public void remove() {
		try {
			this.contatoService.remove(this.contato);
			this.contatos.remove(this.contato);
			this.contato = null;
			this.addMessageInfo("Contato excluído com sucesso!");			
		} catch (Exception e) {
			e.printStackTrace();
			this.addMessageError("Erro inesperado, contate o administador do sistema.");
		}
	}

	public List<Contato> getContatos() {
		if (Objects.isNull(this.contatos)) {
			this.contatos = this.contatoService.findAll();
		}
		return this.contatos;
	}

	public List<GrauHierarquicoEnum> getGrausHierarquicos() {
		return Arrays.asList(GrauHierarquicoEnum.values());
	}

	public List<EstadoEnum> getEstados() {
		return Arrays.asList(EstadoEnum.values());
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	private void addMessage(String msg, FacesMessage.Severity severity) {
		FacesMessage facesMessage = new FacesMessage(msg);
		facesMessage.setSeverity(severity);

		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	private void addMessageInfo(String msg) {
		this.addMessage(msg, FacesMessage.SEVERITY_INFO);
	}
	private void addMessageError(String msg) {
		this.addMessage(msg, FacesMessage.SEVERITY_ERROR);
	}

}

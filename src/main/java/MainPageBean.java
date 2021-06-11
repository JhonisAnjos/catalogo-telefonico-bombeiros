import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dev.jhonisanjos.entities.Contato;
import dev.jhonisanjos.entities.Endereco;
import dev.jhonisanjos.enums.EstadoEnum;
import dev.jhonisanjos.enums.GrauHierarquicoEnum;
import dev.jhonisanjos.repositories.ContatoRepository;

@Named
@ViewScoped
public class MainPageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Contato contato;

	@Inject
	private ContatoRepository repository;

	public void prepararInsercao() {
		this.contato = new Contato();
		this.contato.setEndereco(new Endereco());
	}

	public void salvar() {
		this.repository.saveOrUpdate(this.contato);
		this.addMessageInfo("Contato salvo com sucesso!");
	}

	public List<Contato> getContatos() {
		return this.repository.findAll();
	}
	
	public List<GrauHierarquicoEnum> getGrausHierarquicos(){
		return Arrays.asList(GrauHierarquicoEnum.values());
	}
	
	public List<EstadoEnum> getEstados(){
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
	
	
}

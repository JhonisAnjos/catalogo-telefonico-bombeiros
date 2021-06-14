package dev.jhonisanjos.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import dev.jhonisanjos.entities.Contato;

public class ContatoRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Contato saveOrUpdate(Contato contato){
		return this.manager.merge(contato);
	}
	
	public void remove(Contato contato){
		contato = this.findById(contato.getId());
		this.manager.remove(contato);
	}
	
	public Contato findById(Long id) {
		return this.manager.find(Contato.class, id);
	}
	
	public List<Contato> findAll(){
		return this.manager.createQuery("SELECT c FROM Contato c", Contato.class ).getResultList();
	}
}

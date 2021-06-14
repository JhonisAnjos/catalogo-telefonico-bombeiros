package dev.jhonisanjos.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import dev.jhonisanjos.config.Transacional;
import dev.jhonisanjos.entities.Contato;
import dev.jhonisanjos.repositories.ContatoRepository;

public class ContatoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContatoRepository repository;

	@Transacional
	public void save(Contato contato) {
		this.repository.saveOrUpdate(contato);
	}
	
	@Transacional
	public void remove(Contato contato){
		this.repository.remove(contato);
	}

	public List<Contato> findAll() {
		return this.repository.findAll();
	}
}

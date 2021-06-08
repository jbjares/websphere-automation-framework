package br.gov.bnb.s095.exemplo.jpa.dao;

import javax.persistence.EntityManager;

import br.gov.bnb.s095.exemplo.jpa.entity.V533audi;
import br.gov.bnb.s095.exemplo.jpa.entity.Vatividades;

public class DAO {
	
	private EntityManager entityManager;
	
	@SuppressWarnings("unused")
	private DAO(){}
	
	public DAO(EntityManager entityManager){
		this.entityManager=entityManager;
	}
	
	public V533audi findAudi(Integer id){
		return this.entityManager.find(V533audi.class,id);
	}
	
	public Vatividades findAtividade(Integer id){
		return this.entityManager.find(Vatividades.class,id);
	}
	
}

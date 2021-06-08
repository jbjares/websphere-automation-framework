package br.gov.bnb.s095.exemplo.jpa.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vatividades implements Serializable {
	@Id
	private int dbid;

	private String id;

	@Column(name="record_type")
	private String recordType;

	private String owner;

	@Column(name="nome_owner")
	private String nomeOwner;

	@Column(name="am_actual_work")
	private String amActualWork;

	private String projeto;

	private String sistema;

	private String name;

	@Column(name="data_abertura")
	private Timestamp dataAbertura;

	@Column(name="data_fechamento")
	private Timestamp dataFechamento;

	private static final long serialVersionUID = 1L;

	public Vatividades() {
		super();
	}

	public int getDbid() {
		return this.dbid;
	}

	public void setDbid(int dbid) {
		this.dbid = dbid;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRecordType() {
		return this.recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getNomeOwner() {
		return this.nomeOwner;
	}

	public void setNomeOwner(String nomeOwner) {
		this.nomeOwner = nomeOwner;
	}

	public String getAmActualWork() {
		return this.amActualWork;
	}

	public void setAmActualWork(String amActualWork) {
		this.amActualWork = amActualWork;
	}

	public String getProjeto() {
		return this.projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public String getSistema() {
		return this.sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDataAbertura() {
		return this.dataAbertura;
	}

	public void setDataAbertura(Timestamp dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Timestamp getDataFechamento() {
		return this.dataFechamento;
	}

	public void setDataFechamento(Timestamp dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

}

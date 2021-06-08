package br.gov.bnb.s095.exemplo.ejb.to;

import java.io.Serializable;
import java.sql.Timestamp;

public class VatividadesTO implements Serializable{
	private int dbid;

	private String id;

	private String recordType;

	private String owner;

	private String nomeOwner;

	private String amActualWork;

	private String projeto;

	private String sistema;

	private String name;

	private Timestamp dataAbertura;

	private Timestamp dataFechamento;

	private static final long serialVersionUID = 1L;

	public VatividadesTO() {
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

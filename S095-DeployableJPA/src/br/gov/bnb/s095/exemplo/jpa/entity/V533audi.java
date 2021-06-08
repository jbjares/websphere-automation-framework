package br.gov.bnb.s095.exemplo.jpa.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="V533audi", schema="T1ADM533")
public class V533audi implements Serializable {
	@Id
	@Column(name="SQ_AUD")
	private int sqAud;

	@Column(name="TP_EVT")
	private int tpEvt;

	@Column(name="DT_INI_EVT")
	private Timestamp dtIniEvt;

	@Column(name="DT_FIN_EVT")
	private Timestamp dtFinEvt;

	@Column(name="IDT_RSP")
	private String idtRsp;

	@Column(name="IDT_SIS")
	private String idtSis;

	@Column(name="MDL_SIS")
	private String mdlSis;

	@Column(name="DE_FUC_EVT")
	private String deFucEvt;

	@Column(name="IDT_IP_ORI")
	private String idtIpOri;

	@Column(name="IDT_HOS_ORI")
	private String idtHosOri;

	@Column(name="IDT_DMN_ORI")
	private String idtDmnOri;

	@Column(name="DE_RST_FIN")
	private String deRstFin;

	@Column(name="DE_INF_ADC")
	private String deInfAdc;

	private static final long serialVersionUID = 1L;

	public V533audi() {
		super();
	}

	public int getSqAud() {
		return this.sqAud;
	}

	public void setSqAud(int sqAud) {
		this.sqAud = sqAud;
	}

	public int getTpEvt() {
		return this.tpEvt;
	}

	public void setTpEvt(int tpEvt) {
		this.tpEvt = tpEvt;
	}

	public Timestamp getDtIniEvt() {
		return this.dtIniEvt;
	}

	public void setDtIniEvt(Timestamp dtIniEvt) {
		this.dtIniEvt = dtIniEvt;
	}

	public Timestamp getDtFinEvt() {
		return this.dtFinEvt;
	}

	public void setDtFinEvt(Timestamp dtFinEvt) {
		this.dtFinEvt = dtFinEvt;
	}

	public String getIdtRsp() {
		return this.idtRsp;
	}

	public void setIdtRsp(String idtRsp) {
		this.idtRsp = idtRsp;
	}

	public String getIdtSis() {
		return this.idtSis;
	}

	public void setIdtSis(String idtSis) {
		this.idtSis = idtSis;
	}

	public String getMdlSis() {
		return this.mdlSis;
	}

	public void setMdlSis(String mdlSis) {
		this.mdlSis = mdlSis;
	}

	public String getDeFucEvt() {
		return this.deFucEvt;
	}

	public void setDeFucEvt(String deFucEvt) {
		this.deFucEvt = deFucEvt;
	}

	public String getIdtIpOri() {
		return this.idtIpOri;
	}

	public void setIdtIpOri(String idtIpOri) {
		this.idtIpOri = idtIpOri;
	}

	public String getIdtHosOri() {
		return this.idtHosOri;
	}

	public void setIdtHosOri(String idtHosOri) {
		this.idtHosOri = idtHosOri;
	}

	public String getIdtDmnOri() {
		return this.idtDmnOri;
	}

	public void setIdtDmnOri(String idtDmnOri) {
		this.idtDmnOri = idtDmnOri;
	}

	public String getDeRstFin() {
		return this.deRstFin;
	}

	public void setDeRstFin(String deRstFin) {
		this.deRstFin = deRstFin;
	}

	public String getDeInfAdc() {
		return this.deInfAdc;
	}

	public void setDeInfAdc(String deInfAdc) {
		this.deInfAdc = deInfAdc;
	}

}

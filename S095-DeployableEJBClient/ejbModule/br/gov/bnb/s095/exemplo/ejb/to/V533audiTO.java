package br.gov.bnb.s095.exemplo.ejb.to;

import java.io.Serializable;
import java.sql.Timestamp;


public class V533audiTO implements Serializable{

	private static final long serialVersionUID = 1549101777815537175L;

	private int sqAud;

	private int tpEvt;

	private Timestamp dtIniEvt;

	private Timestamp dtFinEvt;

	private String idtRsp;

	private String idtSis;

	private String mdlSis;

	private String deFucEvt;

	private String idtIpOri;

	private String idtHosOri;

	private String idtDmnOri;

	private String deRstFin;

	private String deInfAdc;

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

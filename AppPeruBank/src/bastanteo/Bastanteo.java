package bastanteo;

import java.util.Calendar;

public class Bastanteo {

	private String codCli;
	private String idGrupoBast;
	private String tipoInterv;
	private String codPoder;
	private String otrGpoBast;
	private String moneda;
	private Double importe;
	private String codUser;
	private Calendar fecReg;
	private Calendar fecVenc;
	
	
	public Bastanteo(String codCli, String idGrupoBast, String tipoInterv,
			String codPoder, String otrGpoBast, String moneda, Double importe, 
			String codUser,  Calendar fecReg, Calendar fecVenc) {
		
        super();  //el super siempre va en primer lugar
		
		this.codCli       =codCli;
		this.idGrupoBast = idGrupoBast;
		this.tipoInterv  = tipoInterv;
		this.codPoder    = codPoder;
		this.otrGpoBast  = otrGpoBast;
		this.moneda      = moneda;
		this.importe     = importe;	
		this.setCodUser(codUser);
		this.fecReg      = fecReg;
		this.fecVenc     = fecVenc;
				
	}


	public String getCodCli() {
		return codCli;
	}


	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}


	public String getIdGrupoBast() {
		return idGrupoBast;
	}


	public void setIdGrupoBast(String idGrupoBast) {
		this.idGrupoBast = idGrupoBast;
	}


	public String getTipoInterv() {
		return tipoInterv;
	}


	public void setTipoInterv(String tipoInterv) {
		this.tipoInterv = tipoInterv;
	}


	public String getCodPoder() {
		return codPoder;
	}


	public void setCodPoder(String codPoder) {
		this.codPoder = codPoder;
	}


	public String getMoneda() {
		return moneda;
	}


	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}


	public Double getImporte() {
		return importe;
	}


	public void setImporte(Double importe) {
		this.importe = importe;
	}


	public Calendar getFecReg() {
		return fecReg;
	}


	public void setFecReg(Calendar fecReg) {
		this.fecReg = fecReg;
	}


	public Calendar getFecVenc() {
		return fecVenc;
	}


	public void setFecVenc(Calendar fecVenc) {
		this.fecVenc = fecVenc;
	}


	public String getOtrGpoBast() {
		return otrGpoBast;
	}


	public void setOtrGpoBast(String otrGpoBast) {
		this.otrGpoBast = otrGpoBast;
	}


	public String getCodUser() {
		return codUser;
	}


	public void setCodUser(String codUser) {
		this.codUser = codUser;
	}
}
package bastanteo;

public class Representante {
	private String codigoRep;
	private String nombreRep;
	private String dni;
	private String tipoDoc;
    private String codigoCliente;
	private String codigoGrupoBastanteo;
	private String cargo;
	private String codigoUsuario;
    
	
	public Representante(String codigoRep, String nombreRep, String dni,
			String tipoDoc, String codigoCliente, String codigoGrupoBastanteo,
			String cargo, String codigoUsuario) {
		super(); // el super siempre va en primer lugar
		this.codigoRep = codigoRep;
		this.codigoCliente = codigoCliente;
		this.dni = dni;
		this.tipoDoc = tipoDoc;
		this.codigoCliente = codigoCliente;
		this.codigoGrupoBastanteo = codigoGrupoBastanteo;
		this.cargo = cargo;
		this.codigoUsuario = codigoUsuario;

	}

	public String getCodigoRep() {

		return codigoRep;
	}

	public String getNomRep() {

		return nombreRep;
	}

	public String getCodigoCliente() {


		return codigoCliente;
	}

	public String getDni() {

		return dni;
	}

	public String getTipoDoc() {

		return tipoDoc;
	}

	public String getCodigoGrupoBastanteo() {

		return codigoGrupoBastanteo;
	}

	public String getCodigoUsuario() {

		return codigoUsuario;
	}

	public String getCargo() {

		return cargo;
	}

}
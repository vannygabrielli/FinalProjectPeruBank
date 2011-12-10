package bastanteo;

public class RolUsuario {

	String codigoUsuario;
	String codigoRol;
	boolean estado;

	public RolUsuario(String codigoUsuario, String codigoRol, Boolean estado) {
		super();

		this.codigoUsuario = codigoUsuario;
		this.codigoRol = codigoRol;
		this.estado = estado;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public String getCodigoRol() {
		return codigoRol;
	}

	public boolean getEstado() {
		return estado;
	}

}

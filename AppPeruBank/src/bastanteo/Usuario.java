package bastanteo;

public class Usuario {

	private String codigoUsuario;
	private String ctaUsuario;
	private String password;

	public Usuario(String codigoUsuario, String ctaUsuario, String password) {
		super();

		this.codigoUsuario = codigoUsuario;
		this.ctaUsuario = ctaUsuario;
		this.password = password;
	}

	public String getCodigoUsuario() {

		return codigoUsuario;
	}

	public String getCtaUsuario() {

		return ctaUsuario;
	}
	
	public String getPassword() {

		return password;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public void setCtaUsuario(String ctaUsuario) {
		this.ctaUsuario = ctaUsuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
	@Override
	public String toString() {
		
		return ctaUsuario + "," + password ;
	}
	
}

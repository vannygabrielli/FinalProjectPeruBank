package bastanteo;

public class Poder {
	private String codigoPoder;
	private String desPoder;
	private String tipProducto;
	private String codUsuario;
	
	
	public Poder(String codigoPoder, String desPoder, String tipProducto, String codUsuario) {
		super(); // el super siempre va en primer lugar
		this.codigoPoder = codigoPoder;
		this.desPoder = desPoder;
		this.tipProducto = tipProducto;
		this.codUsuario = codUsuario;
	}
    
	public String getCodigoPoder() {

		return codigoPoder;
	}
	
	public String getDesPoder() {

		return desPoder;
	}
	
	public String getTipProducto() {

		return tipProducto;
	}
	
	public String getCodUsuario(){
		return codUsuario;
	}
    
}

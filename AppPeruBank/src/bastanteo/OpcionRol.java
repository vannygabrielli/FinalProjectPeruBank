package bastanteo;

public class OpcionRol {
	
	private String codigoPermiso;
	private int codigoOpcion;
	private String codigoRol;
	private boolean estado;

	public OpcionRol(String codigoPermiso, int codigoOpcion, String codigoRol, boolean estado) {
		// TODO Auto-generated constructor stub
		super();
		this.codigoPermiso = codigoPermiso;
		this.codigoOpcion = codigoOpcion;
		this.codigoRol = codigoRol;
		this.estado = estado;
	}

	public String getCodigoPermiso() {
		return codigoPermiso;
	}

	public void setCodigoPermiso(String codigoPermiso) {
		this.codigoPermiso = codigoPermiso;
	}

	public int getCodigoOpcion() {
		return codigoOpcion;
	}

	public void setCodigoOpcion(int codigoOpcion) {
		this.codigoOpcion = codigoOpcion;
	}

	public String getCodigoRol() {
		return codigoRol;
	}

	public void setCodigoRol(String codigoRol) {
		this.codigoRol = codigoRol;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

}

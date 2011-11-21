package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmRepresentante {

	List<Representante> representantes;

	public AdmRepresentante() {
		representantes = new ArrayList<Representante>();

	}

	public void registrarRepresentante(String codigoRep, String nombreRep,
			String dni, String tipoDoc, String codigoCliente,
			String codigoGrupoBastanteo, String cargo, String codigoUsuario)
			throws PeruBankException{

		// validar datos
		validarDatos(codigoRep, nombreRep, dni, tipoDoc, codigoCliente,
		codigoGrupoBastanteo, cargo, codigoUsuario);

		// validar que no haya duplicados
		validarDuplicado(codigoRep, dni);

		// Creamos un cliente
		Representante nuevoRepresentante = new Representante(codigoRep, nombreRep, dni, tipoDoc, codigoCliente,
				codigoGrupoBastanteo, cargo, codigoUsuario);
		// añaden a la lista
		representantes.add(nuevoRepresentante);

	}
	
	private void validarDuplicado(String codigoRep, String dni)
			throws PeruBankException {		
	    
        if(representanteExiste(codigoRep, dni)) 
        	throw new PeruBankException("Representante Duplicado");
	}

	private boolean representanteExiste(String codigoRep, String dni) {
		boolean existe = false;
	    
	    //   and &&   , || or
        for(Representante representante : representantes)
            if (representante.getCodigoRep().equals(codigoRep) ||
            		representante.getDni().equals(dni))
                existe = true;
		return existe;
	}

	private void validarDatos(String codigoRep,String nombreRep,String dni,String tipoDoc,String codigoCliente,
			String codigoGrupoBastanteo,String cargo,String codigoUsuario) throws PeruBankException {
		
		String mensaje = "";
	    if (codigoRep.equals(""))
	        mensaje += "Codigo no puede ser vacio";
	    if (nombreRep.equals(""))
	        mensaje += "\nNombre de representante no puede ser vacio";
	    if (dni.equals(""))
	        mensaje += "\nDNI no puede ser vacio";
	    if (tipoDoc.equals(""))
	        mensaje += "\ntipo de documento no puede ser vacio";
	    if (codigoCliente.equals(""))
	        mensaje += "\nCodigo de cliente no puede ser vacio";
	    if (codigoGrupoBastanteo.equals(""))
	        mensaje += "\nGrupo de bastanteo no puede ser vacio";
	    if (cargo.equals(""))
	        mensaje += "\nCargo de representante no puede ser vacio";
	    if (codigoUsuario.equals(""))
	        mensaje += "\nCodigo de usuario no puede ser vacio";
	    if (! mensaje.equals(""))
	    		throw new PeruBankException(mensaje);
	}
	
	public Representante buscarRepresentante(String codigoRep) {
		 for(Representante representante : representantes)
	            if (representante.getCodigoRep().equals(codigoRep))
	                return representante;
	        return null;
	}

}

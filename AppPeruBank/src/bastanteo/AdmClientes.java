package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmClientes {

	//1ero. defino mi lista de un tipo dado
	List<Cliente> clientes;
	
	//2do. En el constructor inicializo
	public AdmClientes(){
		clientes = new ArrayList<Cliente>();
	}
	
	
	public void registrarCliente(String codigo, String ruc, String razonSocial,
			String fechaInicio, String tipoEmpresa, int empleados) 
			throws PeruBankException 
			{
		
		
		//validar datos	
	    validarDatos(codigo, ruc, razonSocial, fechaInicio, tipoEmpresa);	
	    
	    
	    //validar que no haya duplicados
	    validarDuplicado(codigo, ruc);
	    
		
		//Creamos un cliente
		Cliente nuevoCliente = new Cliente(codigo, ruc, 
				razonSocial, fechaInicio, tipoEmpresa, 
				empleados);
		//añaden a la lista
        clientes.add(nuevoCliente);
	}


	private void validarDuplicado(String codigo, String ruc)
			throws PeruBankException {		
	    
        if(clienteExiste(codigo, ruc)) 
        	throw new PeruBankException("Cliente Duplicado");
	}


	private boolean clienteExiste(String codigo, String ruc) {
		boolean existe = false;
	    
	    //   and &&   , || or
        for(Cliente cliente : clientes)
            if (cliente.getCodigo().equals(codigo) ||
                cliente.getRuc().equals(ruc))
                existe = true;
		return existe;
	}


	private void validarDatos(String codigo, String ruc, String razonSocial,
			String fechaInicio, String tipoEmpresa) throws PeruBankException {
		String mensaje = "";
	    if (codigo.equals(""))
	        mensaje += "Codigo no puede ser vacio";
	    if (ruc.equals(""))
	        mensaje += "\nRuc no puede ser vacio";
	    if (razonSocial.equals(""))
	        mensaje += "\nRazon social no puede ser vacio";
	    if (fechaInicio.equals(""))
	        mensaje += "\nFecha de inicio no puede ser vacio";
	    if (tipoEmpresa.equals(""))
	        mensaje += "\nTipo de empresa no puede ser vacio";
	    if (! mensaje.equals(""))
	        throw  new PeruBankException(mensaje);
	}

	public Cliente buscarCliente(String codigo) {
        for(Cliente cliente : clientes)
            if (cliente.getCodigo().equals(codigo))
                return cliente;
        return null;
	}
	
	public Cliente buscarClienteRuc(String ruc) {
        for(Cliente cliente : clientes)
            if (cliente.getRuc().equals(ruc))
                return cliente;
        return null;
	}

}

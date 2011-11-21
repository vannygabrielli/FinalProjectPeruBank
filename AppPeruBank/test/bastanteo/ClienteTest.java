package bastanteo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClienteTest {

	
	
	@Test
	public void clienteDeberiaCrearseConDatosIniciales(){
		
		//Preparo el escenario	
        String ruc = "20565455656";
        String codigo = "CL001";
        String razonSocial = "ACME Solutions";
        String fechaInicio = "01/01/2010";
        String tipoEmpresa = "SAC";
        int empleados = 10;
        
		//Ejecuto el escenario
        Cliente cliente = new Cliente(codigo, ruc,
        		razonSocial, fechaInicio, tipoEmpresa, empleados);
		
		//Verifico
        assertEquals(codigo, cliente.getCodigo());
        assertEquals(ruc, cliente.getRuc());
        assertEquals(razonSocial, cliente.getRazonSocial());
        assertEquals(fechaInicio, cliente.getFechaInicio());
        assertEquals(tipoEmpresa, cliente.getTipoEmpresa());
        assertEquals(empleados, cliente.getEmpleados());   
		
	}
}

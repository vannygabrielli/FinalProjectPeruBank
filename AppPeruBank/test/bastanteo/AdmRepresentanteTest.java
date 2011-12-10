package bastanteo;

import org.junit.Test;
import static org.junit.Assert.*;

public class AdmRepresentanteTest {

	@Test
	public void representanteDeberiaCrearseconDatosIniciales()
			throws PeruBankException {

		//Arranque preparar el escenario
		String codigoRep = "REP001";
		String nombreRep = "Derwin Ramos";
		String dni = "40782665";
		String tipoDoc = "DNI";
		String codigoCliente = "CL001";
		String codigoGrupoBastanteo = "A";
		String cargo = "Contador";
		String codigoUsuario = "US001";

		//Ejecutar
		Representante rep = new Representante(codigoRep, nombreRep, dni,
				tipoDoc, codigoCliente, codigoGrupoBastanteo, cargo,
				codigoUsuario);

		//Validar datos ingresados
		assertEquals(codigoRep, rep.getCodigoRep());
		assertEquals(dni, rep.getDni());
		assertEquals(tipoDoc, rep.getTipoDoc());
		assertEquals(codigoCliente, rep.getCodigoCliente());
		assertEquals(codigoGrupoBastanteo, rep.getCodigoGrupoBastanteo());
		assertEquals(cargo, rep.getCargo());
		assertEquals(codigoUsuario, rep.getCodigoUsuario());
	}
	
	@Test
	public void siIngresoDatosDeberiaRegistrarRepresentante()
			throws PeruBankException {

		//Arranque preparar el escenario
		
		// Cliente
		/*String codigoCliente = "CL001";
		String ruc = "12232720907";
		String razonSocial = "Extreme IT Solutions";
		String fechaInicio = "01/01/2010";
		String tipoEmpresa = "SAC";
		int empleados = 10;
		
		AdmClientes admCliente = new AdmClientes();
		admCliente.registrarCliente(codigoCliente, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);*/

		// Representante
		String codigoRep = "REP001";
		String nombreRep = "Derwin Ramos";
		String dni = "40782665";
		String tipoDoc = "DNI";
		String codigoCliente = "CL001";
		String codigoGrupoBastanteo = "A";
		String cargo = "Contador";
		String codigoUsuario = "US001";
				
		AdmRepresentante admRep = new AdmRepresentante();

		//Ejecutar
		//Representante cliente = rep.buscarRepresentante(codigoClienteRep);
		//String nuevoCodigoClienteRep = cliente.getCodigoCliente();

		//rep.registrarRepresentante(codigoRep, nombreRep, dni, tipoDoc,
		//		nuevoCodigoClienteRep, codigoGrupoBastanteo, cargo, codigoUsuario);
		
		admRep.registrarRepresentante(codigoRep, nombreRep, dni, tipoDoc,
				codigoCliente, codigoGrupoBastanteo, cargo,
				codigoUsuario);
		
		Representante representante = admRep.buscarRepresentante(codigoRep);

		//Validar datos registrados sean correctos
		assertNotNull(representante);
		
		//validar datos ingresados
		assertEquals(codigoRep, representante.getCodigoRep());
		assertEquals(dni, representante.getDni());
		assertEquals(tipoDoc, representante.getTipoDoc());
		assertEquals(codigoCliente, representante.getCodigoCliente());
		assertEquals(codigoGrupoBastanteo, representante.getCodigoGrupoBastanteo());
		assertEquals(cargo, representante.getCargo());
		assertEquals(codigoUsuario, representante.getCodigoUsuario());
		
	}

	@Test(expected = PeruBankException.class)
	public void deberiaValidarDatosRequeridos() throws PeruBankException {

		//Arranque preparar el escenario
		String codigoRep = "REP001";
		String nombreRep = "";
		String dni = "";
		String tipoDoc = "DNI";
		String codigoCliente = "CL001";
		String codigoGrupoBastanteo = "A";
		String cargo = "Contador";
		String codigoUsuario = "US001";
		AdmRepresentante adm = new AdmRepresentante();

		//Ejecutar
		adm.registrarRepresentante(codigoRep, nombreRep, dni, tipoDoc,
				codigoCliente, codigoGrupoBastanteo, cargo, codigoUsuario);
	}

	@Test(expected = PeruBankException.class)
	public void noDeberiaRegistrarRepresentantesDuplicados()
			throws PeruBankException {
	
		//Arranque preparar el escenario
		
		String codigoRep = "REP001";
		String nombreRep = "Derwin Ramos";
		String dni = "40782665";
		String tipoDoc = "DNI";
		String codigoCliente = "CL001";
		String codigoGrupoBastanteo = "A";
		String cargo = "Contador";
		String codigoUsuario = "US001";
		AdmRepresentante adm = new AdmRepresentante();

		// Ejecutar
		// El primero se ejecuta sin problemas
		adm.registrarRepresentante(codigoRep, nombreRep, dni, tipoDoc,
				codigoCliente, codigoGrupoBastanteo, cargo, codigoUsuario);

		// El segundo debe arrojar la exception
		adm.registrarRepresentante(codigoRep, nombreRep, dni, tipoDoc,
				codigoCliente, codigoGrupoBastanteo, cargo, codigoUsuario);
	}
}
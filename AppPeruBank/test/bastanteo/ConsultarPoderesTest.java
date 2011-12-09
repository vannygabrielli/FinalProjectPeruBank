package bastanteo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
//Prueba de Trabajo colaborativo atraves de GitHub 
//Prueba de merge - Eduardo

public class ConsultarPoderesTest {
	AdmClientes admClientes = new AdmClientes();
	AdmPoderes admPod = new AdmPoderes();
	AdmBastanteo admBastanteo = new AdmBastanteo();
	AdmRepresentante admRepresentante = new AdmRepresentante();
	@Before
	public void cargarListas() throws PeruBankException{
		// Administraci�n de Clientes
			

		admClientes.registrarCliente("CLI001", "20202020", "Nestle Per�",
				"12/01/1980", "SAC", 3500);
		admClientes.registrarCliente("CLI002", "30303030", "Latin Corporation",
				"23/01/1990", "SAC", 1000);
		admClientes.registrarCliente("CLI003", "40404040", "Negusa",
				"11/11/1999", "SA", 500);
		admClientes.registrarCliente("CLI004", "50505050",
				"Importaciones Barzolla", "10/12/1980", "EIRL", 800);
		admClientes.registrarCliente("CLI005", "60606060",
				"Samsung Technologies", "09/11/1995", "SAC", 200);

		// Administraci�n de Poderes
		
		admPod.registrarPoderes("P001", "Pago salario personal administrativo",
				"Activo", "US001");
		admPod.registrarPoderes("P002", "Pago salario personal seguridad",
				"Activo", "US001");
		admPod.registrarPoderes("P003",
				"Pago de servicios de luz,agua y tel�fono", "Activo", "US001");
		admPod.registrarPoderes("P004",
				"Contrato por alquiler de local comercial", "Activo", "US001");
		admPod.registrarPoderes("P005",
				"Firma para autorizaci�n de compra de equipos de c�mputo",
				"Activo", "US001");

		// Administraci�n de Bastanteos

		

		admBastanteo.registrarBastanteo("A",
				"Gerente de RR.HH, Administraci�n y Log�stica", "P001",
				"Solo firma", "10/08/2010", 300.00, "US001");
		admBastanteo.registrarBastanteo("B", "Socios minoritarios", "P002",
				"Solo firma", "11/11/2011", 300.00, "US001");
		admBastanteo.registrarBastanteo("C",
				"Administrador, Contador y Jefe de Log�stica", "P003",
				"En conjunto con las personas del grupo", "09/08/2010", 300.00,
				"US001");

		// Administraci�n de Representantes
		

		admRepresentante.registrarRepresentante("REP001", "Derwin Ramos",
				"40782665", "DNI", "CLI001", "A", "Gerente de Administraci�n",
				"US001");
		admRepresentante.registrarRepresentante("REP002", "Omar De La Cruz",
				"40712565", "DNI", "CLI001", "B", "Socio", "US001");
		admRepresentante.registrarRepresentante("REP003", "Eduardo Ortega",
				"45212565", "DNI", "CLI002", "A", "Gerente de RR.HH", "US001");
		admRepresentante.registrarRepresentante("REP004", "Renzo Lambert",
				"40722565", "DNI", "CLI002", "B", "Socio", "US001");
		admRepresentante.registrarRepresentante("REP005", "Eduardo Ortega",
				"45012565", "DNI", "CLI003", "A", "Gerente de Administraci�n",
				"US001");
		admRepresentante.registrarRepresentante("REP006",
				"Hermenegildo Condori", "402012565", "DNI", "CLI003", "B",
				"Socio", "US001");
	}
	

	@Test
	public void deberiaDevolverLaInformacionBuscada() throws PeruBankException{
		String dni = "40782665";
		String ruc = "20202020";
		String tipoIntervencion = "Solo firma";
		String codigoGrupoBastanteo = "A";

		
		
		
		

		assertEquals(dni,admRepresentante.buscarRepresentante(dni).getDni());
		assertEquals(ruc, admClientes.buscarCliente(ruc).getRuc());
		assertEquals(codigoGrupoBastanteo,
				admRepresentante.buscarRepresentante(dni).getCodigoGrupoBastanteo());
		assertEquals(tipoIntervencion, admBastanteo.buscarBastanteo(codigoGrupoBastanteo).getTipoIntervencion());
		
		 

	}

}

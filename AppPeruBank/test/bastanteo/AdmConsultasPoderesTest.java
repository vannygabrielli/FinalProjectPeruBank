package bastanteo;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdmConsultasPoderesTest {

	AdmClientes admClientes = new AdmClientes();
	AdmPoderes admPod = new AdmPoderes();
	AdmBastantear admBastantear = new AdmBastantear();
	AdmRepresentante admRepresentante = new AdmRepresentante();

	@Before
	public void cargarTodasListas() throws PeruBankException {
		// Arranque preparar el escenario
		// Clientes
		admClientes.registrarCliente("CLI001", "20202020", "Nestle Perú",
				"12/01/1980", "SAC", 3500);
		admClientes.registrarCliente("CLI002", "30303030", "Latin Corporation",
				"23/01/1990", "SAC", 1000);
		admClientes.registrarCliente("CLI003", "40404040", "Negusa",
				"11/11/1999", "SA", 500);
		admClientes.registrarCliente("CLI004", "50505050",
				"Importaciones Barzolla", "10/12/1980", "EIRL", 800);
		admClientes.registrarCliente("CLI005", "60606060",
				"Samsung Technologies", "09/11/1995", "SAC", 200);

		// Poderes
		admPod.registrarPoderes("P001", "Pago salario personal administrativo",
				"Activo", "US001");
		admPod.registrarPoderes("P002", "Pago salario personal seguridad",
				"Activo", "US001");
		admPod.registrarPoderes("P003",
				"Pago de servicios de luz,agua y teléfono", "Activo", "US001");
		admPod.registrarPoderes("P004",
				"Contrato por alquiler de local comercial", "Activo", "US001");
		admPod.registrarPoderes("P005",
				"Firma para autorización de compra de equipos de cómputo",
				"Activo", "US001");

		// Bastanteo
		admBastantear.registrarBastanteo("CL001", "A", "A", "CHCO", "B", "USD",
				2500.00, "OCRUZ", Calendar.getInstance(),
				Calendar.getInstance());
		admBastantear
				.registrarBastanteo("CL001", "B", "A", "EFRE", "B", "USD",
						800.00, "OCRUZ", Calendar.getInstance(),
						Calendar.getInstance());

		// Administración de Representantes
		admRepresentante.registrarRepresentante("REP001", "Derwin Ramos",
				"40782665", "DNI", "CLI001", "A", "Gerente de Administración",
				"US001");
		admRepresentante.registrarRepresentante("REP002", "Omar De La Cruz",
				"40712565", "DNI", "CLI001", "B", "Socio", "US001");
		admRepresentante.registrarRepresentante("REP003", "Eduardo Ortega",
				"45212565", "DNI", "CLI002", "A", "Gerente de RR.HH", "US001");
		admRepresentante.registrarRepresentante("REP004", "Renzo Lambert",
				"40722565", "DNI", "CLI002", "B", "Socio", "US001");
		admRepresentante.registrarRepresentante("REP005", "Eduardo Ortega",
				"45012565", "DNI", "CLI003", "A", "Gerente de Administración",
				"US001");
		admRepresentante.registrarRepresentante("REP006",
				"Hermenegildo Condori", "402012565", "DNI", "CLI003", "B",
				"Socio", "US001");
	}

	@Test
	public void siIngresoDatosRepresentantesDeberiaConsultarPoder()
			throws PeruBankException {
		// Arranque preparar el escenario
		// Preparar datos de busqueda
		String dniRepresentante = "40782665";
		String rucCliente = "20202020";
		String codigoGrupoBastanteo = "A";

		// ejecutar
		// Buscar Representante
		Representante representanteRetorno = admRepresentante
				.buscarRepresentanteDni(dniRepresentante);

		// Validar objeto representante diferente de null
		assertNotNull(representanteRetorno);

		// Buscar cliente
		Cliente clienteRetorno = admClientes.buscarClienteRuc(rucCliente);

		// Validar objeto clienteRetorno diferente de null
		assertNotNull(clienteRetorno);

		// Buscar bastanteo
		Bastanteo bast = admBastantear.buscarBastanteo(codigoGrupoBastanteo);

		// Validar objeto bastanteo diferente de null
		assertNotNull(bast);

		// Verificar
		assertEquals(dniRepresentante, representanteRetorno.getDni());
		assertEquals(rucCliente, clienteRetorno.getRuc());
	}

	@Test
	public void siIngresoDatosRepresentanteValidaNoExistePoder()
			throws PeruBankException {
		// Arranque preparar el escenario
		// Preparar datos de busqueda
		String dniRepresentante = "3233333";
		String rucCliente = "12321232234";
		String codigoGrupoBastanteo = "D";

		// buscar Representante
		Representante representanteRetorno = admRepresentante
				.buscarRepresentanteDni(dniRepresentante);

		// Validar objeto representante es null - no existe
		assertNull("No existe representante", representanteRetorno);

		// buscar Cliente
		Cliente clienteRetorno = admClientes.buscarClienteRuc(rucCliente);

		// Validar objeto cliente es null - no existe
		assertNull("NO existe el cliente", clienteRetorno);

		// Buscar poder - Bastanteo
		Bastanteo bast = admBastantear.buscarBastanteo(codigoGrupoBastanteo);

		// Validar poder no existe
		assertNull("No existe poder buscado", bast);
	}
}
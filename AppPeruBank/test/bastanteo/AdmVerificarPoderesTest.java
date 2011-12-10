package bastanteo;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class AdmVerificarPoderesTest {

	@SuppressWarnings("rawtypes")
	Map<Comparable, Object> m = new HashMap<Comparable, Object>();

	AdmBastantear regbast = new AdmBastantear();

	@Before
	public void cargarListas() throws PeruBankException {

		// Arranque preparar el escenario
		Calendar FecReg = Calendar.getInstance();
		FecReg.add(FecReg.DATE, -500);

		Calendar FecVenc = Calendar.getInstance();
		// añadir 6 meses a la fecha vencimiento
		FecVenc.add(FecVenc.DATE, 180);

		// ejecutar
		regbast.registrarBastanteo("CL001", "A", "A", "CHCO", "B", "USD",
				2500.00, "US001", FecReg, FecVenc);
		m.put("40782665", new Representante("REP001", "Derwin Ramos",
				"40782665", "DNI", "CL001", "A", "Contador", "US001"));
		m.put("20565455656", new Cliente("CL001", "20565455656",
				"ACME Solutions", "01/01/2010", "SAC", 10));

		// restar a la fecha vencimiento
		FecVenc.add(FecVenc.DATE, -190);
		regbast.registrarBastanteo("CL002", "A", "A", "EFRE", "B", "USD",
				2000.00, "US001", FecReg, FecVenc);
		m.put("30782665", new Representante("REP002", "Carlos santana",
				"30782665", "DNI", "CL002", "A", "Contador", "US001"));
		m.put("30565455656", new Cliente("CL002", "30565455656", "Rios Mares",
				"01/01/2009", "SAC", 10));
	}

	@Test
	public void siIngresoDatosRepresentanteValidaTienePoder() throws PeruBankException {

		// Arranque preparar el escenario
		// Preparar datos de busqueda
		String rucCliente = "20565455656";
		String dniRepresentante = "40782665";
		String codPoder = "CHCO";
		Double importe = 2500.00;

		// Ejecutar

		// valida si existe el representante y el cliente
		// extrae Representante
		Representante representanteDevuelto = (Representante) m
				.get(dniRepresentante);

		// Validar que el Objeto representanteDevuelto sea distinto de null
		assertNotNull(representanteDevuelto);

		// extrae Cliente
		Cliente clienteDevuelto = (Cliente) m.get(rucCliente);

		// Validar que el Objeto clienteDevuelto sea distinto de null
		assertNotNull(clienteDevuelto);

		// verifica si el representante y cliente ingresados estan asociados
		assertEquals(representanteDevuelto.getCodigoCliente(),
				clienteDevuelto.getCodigo());

		Bastanteo bastanteo = regbast.buscarBastanteoporRepresentante(
				representanteDevuelto.getCodigoGrupoBastanteo(), codPoder,
				importe);

		// Verificar
		// Validar que el Objeto bastanteo sea distinto de null
		assertNotNull(bastanteo);
	}

	@Test
	public void siIngresoDatosRepresentanteValidaFechaVencimientoDelPoder()
			throws PeruBankException {

		// Arranque preparar el escenario
		// Preparar datos de busqueda
		String rucCliente = "30565455656";
		String dniRepresentante = "30782665";
		String codPoder = "EFRE";
		Double importe = 2000.00;

		// Ejecutar

		// valida si existe el representante y el cliente
		// extrae Representante
		Representante representanteDevuelto = (Representante) m
				.get(dniRepresentante);

		// Validar que el Objeto representanteDevuelto sea distinto de null
		assertNotNull(representanteDevuelto);

		// extrae Cliente
		Cliente clienteDevuelto = (Cliente) m.get(rucCliente);

		// Validar que el Objeto clienteDevuelto sea distinto de null
		assertNotNull(clienteDevuelto);

		// verifica si el representante y cliente ingresados estan asociados
		assertEquals(representanteDevuelto.getCodigoCliente(),
				clienteDevuelto.getCodigo());

		Bastanteo bastanteo = regbast.buscarBastanteoporRepresentante(
				representanteDevuelto.getCodigoGrupoBastanteo(), codPoder,
				importe);

		// Verificar
		// Validar que el Objeto bastanteo sea distinto de null
		assertNotNull(bastanteo);

		// Calendar dd = Calendar.getInstance();
		// Validar fecha vencimiento es diferente de la fecha actual
		assertNotEquals(bastanteo.getFecVenc(), Calendar.getInstance());
	}

	@Test
	public void siIngresoDatosRepresentanteValidaqueExista()
			throws PeruBankException {

		// Arranque preparar el escenario
		// Preparar datos de busqueda
		String rucCliente = "30565455656";
		String dniRepresentante = "30782665";
		String codPoder = "EFRE";
		Double importe = 2000.00;

		// Ejecutar

		// valida si existe el representante y el cliente
		// extrae Representante
		Representante representanteDevuelto = (Representante) m
				.get(dniRepresentante);

		// Validar que el Objeto representanteDevuelto sea distinto de null
		assertNotNull(representanteDevuelto);
	}
	
	@Test(expected = PeruBankException.class)
	public void siIngresoDatosRepresentanteValidaImporteSuperior()
			throws PeruBankException {

		// Arranque preparar el escenario
		// Preparar datos de busqueda
		String rucCliente = "30565455656";
		String dniRepresentante = "30782665";
		String codPoder = "EFRE";
		Double importe = 1000.00;

		// Ejecutar

		// valida si existe el representante y el cliente
		// extrae Representante
		Representante representanteDevuelto = (Representante) m
				.get(dniRepresentante);

		// Validar que el Objeto representanteDevuelto sea distinto de null
		assertNotNull(representanteDevuelto);

		// extrae Cliente
		Cliente clienteDevuelto = (Cliente) m.get(rucCliente);

		// Validar que el Objeto clienteDevuelto sea distinto de null
		assertNotNull(clienteDevuelto);

		// verifica si el representante y cliente ingresados estan asociados
		assertEquals(representanteDevuelto.getCodigoCliente(),
				clienteDevuelto.getCodigo());

		Bastanteo bastanteo = regbast.buscarBastanteoporRepresentante(
				representanteDevuelto.getCodigoGrupoBastanteo(), codPoder,
				importe);

		// Verificar
		// Validar que el Objeto bastanteo sea distinto de null
		assertNotNull(bastanteo);
	}
	

	private Boolean assertNotEquals(Object expected, Object actual)
			throws PeruBankException {
		if (expected != actual) {
			return true;
		}
		throw new PeruBankException(
				"Los parametros ingresados no son correctos");
	}
}

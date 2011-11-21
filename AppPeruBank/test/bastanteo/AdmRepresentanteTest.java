package bastanteo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdmRepresentanteTest {

	@Test
	public void siIngresoDatosDeberiaRegistrarRepresentante()
			throws PeruBankException {

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

		// Ejecutar

		admRep.registrarRepresentante(codigoRep, nombreRep, dni, tipoDoc,
				codigoCliente, codigoGrupoBastanteo, cargo, codigoUsuario);

		Representante representante = admRep.buscarRepresentante(codigoRep);

		// Validar datos registrados sean correctos
		assertNotNull(representante);
		assertEquals(codigoRep, representante.getCodigoRep());
		assertEquals(dni, representante.getDni());
		assertEquals(tipoDoc, representante.getTipoDoc());
		assertEquals(codigoCliente, representante.getCodigoCliente());
		assertEquals(codigoGrupoBastanteo,
				representante.getCodigoGrupoBastanteo());
		assertEquals(cargo, representante.getCargo());
		assertEquals(codigoUsuario, representante.getCodigoUsuario());

	}

	@Test(expected = PeruBankException.class)
	public void deberiaValidarDatosRequeridos() throws PeruBankException {

		// preparar el ejemplo
		String codigoRep = "REP001";
		String nombreRep = "";
		String dni = "";
		String tipoDoc = "DNI";
		String codigoCliente = "CL001";
		String codigoGrupoBastanteo = "A";
		String cargo = "Contador";
		String codigoUsuario = "US001";

		AdmRepresentante adm = new AdmRepresentante();
		int cantidadRepEsperado = adm.cantidadDeRepresentante();
		// ejecutar
		adm.registrarRepresentante(codigoRep, nombreRep, dni, tipoDoc,
				codigoCliente, codigoGrupoBastanteo, cargo, codigoUsuario);
		int cantidadRepDevuelto = adm.cantidadDeRepresentante();

		// Assert
		assertEquals(cantidadRepEsperado, cantidadRepDevuelto-1);

	}

	@Test(expected = PeruBankException.class)
	public void noDeberiaRegistrarRepresentantesDuplicados()
			throws PeruBankException {

		// Arrange
		String codigoRep = "REP001";
		String nombreRep = "Derwin Ramos";
		String dni = "40782665";
		String tipoDoc = "DNI";
		String codigoCliente = "CL001";
		String codigoGrupoBastanteo = "A";
		String cargo = "Contador";
		String codigoUsuario = "US001";
		AdmRepresentante adm = new AdmRepresentante();

		// ejecutar

		int cantidadRepEsperado = adm.cantidadDeRepresentante();

		adm.registrarRepresentante(codigoRep, nombreRep, dni, tipoDoc,
				codigoCliente, codigoGrupoBastanteo, cargo, codigoUsuario);

		// el segundo debe arrojar la exception
		adm.registrarRepresentante(codigoRep, nombreRep, dni, tipoDoc,
				codigoCliente, codigoGrupoBastanteo, cargo, codigoUsuario);

		int cantidadRepDevuelto = adm.cantidadDeRepresentante();

		// Assert
		assertEquals(cantidadRepEsperado + 1, cantidadRepDevuelto);

	}

}

package bastanteo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdmPoderesTest {

	// Ingresar datos correctos
	@Test
	public void siIngresoDatosDeberiaRegistrarPoderes()
			throws PeruBankException {

		//Arranque preparar el escenario
		String codigoPoder = "CHCO";
		String desPoder = "Cobro de cheques";
		String tipProd = "Activo";
		String codUsuario = "US001";

		AdmPoderes adm = new AdmPoderes();

		//Ejecutar
		adm.registrarPoderes(codigoPoder, desPoder, tipProd, codUsuario);

		Poder poder = adm.buscarPoder(codigoPoder);

		//Validar objeto poder diferente de null
		assertNotNull(poder);

		//Validar datos registrados sean correctos
		assertEquals(poder.getCodigoPoder(), codigoPoder);
		assertEquals(poder.getDesPoder(), desPoder);
		assertEquals(poder.getTipProducto(), tipProd);
		assertEquals(poder.getCodUsuario(), codUsuario);
	}

	// valida datos requeridos
	@Test(expected = PeruBankException.class)
	public void deberiaValidarDatosRequeridos() throws PeruBankException {

		//Arranque preparar el escenario
		String codigoPoder = "";
		String desPoder = "Cobro de cheques";
		String tipProd = "Activo";
		String CodUser = "";

		AdmPoderes adm = new AdmPoderes();

		//Ejecutar
		adm.registrarPoderes(codigoPoder, desPoder, tipProd, CodUser);
	}

	// Validar registro de un poder duplicado
	@Test(expected = PeruBankException.class)
	public void siIngresoDatosDuplicadosNoDeberiaRegistrarPoderes()
			throws PeruBankException {

		//Arranque preparar el escenario
		String codigoPoder = "CHCO";
		String desPoder = "Retiro Efectivo";
		String tipProd = "Activo";
		String codUsuario = "US001";

		AdmPoderes adm = new AdmPoderes();

		//Ejecutar
		//El primero se ejecuta sin problemas
		adm.registrarPoderes(codigoPoder, desPoder, tipProd, codUsuario);

		//El segundo debe arrojar el exception, registro duplicado
		adm.registrarPoderes(codigoPoder, desPoder, tipProd, codUsuario);
	}
}

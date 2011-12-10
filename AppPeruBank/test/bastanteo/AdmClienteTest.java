package bastanteo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AdmClienteTest {

	@Test
	public void siIngresoDatosDeberiaRegistrarCliente()
			throws PeruBankException {

		// preparamos el ejemplo
		String ruc = "12232720907";
		String codigo = "CL001";
		String razonSocial = "Extreme IT Solutions";
		String fechaInicio = "01/01/2010";
		String tipoEmpresa = "SAC";
		int empleados = 10;
		AdmClientes adm = new AdmClientes();

		// ejecutar
		adm.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);

		Cliente cliente = adm.buscarCliente(codigo);
		// Verificar
		assertNotNull(cliente);
	}

	@Test(expected = PeruBankException.class)
	public void deberiaValidarDatosRequeridos() throws PeruBankException {

		// preparar el ejemplo
		String ruc = "";
		String codigo = "";
		String razonSocial = "";
		String fechaInicio = "01/01/2010";
		String tipoEmpresa = "SAC";
		int empleados = 10;
		AdmClientes adm = new AdmClientes();

		// ejecutar
		adm.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);

	}

	@Test(expected = PeruBankException.class)
	public void noDeberiaRegistrarClientesDuplicados() throws PeruBankException {
		// preparamos el escenario
		// Arranque
		String ruc = "12232720907";
		String codigo = "CL001";
		String razonSocial = "Extreme IT Solutions";
		String fechaInicio = "01/01/2010";
		String tipoEmpresa = "SAC";
		int empleados = 10;
		AdmClientes adm = new AdmClientes();

		// ejecutar
		// el primero se ejecuta sin problemas
		adm.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);

		// el segundo debe arrojar la exception
		adm.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);

	}
}
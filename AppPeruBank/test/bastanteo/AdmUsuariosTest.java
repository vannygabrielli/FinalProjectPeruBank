package bastanteo;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class AdmUsuariosTest {

	// Arranque preparar el escenario
	String codigoUsuario = "U00002";
	String ctaUsuario = "RORTEGA";
	String password = "KLKJ1232";
	String codigoRol = "R00002";

	// Rol
	boolean estado = true;

	@SuppressWarnings("rawtypes")
	Map<Comparable, Object> m = new HashMap<Comparable, Object>();

	@Before
	public void cargarListas() {
		// Roles
		m.put(1, new Rol("R0001", "Administrador"));
		m.put(2, new Rol("R0002", "Abogado"));
		m.put(3, new Rol("R0003", "Supervisor"));
		m.put(4, new Rol("R0004", "PersonalAgencia"));

		m.put("DRAMOS", new Usuario("U00001", "DRAMOS", "j0123456"));
		m.put("RORTEGA", new Usuario("U00002", "RORTEGA", "KLKJ1232"));

		m.put("U00001", new RolUsuario("U00001", "R0001", true));
		m.put("U00002", new RolUsuario("U00002", "R0002", true));

		m.put("R0001", new OpcionRol("P00001", 1, "R0001", true));
		m.put("R0002", new OpcionRol("P00002", 2, "R0002", true));
	}

	@Test
	public void siIngresoDatosDeberiaRegistrarUsuario()
			throws PeruBankException {

		// Ejecutar
		AdmUsuarios adm = new AdmUsuarios();
		adm.registrarUsuarios(codigoUsuario, ctaUsuario, password, codigoRol);

		Usuario usuario = adm.buscarUsuario(codigoUsuario);

		// Validar objeto poder diferente de null
		assertNotNull(usuario);

		// Verificar
		// Validar datos registrados sean correctos
		assertEquals(usuario.getCodigoUsuario(), codigoUsuario);
		assertEquals(usuario.getCtaUsuario(), ctaUsuario);
		assertEquals(usuario.getPassword(), password);
	}

	@Test
	public void siIngresoDatosDeberiaAsignarRolaUsuario() throws PeruBankException {
		// Ejecutar
		AdmUsuarios adm = new AdmUsuarios();
		adm.registrarUsuarios(codigoUsuario, ctaUsuario, password, codigoRol);

		Usuario usuario = adm.buscarUsuario(codigoUsuario);

		// Validar objeto poder diferente de null
		assertNotNull(usuario);

		AdmRolUsuario admRolUsuario = new AdmRolUsuario();

		// Validar los datos del usuario registrados
		assertEquals(usuario.getCodigoUsuario(), codigoUsuario);
		assertEquals(usuario.getCtaUsuario(), ctaUsuario);
		assertEquals(usuario.getPassword(), password);

		// Asignar el rol
		admRolUsuario.asignarRolUsuarios(usuario.getCodigoUsuario(), codigoRol,
				estado);

		RolUsuario rolUsuario = admRolUsuario.buscarRolPoUsuario(usuario
				.getCodigoUsuario());

		// Validar objeto poder diferente de null
		assertNotNull(rolUsuario);

		// Verificar
		// Validar datos registrados sean correctos
		assertEquals(rolUsuario.getCodigoRol(), codigoRol);
		assertEquals(rolUsuario.getCodigoUsuario(), usuario.getCodigoUsuario());
	}

	@Test
	public void siIngrespUsuarioDeberiaValidarSiExiste() {
		// Cargar los datos de un usuario
		Usuario usuarioIngreso = new Usuario(codigoUsuario, ctaUsuario,
				password);// , codigoRol

		Usuario usuariodevuelto = (Usuario) m.get(usuarioIngreso
				.getCtaUsuario());

		// Validar que el Objeto usuario sea distinto de null
		assertNotNull(usuariodevuelto);

		// validar usuario y pasword ingresado
		assertEquals(usuarioIngreso.getCtaUsuario(),
				usuariodevuelto.getCtaUsuario());
		assertEquals(usuarioIngreso.getPassword(),
				usuariodevuelto.getPassword());

		// extrae rol del usuario
		RolUsuario rolUsuarioDevuelto = (RolUsuario) m.get(usuariodevuelto
				.getCodigoUsuario());

		// Validar que el Objeto rolUsuarioDevuelto sea distinto de null
		assertNotNull(rolUsuarioDevuelto);

		// extraer opciones del rol
		OpcionRol opcionRolDevuelto = (OpcionRol) m.get(rolUsuarioDevuelto
				.getCodigoRol());

		// Verificar
		// Validar que el Objeto opcionRolDevuelto sea distinto de null
		assertNotNull(opcionRolDevuelto);
	}
}
package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmRolUsuario {

	List<RolUsuario> rolUsuarios;

	public AdmRolUsuario() {

		if (rolUsuarios == null) {
			rolUsuarios = new ArrayList<RolUsuario>();
		}
	}

	public void registrarRol(String codigoUsuario, String codigoRol,
			Boolean estado) throws PeruBankException {
		// TODO Auto-generated method stub
		String mensaje = "";

		// validar datos ingresados
		validarDatos(codigoUsuario, codigoRol, estado);

		// validar que no haya duplicados
		validarDuplicado(codigoUsuario, codigoRol);

		// Creamos un cliente
		RolUsuario rolUsuario = new RolUsuario(codigoUsuario, codigoRol, estado);
		// añaden a la lista
		rolUsuarios.add(rolUsuario);
	}

	private void validarDuplicado(String codigoUsuario, String codigoRol)
			throws PeruBankException {

		if (rolUsuarioExiste(codigoUsuario, codigoRol))
			throw new PeruBankException("Rol y Usuario Duplicado");
	}

	private boolean rolUsuarioExiste(String codigoUsuario, String codigoRol) {
		boolean existe = false;
		for (RolUsuario rolUsuario : rolUsuarios)
			if (rolUsuario.getCodigoUsuario().equals(codigoUsuario)
					&& rolUsuario.getCodigoRol().equals(codigoRol))
				existe = true;
		return existe;
	}

	private void validarDatos(String codigoUsuario, String codigoRol,
			Boolean estado) throws PeruBankException {
		String mensaje = "";

		if (codigoUsuario.equals(""))
			mensaje += "\nCodigo usuario no puede ser vacio";
		if (codigoRol.equals(""))
			mensaje += "\nCodigo Rol no puede ser vacio";
		if (estado.equals(""))
			mensaje += "\nEstado no puede ser vacio";
		if (!mensaje.equals(""))
			throw new PeruBankException(mensaje);
	}

	public void asignarRolUsuarios(String codigoUsuario, String codigoRol,
			Boolean estado) throws PeruBankException {
		// TODO Auto-generated method stub

		AdmUsuarios admUsuarios = new AdmUsuarios();		
		// validar que exista el usuario
		if (admUsuarios.usuarioExiste(codigoUsuario) == false) {
			registrarRol(codigoUsuario, codigoRol, estado);
		}
	}

	public RolUsuario buscarRolPoUsuario(String codigoUsuario) {
		// TODO Auto-generated method stub
		for (RolUsuario rolUsuario : rolUsuarios)
			if (rolUsuario.getCodigoUsuario().equals(codigoUsuario))
				return rolUsuario;
		return null;
	}

}

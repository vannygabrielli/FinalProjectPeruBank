package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmUsuarios {
	
	List<Usuario> usuarios;
	List<RolUsuario> rolUsuarios;
	

	public AdmUsuarios() {

		if (usuarios == null) {
			usuarios = new ArrayList<Usuario>();
		}
	}

	public void registrarUsuarios(String codigoUsuario, String ctaUsuario,
			String password, String codigoRol) throws PeruBankException {
		// TODO Auto-generated method stub

		// validar datos
		validarDatos(codigoUsuario, ctaUsuario, password);

		// validar que no haya duplicados
		validarDuplicado(codigoUsuario);

		// Creamos un usuario
		Usuario nuevoUsuario = new Usuario(codigoUsuario, ctaUsuario, password);//, codigoRol
		// añaden a la lista
		usuarios.add(nuevoUsuario);

	}
	
	private void validarDuplicado(String codigoUsuario) throws PeruBankException {

		if (usuarioExiste(codigoUsuario))
			throw new PeruBankException("Usuario Duplicado");
	}
	
	public boolean usuarioExiste(String codigoUsuario) {
		boolean existe = false;
		for (Usuario usuario : usuarios)
			if (usuario.getCodigoUsuario().equals(codigoUsuario))
				existe = true;
		return existe;
	}
	
	private void validarDatos(String codigoUsuario, String ctaUsuario,
			String password) throws PeruBankException {
		String mensaje = "";
		if (codigoUsuario.equals(""))
			mensaje += "Codigo de usuario no puede ser vacio";
		if (ctaUsuario.equals(""))
			mensaje += "\nCuenta de usuario no puede ser vacio";
		if (password.equals(""))
			mensaje += "\nPassword no puede ser vacio";
		if (!mensaje.equals(""))
			throw new PeruBankException(mensaje);
	}

	public Usuario buscarUsuario(String codigoUsuario) {
		// TODO Auto-generated method stub
		for (Usuario usuario : usuarios)
			if (usuario.getCodigoUsuario().equals(codigoUsuario))
				return usuario;
		return null;
	}

}

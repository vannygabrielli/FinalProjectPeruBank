package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmPoderes {

	List<Poder> poderes;

	public AdmPoderes() {

		if (poderes == null) {
			poderes = new ArrayList<Poder>();
		}
	}

	public void registrarPoderes(String codigoPoder, String desPoder,
			String tipProducto, String codUsuario) throws PeruBankException {
		// TODO Auto-generated method stub

		// validar datos
		validarDatos(codigoPoder, desPoder, tipProducto, codUsuario);

		// validar que no haya duplicados
		validarDuplicado(codigoPoder);

		// Creamos un cliente
		Poder nuevoPoder = new Poder(codigoPoder, desPoder, tipProducto,
				codUsuario);
		// añaden a la lista
		poderes.add(nuevoPoder);
	}

	public Poder buscarPoder(String codigoPoder) {
		// TODO Auto-generated method stub

		for (Poder poder : poderes)
			if (poder.getCodigoPoder().equals(codigoPoder))
				return poder;
		return null;
	}

	private void validarDatos(String codigoPoder, String desPoder,
			String tipProducto, String codUsuario) throws PeruBankException {
		String mensaje = "";
		if (codigoPoder.equals(""))
			mensaje += "Codigo Poder no puede ser vacio";
		if (desPoder.equals(""))
			mensaje += "\nDescripcion de poder no puede ser vacio";
		if (tipProducto.equals(""))
			mensaje += "\nTipo Producto social no puede ser vacio";
		if (codUsuario.equals(""))
			mensaje += "\nCodigo Usuario no puede ser vacio";
		if (!mensaje.equals(""))
			throw new PeruBankException(mensaje);
	}

	private boolean poderExiste(String codigoPoder) {
		boolean existe = false;
		for (Poder poder : poderes)
			if (poder.getCodigoPoder().equals(codigoPoder))
				existe = true;
		return existe;
	}

	private void validarDuplicado(String codigoPoder) throws PeruBankException {

		if (poderExiste(codigoPoder))
			throw new PeruBankException("Poder Duplicado");
	}

}
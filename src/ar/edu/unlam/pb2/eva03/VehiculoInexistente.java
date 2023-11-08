package ar.edu.unlam.pb2.eva03;

public class VehiculoInexistente extends Exception {

	private String mensajeDeError;

	public VehiculoInexistente(String mensajeDeError) {
		this.mensajeDeError = mensajeDeError;
	}

}

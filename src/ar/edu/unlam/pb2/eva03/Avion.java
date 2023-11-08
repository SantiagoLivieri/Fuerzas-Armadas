package ar.edu.unlam.pb2.eva03;

public class Avion extends Vehiculo implements Volador{
	
	private Double altura;

	public Avion(Integer id, String modelo) {
		super(id, modelo);
		this.altura = 0.0;
	}

	@Override
	public double getAltura() {
		return altura;
	}

}

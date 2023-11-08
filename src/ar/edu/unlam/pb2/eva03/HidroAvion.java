package ar.edu.unlam.pb2.eva03;

public class HidroAvion extends Vehiculo implements Acuatico, Volador {

	private Double profundidad;
	private Double altura;

	public HidroAvion(Integer id, String modelo) {
		super(id, modelo);
		this.altura = 0.0;
		this.profundidad = 0.0;
	}

	@Override
	public double getAltura() {
		return altura;
	}

	@Override
	public double getProfundidad() {
		return profundidad;
	}

}

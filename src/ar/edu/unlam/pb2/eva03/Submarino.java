package ar.edu.unlam.pb2.eva03;

public class Submarino extends Vehiculo implements Acuatico{

	private Double profundidad;

	public Submarino(Integer id, String modelo) {
		super(id, modelo);
		this.profundidad = 0.0;
	}

	@Override
	public double getProfundidad() {
		return profundidad;
	}

}

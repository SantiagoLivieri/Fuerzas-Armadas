package ar.edu.unlam.pb2.eva03;

public class Destructor extends Vehiculo implements Acuatico {

	private Double profundida;

	public Destructor(Integer id, String modelo) {
		super(id, modelo);
		this.profundida = 0.0;
	}

	@Override
	public double getProfundidad() {
		return profundida;
	}

	
}

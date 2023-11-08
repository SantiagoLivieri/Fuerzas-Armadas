package ar.edu.unlam.pb2.eva03;

public class Anfibio extends Vehiculo implements Terrestre, Acuatico {

	private Double velocidad;
	private Double profundidad;

	public Anfibio(Integer id, String modelo) {
		super(id, modelo);
		this.profundidad= 0.0;
		this.velocidad = 0.0;
		
	}

	@Override
	public double getProfundidad() {
		return profundidad;
	}

	@Override
	public double getVelocidad() {
		return velocidad;
	}

}

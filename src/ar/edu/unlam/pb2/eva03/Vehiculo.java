package ar.edu.unlam.pb2.eva03;

import java.util.Objects;

public class Vehiculo {
	
	private Integer id;
	private String modelo;

	public Vehiculo(Integer id, String modelo) {
			this.id = id;
			this.modelo = modelo;
		}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(id, other.id);
	}





	


	
}

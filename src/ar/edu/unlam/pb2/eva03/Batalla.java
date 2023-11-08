package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unlam.pb2.eva03.TipoDeBatalla;
import ar.edu.unlam.pb2.eva03.VehiculoIncompatible;
import ar.edu.unlam.pb2.eva03.Acuatico;
import ar.edu.unlam.pb2.eva03.Terrestre;
import ar.edu.unlam.pb2.eva03.Volador;

public class Batalla {
	
	private Double latitud;
	private Double longitud;
	private TipoDeBatalla tipo;
	Set<Vehiculo> vehiculosEnLaBatalla;
	private String string;
	
	
	public Batalla(String string, TipoDeBatalla tipo, double latitud2, double longitud2) {
		this.string = string;
		this.tipo = tipo;
		this.latitud = latitud2;
		this.longitud = longitud2;
		vehiculosEnLaBatalla = new HashSet<Vehiculo>();
	}
	
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public TipoDeBatalla getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeBatalla tipo) {
		this.tipo = tipo;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Set<Vehiculo> getVehiculosEnLaBatalla() {
		return vehiculosEnLaBatalla;
	}

	public void setVehiculosEnLaBatalla(Set<Vehiculo> vehiculosEnLaBatalla) {
		this.vehiculosEnLaBatalla = vehiculosEnLaBatalla;
	}

	public Boolean agregarVehiculoALaBatalla(Vehiculo nuevo)throws VehiculoIncompatible {
		switch (tipo) {
		case TERRESTRE: {
			if(nuevo instanceof Terrestre) {
				vehiculosEnLaBatalla.add(nuevo);
				return true;
			}else {
				throw new VehiculoIncompatible("la batalla es en tierra");
				}
		}
		case NAVAL:
			if(nuevo instanceof Acuatico) {
				vehiculosEnLaBatalla.add(nuevo);
				return true;
			}else {
				throw new VehiculoIncompatible("la batalla es acuatica");
			}
		case AEREA:
			if(nuevo instanceof Volador) {
				vehiculosEnLaBatalla.add(nuevo);
				return true;
			}else {
				throw new VehiculoIncompatible("la batalla es AERA");
			}
			
		}return false;
	}
	
	
	
}

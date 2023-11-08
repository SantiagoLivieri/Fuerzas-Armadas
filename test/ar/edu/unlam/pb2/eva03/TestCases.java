package ar.edu.unlam.pb2.eva03;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.eva03.TipoDeBatalla;

public class TestCases {

	@Test
	public void queSePuedaCrearUnObjetoVolador() {
		Volador avion = new Avion(1, "A-10");

		assertEquals(0.0, avion.getAltura(), 0.01);
	}

	@Test
	public void queSePuedaCrearUnObjetoTerrestre() {
		Terrestre tanque = new Tanque(5, "Renault FT");

		assertEquals(0.0, tanque.getVelocidad(), 0.1);
	}
	
	@Test
	public void queSePuedaCrearUnObjetoAcuatico() {
		Acuatico submarino = new Submarino(8, "ARA - San Juan");

		assertEquals(0.0, submarino.getProfundidad(), 0.01);
	}


	@Test
	public void queSePuedaCrearUnObjetoAnfibio() {
		Anfibio var = new Anfibio(12, "LARC-5");

	
		assertEquals(0.0, var.getVelocidad(), 0.01);
		assertEquals(0.0, var.getProfundidad(), 0.01);
	}
	
	@Test
	public void queSePuedaCrearUnHidroavion() {
		HidroAvion ag600 = new HidroAvion(12, "AG600");

		
		assertEquals(0.0, ag600.getAltura(), 0.01);
		assertEquals(0.0, ag600.getProfundidad(), 0.01);
	}
	
	@Test
	public void queSePuedaArmarElConvoy() {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Avion(1, "A-10"));
		argentina.agregarVehiculo(new Avion(2, "A-10"));
		argentina.agregarVehiculo(new Avion(3, "F-102"));
		argentina.agregarVehiculo(new Avion(4, "F-15"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Submarino(8, "ARA - San Juan"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(12, "Mitsubishi F1M"));
		argentina.agregarVehiculo(new HidroAvion(12, "Mi F1M"));
		
	
		assertEquals((Integer)12, argentina.getCapacidadDeDefensa());
	}


	@Test
	public void queSePuedaCrearUnaBatalla() {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertEquals(100.5,(((Batalla) argentina.getBatalla("San Lorenzo")).getLatitud()),0.01);
		assertEquals(20.3, (((Batalla) argentina.getBatalla("San Lorenzo")).getLongitud()),0.01);
	}	


	@Test
	public void queSePuedaPlanearLaBatallaSobreElOceano() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Avion(1, "A-10"));
		argentina.agregarVehiculo(new Avion(2, "A-10"));
		argentina.agregarVehiculo(new Avion(3, "F-102"));
		argentina.agregarVehiculo(new Avion(4, "F-15"));
		
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(12, "Mitsubishi F1M"));
		argentina.agregarVehiculo(new Anfibio(12, "Mi F1M"));

		
		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 5));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 6));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 7));		
	}
	
	
	@Test
	public void queSePuedaPresentarBatallaNaval() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(12, "A-10"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10"));

		argentina.crearBatalla("Pacifico", TipoDeBatalla.NAVAL, 200.5, 45.8);

		assertTrue(argentina.enviarALaBatalla("Pacifico", 8));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 9));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 10));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 11));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 12));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 13));		
	}
	
	
	@Test (expected = VehiculoIncompatible.class)
	public void queSeNoSePuedaEnviarAUnaBatallaEnTierraUnBarco() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertFalse(argentina.enviarALaBatalla("San Lorenzo", 11));

	}

	@Test (expected = VehiculoInexistente.class)
	public void queSeNoSePuedaEnviarAUnaBatallaUnVehiculoQueNoExista() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertFalse(argentina.enviarALaBatalla("San Lorenzo", 4));
	}
	
}

/*  Evaluación de aprendizaje 03 - Recuperatorio
 Clonar el proyecto desde el siguiente repositorio: “https://github.com/jmonteagudo/recuperatorio”.


Enunciado
Nos contratan de las Fuerzas Armadas para desarrollar una aplicación que les permita planificar las batallas
que se pueden librar en las distintas zonas de conflicto.
Para eso nos comentan que no enviarán hombres al frente sino Vehículos con distintas características.
Algunos vehículos pueden desempeñarse por tierra, otros por agua y otros por aire. Sin embargo, las últimas
tecnologías les permitieron a las fuerzas incorporar nuevos vehículos:
 Anfibios: Pueden desempeñarse tanto por tierra como por agua
 Hidroaviones: Son un tipo de avión especial que puede (además de volar) realizar operaciones por
agua.
Como información adicional para la construcción del software nos presentan los siguientes requerimientos:
1. Los vehículos de guerra se identifican unívocamente por su código.
2. Las batallas se identifican unívocamente por su nombre.
3. El convoy es el conjunto de Vehículos que disponen (no importa el tipo de vehículo).
4. Para enviar un Vehículo a una batalla se debe confirmar que el mismo forme parte de la fuerza.
5. El Vehículo que se envía a una batalla determinada debe ser apto para esta:
a. En las batallas aeras, sólo se podrán utilizar Vehículos Voladores.
b. En las batallas por tierra se podrán utilizar Vehículos Terrestre.
c. En las batallas por agua sólo se podrán utilizar Vehículos Acuáticos.
*/

package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DesarrolladorTest {

private Desarrollador desarrollador;
	
	@BeforeEach
	void setUp () throws Exception {
		desarrollador = new Desarrollador("11111111H", "Sergio", 2000.5, "Java");
	}
	
	@Test
	@DisplayName("Prueba del get de dni")
	void testgetDni() {
		String dni = "11111111H";
		String resultado = desarrollador.getDni();
		assertEquals(dni, resultado, "Resultado inesperado");
	}
	
	@Test
	@DisplayName("Prueba del get de Nombre")
	void testgetNombre() {
		String nombre = "Sergio";
		String resultado = desarrollador.getNombre();
		assertEquals(nombre, resultado, "Resultado inesperado");
	}
	
	@Test
	@DisplayName("Prueba del get de sueldoBase")
	void testgetsueldoBase() {
		double sueldo = 2000.5;
		double resultado = desarrollador.getSueldoBase();
		assertEquals(sueldo, resultado, "Resultado inesperado");
	}
	
	@Test
	@DisplayName("Prueba del set de sueldoBase")
	void testsetsueldoBase() {
		desarrollador.setSueldoBase(1000);
		double sueldo = 1000;
		double resultado = desarrollador.getSueldoBase();
		assertEquals(sueldo, resultado, "Resultado inesperado");
	}
	
	@Test
	@DisplayName("Prueba del get de lenguajePrincipal")
	void testgetlenguajePrincipal() {
		String lenguaje = "Java";
		String resultado = desarrollador.getLenguajePrincipal();
		assertEquals(lenguaje, resultado, "Resultado inesperado");
	}
	
	@Test
	@DisplayName("Prueba del get de calcularProductividad con java (+10%)")
	void testgetcalcularProductividad() {
		double productividad = 2200.55;
		double resultado = desarrollador.calcularProductividad();
		assertEquals(productividad, resultado, "Resultado inesperado");
	}

	@Test
	@DisplayName("Prueba del get de calcularProductividad con Go (+0%)")
	void testgetcalcularProductividad2() {
		desarrollador.setLenguajePrincipal("Go");
		double productividad = 2000.5;
		double resultado = desarrollador.calcularProductividad();
		assertEquals(productividad, resultado, "Resultado inesperado");
	}
	
	@Test
	@DisplayName("Prueba del set de lenguaje null")
	void testErrorLenguaje () {
		Exception excepcion = assertThrows(IllegalArgumentException.class, ()->desarrollador.setLenguajePrincipal(null));
		String mensajeEsperado = "El lenguaje principal no puede ser nulo ni vacío.";
		assertEquals(mensajeEsperado, excepcion.getMessage());
	}
	
	@Test
	@DisplayName("Prueba del set de dni null")
	void testErrorDni () {
		Exception excepcion = assertThrows(IllegalArgumentException.class, ()->desarrollador.setDni(null));
		String mensajeEsperado = "DNI no válido.";
		assertEquals(mensajeEsperado, excepcion.getMessage());
	}
	
	@Test
	@DisplayName("Prueba del set de nombre null")
	void testErrorNombre () {
		Exception excepcion = assertThrows(IllegalArgumentException.class, ()->desarrollador.setNombre(null));
		String mensajeEsperado = "Nombre no válido.";
		assertEquals(mensajeEsperado, excepcion.getMessage());
	}
	
	@Test
	@DisplayName("Prueba del set de sueldo negativo")
	void testErrorSueldo () {
		Exception excepcion = assertThrows(IllegalArgumentException.class, ()->desarrollador.setSueldoBase(-10));
		String mensajeEsperado = "El sueldo base no puede ser negativo.";
		assertEquals(mensajeEsperado, excepcion.getMessage());
	}
}

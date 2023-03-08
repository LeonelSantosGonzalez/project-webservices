/**
 * 
 */
package com.leonel.projectwebservices.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.leonel.projectwebservices.entity.Empleado;

/**
 * @author Leonel
 *
 */
public class EmpleadoService {

	/**
	 * Metodo que permite consultar un empleado por su id; 
	 * @param numeroEmpleado {@link String}
	 *
	 */
	public Empleado consultarEmpleadoPorNumeroEmpleado(String numeroEmpleado) {

		List<Empleado> empleadosConsultados = this.consultarEmpleados();

		for (Empleado empleadoConsultado : empleadosConsultados) {
			if (empleadoConsultado.getNumeroEmpleado().equals(numeroEmpleado)) {
				return empleadoConsultado;
			}
		}
		return null;
	}

	/**
	 * Metodo que simula la consulta de un empleado
	 * 
	 * @return{@link Empleado} empleado consultado
	 */

	public Empleado consultarEmpleado() {

		Empleado empleado = new Empleado();
		empleado.setNumeroEmpleado("420");
		empleado.setNombre("Leonel");
		empleado.setPrimerApellido("Santos");
		empleado.setSegundoApellido("Gonzalez");
		empleado.setFechaCreacion(LocalDateTime.now());
		empleado.setEdad(24);

		return empleado;
	}

	public List<Empleado> consultarEmpleados() {

		List<Empleado> empleados = new ArrayList();

		Empleado empleado = new Empleado();
		empleado.setNumeroEmpleado("420");
		empleado.setNombre("Leonel");
		empleado.setPrimerApellido("Santos");
		empleado.setSegundoApellido("Gonzalez");
		empleado.setFechaCreacion(LocalDateTime.now());
		empleado.setEdad(24);

		Empleado empleadoNuevo = new Empleado();
		empleadoNuevo.setNumeroEmpleado("2811");
		empleadoNuevo.setNombre("Sebastian");
		empleadoNuevo.setPrimerApellido("Alcantara");
		empleadoNuevo.setSegundoApellido("Contreras");
		empleadoNuevo.setFechaCreacion(LocalDateTime.now());
		empleadoNuevo.setEdad(15);

		empleados.add(empleado);
		empleados.add(empleadoNuevo);

		return empleados;
	}

}

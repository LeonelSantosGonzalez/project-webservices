/**
 * 
 */
package com.leonel.projectwebservices.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.leonel.projectwebservices.entity.Empleado;
import com.leonel.projectwebservices.service.EmpleadoService;

/**
 * @author Leonel WebService generado con jersey
 */

@Path("empleadosWS")
public class EmpleadoWS {

	private EmpleadoService empleadoService = new EmpleadoService();

	@Path("test")
	@GET
	public String test() {

		return "probando WebService con jersey";

	}

	@Path("consultarEmpleado")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Empleado consultarEmpleado() {
		return this.empleadoService.consultarEmpleado();
	}

	@GET
	@Path("consultarEmpleados")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Empleado> consultarEmpleados() {

		return this.empleadoService.consultarEmpleados();
	}

	@GET
	@Path("consultarEmpleadoPorNumeroEmpleado/{numEmp}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consultarEmpleadoPorId(@PathParam("numEmp") String numeroEmpleado) {

		Empleado empleadoConsultado = this.empleadoService.consultarEmpleadoPorNumeroEmpleado(numeroEmpleado);

		if (empleadoConsultado == null) {
			return Response.noContent().build();
		}
		GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleadoConsultado, Empleado.class);
		return Response.ok(empleadoGeneric).build();

	}

	@POST
	@Path("guardarEmpleado")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarEmpleado(Empleado empleado){
	
		if (empleado == null) {
			
			return Response.status(400).entity ("No se inreso informacion del empleado, favor de capturar sus datos").build();
		}
		
		if (empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
			return Response.status(400).entity("El nombre es requerido").build();
		}
		GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleado, Empleado.class);
	return Response.ok().build();
	
	
	
	
}
}

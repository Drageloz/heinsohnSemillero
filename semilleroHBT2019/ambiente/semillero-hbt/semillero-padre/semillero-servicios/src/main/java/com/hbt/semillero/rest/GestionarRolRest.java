package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.dto.RolDTO;
import com.hbt.semillero.ejb.IGestionarPersonajeLocal;
import com.hbt.semillero.ejb.IGestionarRolLocal;

@Path("/GestionarRol")
public class GestionarRolRest {
	
	@EJB
	private IGestionarRolLocal gestionarRolEJB;
	
	@GET
	@Path("/saludo")
	@Produces(MediaType.APPLICATION_JSON)
	public String primerRest() {
		return "Prueba inicial servicios rest en el semillero java hbt";
	}
	
	@GET
	@Path("/consultarRol")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<RolDTO> consultarRol(){
		return gestionarRolEJB.consultarRol();
		
	};
	
	@GET
	@Path("/consultarRolById")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RolDTO>  consultarRoles(@QueryParam("idPersonaje") Long idPersonaje){
		return gestionarRolEJB.consultarRoles(idPersonaje);
		
	};
	
	@POST
	@Path("/crearRol")
	@Consumes(MediaType.APPLICATION_JSON)
	public void crearRol(RolDTO rolDTO) {
		gestionarRolEJB.crearRol(rolDTO);	
	}

}

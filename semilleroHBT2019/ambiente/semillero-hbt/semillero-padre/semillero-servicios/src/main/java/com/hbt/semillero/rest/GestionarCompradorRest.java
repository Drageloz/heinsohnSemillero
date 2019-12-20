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
import com.hbt.semillero.dto.CompradorDTO;
import com.hbt.semillero.ejb.IGestionarPersonajeLocal;
import com.hbt.semillero.ejb.IGestionarCompradorLocal;
/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar
 * un Comprador, añadiendolo a la base de datos
 * 
 * @author drageloz
 * 
 */
@Path("/GestionarComprador")
public class GestionarCompradorRest {
	
	@EJB
	private IGestionarCompradorLocal gestionarCompradorEJB;
	
	@GET
	@Path("/saludo")
	@Produces(MediaType.APPLICATION_JSON)
	public String primerRest() {
		return "Prueba inicial servicios rest en el semillero java hbt";
	}
//	
//	@GET
//	@Path("/consultarComprador")
//	@Produces(MediaType.APPLICATION_JSON)
//	public  List<CompradorDTO> consultarComprador(){
//		return gestionarCompradorEJB.consultarComprador();
//		
//	};
//	
//	@GET
//	@Path("/consultarCompradorById")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<CompradorDTO>  consultarCompradores(@QueryParam("idPersonaje") Long idPersonaje){
//		return gestionarCompradorEJB.consultarCompradores(idPersonaje);
//		
//	};
	
	@POST
	@Path("/crearComprador")
	@Consumes(MediaType.APPLICATION_JSON)
	public void crearComprador(CompradorDTO compradorDTO) {
		gestionarCompradorEJB.crearComprador(compradorDTO);	
	}

}

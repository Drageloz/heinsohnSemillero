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
import com.hbt.semillero.dto.CompraDTO;
import com.hbt.semillero.ejb.IGestionarPersonajeLocal;
import com.hbt.semillero.ejb.IGestionarCompraLocal;
/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar
 * una compra del comic, añadiendola a la base de datos, y consultando ventas
 * 
 * @author drageloz
 * 
 */
@Path("/GestionarCompra")
public class GestionarCompraRest {
	
	@EJB
	private IGestionarCompraLocal gestionarCompraEJB;
	
	@GET
	@Path("/saludo")
	@Produces(MediaType.APPLICATION_JSON)
	public String primerRest() {
		return "Prueba inicial servicios rest en el semillero java hbt";
	}
	
//	@GET
//	@Path("/consultarCompra")
//	@Produces(MediaType.APPLICATION_JSON)
//	public  List<CompraDTO> consultarCompra(){
//		return gestionarCompraEJB.consultarCompra();
//		
//	};
//	
	@GET
	@Path("/consultarCompraById")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CompraDTO>  consultarCompras(@QueryParam("idPersonaje") Long idPersonaje){
		return gestionarCompraEJB.consultarCompras(idPersonaje);
		
	};
	
	@POST
	@Path("/crearCompra")
	@Consumes(MediaType.APPLICATION_JSON)
	public void crearCompra(CompraDTO compraDTO) {
		gestionarCompraEJB.crearCompra(compraDTO);	
	}

}

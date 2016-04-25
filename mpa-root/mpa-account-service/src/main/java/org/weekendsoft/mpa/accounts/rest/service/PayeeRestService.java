/**
 * 
 */
package org.weekendsoft.mpa.accounts.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.weekendsoft.mpa.accounts.rest.resources.ErrorResource;
import org.weekendsoft.mpa.accounts.rest.resources.PayeeResource;
import org.weekendsoft.mpa.entity.Payee;

/**
 * @author Vivek Kant
 *
 */
@Component
@Path("/payees")
public class PayeeRestService {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getPayees() {
		
		ResponseBuilder builder = null ;
		
		List<PayeeResource> payeeResourceList = new ArrayList<PayeeResource>() ;
		try {
			List<Payee> payeelist = Payee.getAll( "DEFAULT" ) ;
			ModelMapper mapper = new ModelMapper() ;
			for ( Payee payee : payeelist ) {
				PayeeResource res = mapper.map( payee, PayeeResource.class ) ;
				payeeResourceList.add( res ) ;
			}
			builder = Response.status( 200 ).entity( payeeResourceList ) ;
		} catch ( Exception e ) {
			e.printStackTrace() ;
			ErrorResource error = new ErrorResource( "EC-RS-000", e.getMessage() ) ;
			builder = Response.status( 500 ).entity( error ) ;
		}
		
		return builder.build() ;
	}
	
	@GET @Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getPayeeById( @PathParam("id") Integer id) {
		ResponseBuilder response = null ;
		
		try {
			PayeeResource res = null ;
			ModelMapper mapper = new ModelMapper() ;
			
			Payee payee = Payee.get( id ) ;
			if ( payee != null ) {
				res = mapper.map( payee, PayeeResource.class ) ;
				response = Response.status( 200 ).entity( res ) ;
			} else {
				ErrorResource error = new ErrorResource( "EC-RS-404", "Resource was not found" ) ;
				response = Response.status( 404 ).entity( error ) ;
			}
			
		} catch ( Exception e ) {
			e.printStackTrace() ;
			ErrorResource error = new ErrorResource( "EC-RS-000", e.getMessage() ) ;
			response = Response.status( 500 ).entity( error ) ;
		}
		
		return response.build() ;
	}
	
}
 
/**
 * 
 */
package org.weekendsoft.mpa.accounts.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
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
	
	private static final Logger logger = Logger.getLogger( PayeeRestService.class ) ;

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
			logger.error("Exception while getting payee list", e ) ;
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
				logger.info( "ID not found " + id ) ;
				ErrorResource error = new ErrorResource( "EC-RS-404", "Resource was not found" ) ;
				response = Response.status( 404 ).entity( error ) ;
			}
			
		} catch ( Exception e ) {
			logger.error("Exception while getting payee", e ) ;
			ErrorResource error = new ErrorResource( "EC-RS-000", e.getMessage() ) ;
			response = Response.status( 500 ).entity( error ) ;
		}
		
		return response.build() ;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})	
	public Response createPayee( PayeeResource payee ) {
		ResponseBuilder res = null ;
		ModelMapper mapper = new ModelMapper() ;
		
		logger.debug( "Inpud Payee to create " + payee ) ;
		
		try {
			ErrorResource error = validatePayee( payee ) ;
			if ( error.getErrorCode() == null ) {
				Payee payeeEntity = mapper.map( payee, Payee.class ) ;
				payeeEntity = Payee.create( payeeEntity ) ;
			
				payee.setId( payeeEntity.getId() ) ;
				res = Response.status( 201 ).entity( payee ) ;
			} else {
				res = Response.status( 400 ).entity( error ) ;
			}
			
		} catch ( Exception e ) {
			logger.error("Exception while creating payee", e ) ;
			ErrorResource error = new ErrorResource( "EC-RS-000", e.getMessage() ) ;
			res = Response.status( 500 ).entity( error ) ;
		}

		return res.build() ;
	}
	
	@PUT @Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})	
	public Response modifyPayee( @PathParam("id") Integer id, PayeeResource payee ) {
		ResponseBuilder res = null ;
		ModelMapper mapper = new ModelMapper() ;
		
		try {
			ErrorResource error = validatePayee( payee ) ;
			if ( error.getErrorCode() == null ) {
				payee.setId( id ) ;
				Payee payeeEntity = mapper.map( payee, Payee.class ) ;
				payeeEntity = Payee.modify( payeeEntity ) ;
				
				if ( payeeEntity != null ) {
					res = Response.status( 200 ).entity( payee ) ;
				
				} else {
					error = new ErrorResource( "EC-RS-404", "Resource was not found" ) ;
					res = Response.status( 406 ).entity( error ) ;
				}
			} else {
				res = Response.status( 400 ).entity( error ) ;
			}
			
		} catch ( Exception e ) {
			logger.error("Exception while creating payee", e ) ;
			ErrorResource error = new ErrorResource( "EC-RS-000", e.getMessage() ) ;
			res = Response.status( 500 ).entity( error ) ;
		}
		
		return res.build();
	}
	
	
	//TODO Move this to JSR 303 bean validation
	private ErrorResource validatePayee( PayeeResource payee ) {
		ErrorResource error = new ErrorResource() ;
		
		if ( payee == null ) {
			error.setErrorCode( "EC-RS-001" ) ;
			error.setErrorMessage( "Enter details to provide payee" );
		
		} else if ( payee.getInstanceId() == null || "".equals( payee.getInstanceId() ) ) {
			error.setErrorCode( "EC-RS-002" ) ;
			error.setErrorMessage( "Instance Id cannot be null or empty" ) ;			
		
		} else if ( payee.getName() == null || "".equals( payee.getName() ) ) {
			error.setErrorCode( "EC-RS-003" ) ;
			error.setErrorMessage( "Payee name cannot be null or empty" ) ;
		}
		
		return error ;
	}
	
}
 
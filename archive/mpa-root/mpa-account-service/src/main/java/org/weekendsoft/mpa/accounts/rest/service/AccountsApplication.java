/**
 * 
 */
package org.weekendsoft.mpa.accounts.rest.service;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * @author Vivek Kant
 *
 */
public class AccountsApplication extends ResourceConfig {
	
	public AccountsApplication() {
		register(RequestContextFilter.class);
		register(PayeeRestService.class);
		register(JacksonFeature.class);	
	}

}

/**
 * 
 */
package org.weekendsoft.mpa.accounts.rest.resources;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vivek Kant
 *
 */
@XmlRootElement
public class ErrorResource implements Serializable {

	private static final long serialVersionUID = 1L;

	private String errorCode ;
	private String errorMessage ;
	
	public ErrorResource( String errorCode, String errorMessage ) {
		this.errorCode = errorCode ;
		this.errorMessage = errorMessage ;
	}
	
	public ErrorResource() {
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorResource [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
	
}

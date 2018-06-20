/**
 * 
 */
package org.weekendsoft.mpa.accounts.rest.resources;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Payee Resource
 * 
 * @author Vivek Kant
 *
 */
@XmlRootElement
public class PayeeResource implements Serializable {

	private static final long serialVersionUID = -5750542619407289811L;

    private int id ;
    private String name ;
    private String instanceId ;
    private Integer defaultCategoryId ;
    private Integer defaultSubCategoryId ;
    
    public PayeeResource() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public Integer getDefaultCategoryId() {
		return defaultCategoryId;
	}

	public void setDefaultCategoryId(Integer defaultCategoryId) {
		this.defaultCategoryId = defaultCategoryId;
	}

	public Integer getDefaultSubCategoryId() {
		return defaultSubCategoryId;
	}

	public void setDefaultSubCategoryId(Integer defaultSubCategoryId) {
		this.defaultSubCategoryId = defaultSubCategoryId;
	}

	@Override
	public String toString() {
		return "PayeeResource [id=" + id + ", name=" + name + ", instanceId=" + instanceId + ", defaultCategoryId="
				+ defaultCategoryId + ", defaultSubCategoryId=" + defaultSubCategoryId + "]";
	}
    
    
}

package org.weekendsoft.mpa.masterdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Vivek Kant
 */
@Entity
public class Category {

	@Id
	@Column(name = "CATEGORY_NAME")
    private String name;
	
	@Column(name = "CATEGORY_DESC")
    private String description;
	
    @Column(name = "INSTANCE_ID")
    private String instanceId ;

    public Category() {
    	super();
    }
    
    public Category(String name) {
    	super();
		this.name = name;
    }

    public Category(String name, String description) {
    	super();
		this.name = name;
		this.description = description;;
    }
    
    public Category(String name, String description, String instanceId) {
    	super();
		this.name = name;
		this.description = description;
		this.instanceId = instanceId;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + ", instanceId=" + instanceId + "]";
	}

}


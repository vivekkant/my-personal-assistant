package org.weekendsoft.mpa.masterdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Vivek Kant
 */
@Entity
public class SubCategory {

    public static final String DEFAULT_CATEGORY = "DEFAULT" ;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    
    @Column(name = "SUB_CATEGORY_NAME")
    private String subCategoryName;
    
    @Column(name = "INSTANCE_ID")
    private String instanceId ;
    
    private boolean internal ;

    
    public SubCategory(int id, String categoryName, String subCategoryName, String instanceId, boolean internal) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.subCategoryName = (subCategoryName == null) ? DEFAULT_CATEGORY : subCategoryName;
		this.instanceId = instanceId;
		this.internal = internal;
	}

    public SubCategory( int id ) {
        super() ;
        this.id = id ;
    }

    public SubCategory() {
    	// Default Constructor
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public boolean isInternal() {
		return internal;
	}

	public void setInternal(boolean internal) {
		this.internal = internal;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", subCategoryName=" + subCategoryName
				+ ", instanceId=" + instanceId + ", internal=" + internal + "]";
	}
    

    
}


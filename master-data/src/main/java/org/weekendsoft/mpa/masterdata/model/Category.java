package org.weekendsoft.mpa.masterdata.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

/**
 * @author Vivek Kant
 */
public class Category {

    public static final String DEFAULT_SUB_CATEGORY = "DEFAULT" ;
    
    private String categoryName;
    private List<SubCategory> subCategories;

    public Category(String categoryName) {
    	super();
		this.categoryName = categoryName;
		this.subCategories = new ArrayList<SubCategory>();
    }
    
    public Category(String categoryName, List<SubCategory> subCategories) {
		super();
		this.categoryName = categoryName;
		this.subCategories = filterCategories(subCategories);
	}
    
    private List<SubCategory> filterCategories(List<SubCategory> original) {
    	List<SubCategory> subCategories = new ArrayList<SubCategory>();
    	for (SubCategory cat : original) {
    		if (this.categoryName.equals(cat.getCategoryName())) {
    			subCategories.add(cat);
    		}
    	}
    	
    	return subCategories;
    }

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}
	
	public void addSubCategory(SubCategory cat) {
		this.subCategories.add(cat);
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	@Override
	public String toString() {
		return "CategoryStructure [categoryName=" + categoryName + ", subCategories=" + subCategories + "]";
	}

}


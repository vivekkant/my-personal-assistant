package org.weekendsoft.mpa.masterdata.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

/**
 * @author Vivek Kant
 */
public class CategoryStructure {

    public static final String DEFAULT_CATEGORY = "DEFAULT" ;
    
    private String categoryName;
    private List<Category> subCategories;

    public CategoryStructure(String categoryName) {
    	super();
		this.categoryName = categoryName;
		this.subCategories = new ArrayList<Category>();
    }
    
    public CategoryStructure(String categoryName, List<Category> subCategories) {
		super();
		this.categoryName = categoryName;
		this.subCategories = filterCategories(subCategories);
	}
    
    private List<Category> filterCategories(List<Category> original) {
    	List<Category> subCategories = new ArrayList<Category>();
    	for (Category cat : original) {
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

	public List<Category> getSubCategories() {
		return subCategories;
	}
	
	public void addSubCategory(Category cat) {
		this.subCategories.add(cat);
	}

	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}

	@Override
	public String toString() {
		return "CategoryStructure [categoryName=" + categoryName + ", subCategories=" + subCategories + "]";
	}

}


package org.weekendsoft.mpa.masterdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.weekendsoft.mpa.masterdata.model.SubCategory;
import org.weekendsoft.mpa.masterdata.model.Category;

@Component
public class CategoryService {
	
	public List<Category> createCategoryStructure(List<SubCategory> subCategories) {
		
		Map<String, Category> categories = new HashMap<String, Category>();
		for (SubCategory cat : subCategories) {
			String categoryName = cat.getCategoryName();
			Category category = categories.containsKey(categoryName) ?
										 categories.get(categoryName) :
									     new Category(categoryName);
			category.addSubCategory(cat);
			categories.put(categoryName, category);
		}
		
		
		return new ArrayList<Category>(categories.values());
	}

}

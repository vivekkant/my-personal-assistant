package org.weekendsoft.mpa.masterdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.weekendsoft.mpa.masterdata.model.Category;
import org.weekendsoft.mpa.masterdata.model.CategoryStructure;

@Component
public class CategoryService {
	
	public List<CategoryStructure> createCategoryStructure(List<Category> subCategories) {
		
		Map<String, CategoryStructure> categories = new HashMap<String, CategoryStructure>();
		for (Category cat : subCategories) {
			String categoryName = cat.getCategoryName();
			CategoryStructure category = categories.containsKey(categoryName) ?
										 categories.get(categoryName) :
									     new CategoryStructure(categoryName);
			category.addSubCategory(cat);
			categories.put(categoryName, category);
		}
		
		
		return new ArrayList<CategoryStructure>(categories.values());
	}

}

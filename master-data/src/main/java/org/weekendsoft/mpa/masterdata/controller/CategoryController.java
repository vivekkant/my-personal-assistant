/**
 * 
 */
package org.weekendsoft.mpa.masterdata.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.weekendsoft.mpa.masterdata.exception.ERROR_CODES;
import org.weekendsoft.mpa.masterdata.exception.RecordNotFoundException;
import org.weekendsoft.mpa.masterdata.model.SubCategory;
import org.weekendsoft.mpa.masterdata.model.Category;
import org.weekendsoft.mpa.masterdata.model.ErrorInfo;
import org.weekendsoft.mpa.masterdata.repository.CategoryRepository;
import org.weekendsoft.mpa.masterdata.service.CategoryService;

/**
 * @author Vivek Kant
 *
 */
@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RecordNotFoundException.class)
	public ErrorInfo handleException(RecordNotFoundException ex) {
        ErrorInfo error = new ErrorInfo();
        error.setCode(ERROR_CODES.RECORD_NOT_FOUND);
        error.setMessage("Record with id: " + ex.id);
        error.setStatus(HttpStatus.NOT_FOUND);
        return error;
    }

	@RequestMapping(value = "", method = RequestMethod.POST)
	public SubCategory create(@RequestBody Category category) {
		SubCategory defaultSubCategory = new SubCategory();
		defaultSubCategory.setCategoryName(category.getCategoryName());
		defaultSubCategory.setSubCategoryName(Category.DEFAULT_SUB_CATEGORY);
		return categoryRepository.saveAndFlush(defaultSubCategory);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Category> list() {
		List<SubCategory> subCategories = categoryRepository.findAll();
		return categoryService.createCategoryStructure(subCategories);
	}

	
}

/**
 * 
 */
package org.weekendsoft.mpa.masterdata.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.weekendsoft.mpa.masterdata.model.Category;
import org.weekendsoft.mpa.masterdata.model.ErrorInfo;
import org.weekendsoft.mpa.masterdata.repository.CategoryRepository;

/**
 * @author Vivek Kant
 *
 */
@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RecordNotFoundException.class)
	public ErrorInfo handleException(RecordNotFoundException ex) {
        ErrorInfo error = new ErrorInfo();
        error.setCode(ERROR_CODES.RECORD_NOT_FOUND);
        error.setMessage("Record with id: " + ex.id);
        error.setStatus(HttpStatus.NOT_FOUND);
        return error;
    }

	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Category> list() {
		return categoryRepository.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Category create(@RequestBody Category category) {
		return categoryRepository.saveAndFlush(category);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Category get(@PathVariable int id) {
		Category category = categoryRepository.findOne(id);
		if (category == null) throw new RecordNotFoundException(id, "Category ID not found: " + id, null);
		
		return category;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Category update(@PathVariable int id, @RequestBody Category category) {
		Category existingCategory = categoryRepository.findOne(id);
		if (existingCategory == null) throw new RecordNotFoundException(id, "Category ID not found: " + id, null);
		
		BeanUtils.copyProperties(category, existingCategory);
		category.setId(id);
		return categoryRepository.saveAndFlush(existingCategory);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Category delete(@PathVariable int id) {
		Category existingCategory = categoryRepository.findOne(id);
		if (existingCategory == null) throw new RecordNotFoundException(id, "Category ID not found: " + id, null);
		
		categoryRepository.delete(existingCategory);
		return existingCategory;
	}
	
}

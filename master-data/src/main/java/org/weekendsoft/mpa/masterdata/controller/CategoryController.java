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
import org.weekendsoft.mpa.masterdata.model.Account;
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
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RecordNotFoundException.class)
	public ErrorInfo handleException(RecordNotFoundException ex) {
        ErrorInfo error = new ErrorInfo();
        error.setCode(ERROR_CODES.RECORD_NOT_FOUND);
        error.setMessage("Record with name: " + ex.name);
        error.setStatus(HttpStatus.NOT_FOUND);
        return error;
    }

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Category create(@RequestBody Category category) {
		return categoryRepository.saveAndFlush(category);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Category> list() {
		return categoryRepository.findAll();
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public Category get(@PathVariable String name) {
		Category category = categoryRepository.findOne(name);
		if (category == null) throw new RecordNotFoundException(name, "Category with name not found: " + name, null);
		
		return category;
	}
	
}

/**
 * 
 */
package org.weekendsoft.mpa.dao;

import java.util.List;

import org.weekendsoft.mpa.entity.Category;

/**
 * @author Vivek Kant
 *
 */
public class CategoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		System.out.println( "----------- Creating new Category -----------" ) ;
		Category category = new Category() ;
		category.setInstanceId( "DEFAULT" ) ;
		category.setName( "Test Category" ) ;
		Category.create( category ) ;
		
		System.out.println( "----------- Get by Id -----------" ) ;
		Category category2 = Category.get( category.getId() ) ;
		System.out.println( category2 ) ;
		
		System.out.println( "----------- Modify -----------" ) ;
		category2.setName( "Test Category 2" ) ;
		Category.modify( category2 ) ;
		
		System.out.println( "----------- Get All -----------" ) ;
		List<Category> all = Category.getAll( "DEFAULT" ) ;
		for( Category at : all ) {
			System.out.println( at ) ;
		}
		
		System.out.println( "----------- Delete -----------" ) ;
		Category.delete( category2 ) ;
		
		System.out.println( "----------- Get All -----------" ) ;
		all = Category.getAll( "DEFAULT" ) ;
		for( Category at : all ) {
			System.out.println( at ) ;
		}
	}

}

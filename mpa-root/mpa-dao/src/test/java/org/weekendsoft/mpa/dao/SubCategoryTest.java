/**
 * 
 */
package org.weekendsoft.mpa.dao;

import java.util.List;

import org.weekendsoft.mpa.entity.Category;
import org.weekendsoft.mpa.entity.SubCategory;

/**
 * @author Vivek Kant
 *
 */
public class SubCategoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		System.out.println( "----------- Creating new Category -----------" ) ;
		Category category = new Category() ;
		category.setInstanceId( "DEFAULT" ) ;
		category.setName( "Test Category" ) ;
		Category.create( category ) ;

		System.out.println( "----------- Creating new SubCategory -----------" ) ;
		SubCategory subcategory = new SubCategory() ;
		subcategory.setInstanceId( "DEFAULT" ) ;
		subcategory.setCategoryId( category.getId() ) ;
		subcategory.setName( "Test SubCategory" ) ;
		SubCategory.create( subcategory ) ;
		
		System.out.println( "----------- Get by Id -----------" ) ;
		SubCategory subcategory2 = SubCategory.get( subcategory.getId() ) ;
		System.out.println( subcategory2 ) ;
		
		System.out.println( "----------- Modify -----------" ) ;
		subcategory2.setName( "Test SubCategory 2" ) ;
		SubCategory.modify( subcategory2 ) ;
		
		System.out.println( "----------- Get All -----------" ) ;
		List<SubCategory> all = SubCategory.getAll( "DEFAULT" ) ;
		for( SubCategory sc : all ) {
			System.out.println( sc ) ;
		}
		
		System.out.println( "----------- Delete -----------" ) ;
		SubCategory.delete( subcategory2 ) ;
		
		System.out.println( "----------- Get All -----------" ) ;
		all = SubCategory.getAll( "DEFAULT" ) ;
		for( SubCategory sc : all ) {
			System.out.println( sc ) ;
		}
		
		System.out.println( "----------- Get by Category Id -----------" ) ;
		all = SubCategory.getSubCategoriesByCategory( category.getId(), "DEFAULT" ) ;
		for( SubCategory sc : all ) {
			System.out.println( sc ) ;
		}
		
		Category.delete( category ) ;
	}

}

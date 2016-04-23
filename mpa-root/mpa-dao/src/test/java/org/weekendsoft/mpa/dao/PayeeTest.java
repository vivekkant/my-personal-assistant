/**
 * 
 */
package org.weekendsoft.mpa.dao;

import java.util.List;

import org.weekendsoft.mpa.entity.Category;
import org.weekendsoft.mpa.entity.Payee;
import org.weekendsoft.mpa.entity.SubCategory;

/**
 * @author Vivek Kant
 *
 */
public class PayeeTest {

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

		System.out.println( "----------- Creating new Payee -----------" ) ;
		Payee payee = new Payee() ;
		payee.setInstanceId( "DEFAULT" ) ;
		payee.setName( "Test Payee" ) ;
		payee.setDefaultCategoryId( category.getId() ) ;
		payee.setDefaultSubCategoryId( subcategory.getId() ) ;
		Payee.create( payee ) ;
		
		System.out.println( "----------- Get by Id -----------" ) ;
		Payee payee2 = Payee.get( payee.getId() ) ;
		System.out.println( payee2 ) ;
		
		System.out.println( "----------- Modify -----------" ) ;
		payee2.setName( "Test Payee 2" ) ;
		Payee.modify( payee2 ) ;
		
		System.out.println( "----------- Get All -----------" ) ;
		List<Payee> all = Payee.getAll( "DEFAULT" ) ;
		for( Payee at : all ) {
			System.out.println( at ) ;
		}
		
		System.out.println( "----------- Delete -----------" ) ;
		Payee.delete( payee2 ) ;
		
		System.out.println( "----------- Get All -----------" ) ;
		all = Payee.getAll( "DEFAULT" ) ;
		for( Payee at : all ) {
			System.out.println( at ) ;
		}
		
		SubCategory.delete( subcategory ) ;
		Category.delete( category ) ;
	}

}

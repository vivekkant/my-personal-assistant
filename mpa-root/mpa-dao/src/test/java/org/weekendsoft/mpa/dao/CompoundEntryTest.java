/**
 * 
 */
package org.weekendsoft.mpa.dao;

import java.util.List;

import org.weekendsoft.mpa.entity.CompoundEntry;

/**
 * @author Vivek Kant
 *
 */
public class CompoundEntryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		System.out.println( "----------- Creating new CompoundEntry -----------" ) ;
		CompoundEntry compoundEntry = new CompoundEntry() ;
		compoundEntry.setInstanceId( "DEFAULT" ) ;
		compoundEntry.setName( "Test CompoundEntry" ) ;
		CompoundEntry.create( compoundEntry ) ;
		
		System.out.println( "----------- Get by Id -----------" ) ;
		CompoundEntry compoundEntry2 = CompoundEntry.get( compoundEntry.getId() ) ;
		System.out.println( compoundEntry2 ) ;
		
		System.out.println( "----------- Modify -----------" ) ;
		compoundEntry2.setName( "Test CompoundEntry 2" ) ;
		CompoundEntry.modify( compoundEntry2 ) ;
		
		System.out.println( "----------- Get All -----------" ) ;
		List<CompoundEntry> all = CompoundEntry.getAll( "DEFAULT" ) ;
		for( CompoundEntry at : all ) {
			System.out.println( at ) ;
		}
		
		System.out.println( "----------- Delete -----------" ) ;
		CompoundEntry.delete( compoundEntry2 ) ;
		
		System.out.println( "----------- Get All -----------" ) ;
		all = CompoundEntry.getAll( "DEFAULT" ) ;
		for( CompoundEntry at : all ) {
			System.out.println( at ) ;
		}
	}

}

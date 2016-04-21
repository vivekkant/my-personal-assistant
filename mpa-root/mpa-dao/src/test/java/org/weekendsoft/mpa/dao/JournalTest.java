/**
 * 
 */
package org.weekendsoft.mpa.dao;

import java.util.Date;
import java.util.List;

import org.weekendsoft.mpa.entity.Account;
import org.weekendsoft.mpa.entity.Journal;

/**
 * @author 212542
 *
 */
public class JournalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		System.out.println( "----------- Creating test1 account -----------" ) ;
		Account testaccount1 = new Account() ;
		testaccount1.setAccountTypeId( null ) ;
		testaccount1.setBankId( null ) ;
		testaccount1.setCurrencyId( "INR" ) ;
		testaccount1.setInitialBalance( 100.0 ) ;
		testaccount1.setInstanceId( "DEFAULT" ) ;
		testaccount1.setInternal( false ) ;
		testaccount1.setName( "TEST ACCOUNT 1" ) ;
		Account.create( testaccount1 ) ;
		System.out.println( testaccount1 ) ;
		
		System.out.println( "----------- Creating test2 account -----------" ) ;
		Account testaccount2 = new Account() ;
		testaccount2.setAccountTypeId( null ) ;
		testaccount2.setBankId( null ) ;
		testaccount2.setCurrencyId( "INR" ) ;
		testaccount2.setInitialBalance( 100.0 ) ;
		testaccount2.setInstanceId( "DEFAULT" ) ;
		testaccount2.setInternal( false ) ;
		testaccount2.setName( "TEST ACCOUNT 2" ) ;
		Account.create( testaccount2 ) ;
		System.out.println( testaccount2 ) ;
		
		System.out.println( "----------- Creating transaction -----------" ) ;
		Journal jentry = new Journal() ;
		jentry.setDebitAccount( testaccount1.getId() ) ;
		jentry.setCreditAccount( testaccount2.getId() ) ;
		jentry.setAmount( 50.0 ) ;
		jentry.setCurrency( "INR" ) ;
		jentry.setComment( "testing new transaciton " ) ;
		jentry.setRecordDate( new Date() ) ;
		jentry.setStatus( 'U' ) ;
		jentry.setInstanceId( "DEFAULT" ) ;
		Journal.create( jentry ) ;
		System.out.println( jentry ) ;
		
		System.out.println( "----------- Updating transaction -----------" ) ;
		jentry.setAmount( 75.0 ) ;
		Journal.modify( jentry ) ;
		System.out.println( jentry ) ;
		
		System.out.println( "----------- List all transaction for debit account -----------" ) ;
		List<Journal> entries = Journal.getAccountEntries( "DEFAULT", testaccount1.getId() ) ;
		for( Journal entry : entries ) {
			System.out.println( entry ) ;
		}

		System.out.println( "----------- List all transaction for credit account -----------" ) ;
		List<Journal> entries2 = Journal.getAccountEntries( "DEFAULT", testaccount2.getId() ) ;
		for( Journal entry : entries2 ) {
			System.out.println( entry ) ;
		}
		
		System.out.println( "----------- Deleting transaction -----------" ) ;
		Journal.delete( jentry ) ;
	}

}

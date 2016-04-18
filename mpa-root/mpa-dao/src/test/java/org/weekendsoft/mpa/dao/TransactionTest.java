/**
 * 
 */
package org.weekendsoft.mpa.dao;

import java.util.Date;

import org.weekendsoft.mpa.entity.Account;
import org.weekendsoft.mpa.entity.Transaction;

/**
 * @author 212542
 *
 */
public class TransactionTest {

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
		Transaction tran = new Transaction() ;
		tran.setFromAccount( testaccount1.getId() ) ;
		tran.setToAccount( testaccount2.getId() ) ;
		tran.setAmount( 50.0 ) ;
		tran.setCurrency( "INR" ) ;
		tran.setComment( "testing new transaciton " ) ;
		tran.setRecordDate( new Date() ) ;
		tran.setStatus( 'U' ) ;
		tran.setInstanceId( "DEFAULT" ) ;
		Transaction.create( tran ) ;
		System.out.println( tran ) ;
		
		System.out.println( "----------- Updating transaction -----------" ) ;
		tran.setAmount( 75.0 ) ;
		Transaction.modify( tran ) ;
		System.out.println( tran ) ;
		
		System.out.println( "----------- Deleting transaction -----------" ) ;
		Transaction.delete( tran ) ;
	}

}

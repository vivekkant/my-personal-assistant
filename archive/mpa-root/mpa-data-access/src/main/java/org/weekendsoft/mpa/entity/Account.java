/**
 * 
 */
package org.weekendsoft.mpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

/**
 * Entity Bean for accounts
 * 
 * @author Vivek Kant
 *
 */
@Entity
@Table(name = "account")
public class Account extends BaseEntity implements Comparable<Account> {

    private static final long serialVersionUID = 1L;
    
    public static final String DEFAULT_INCOME_ACCOUNT = "DEFAULT_INCOME" ;
    public static final String DEFAULT_EXPENSE_ACCOUNT = "DEFAULT_EXPENSE" ;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int id ;
    
    @Column(name = "account_name")
    private String name ;
    
    @Column(name = "instance_id" )
    private String instanceId ;
    
    @Column(name = "account_type_id")
    private Integer accountTypeId ;
    
    @Column(name = "bank_id")
    private Integer bankId ;
    
    @Column(name = "currency_id")
    private String currencyId ;
    
    @Column(name = "internal")
    private boolean internal ;
    
    @Column(name = "initial_balance")
    private double initialBalance ;
    
    public Account( int id ) {
        super() ;
        this.id = id ;
    }

    public Account() {
    	// Default Constructor
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public Integer getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public Integer getBankId() {
		return bankId;
	}


	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public boolean isInternal() {
		return internal;
	}

	public void setInternal(boolean internal) {
		this.internal = internal;
	}

	public double getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

	public int compareTo( Account account2 ) {
		return this.name.compareTo( account2.name ) ;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", instanceId=" + instanceId + ", accountTypeId="
				+ accountTypeId + ", bankId=" + bankId + ", currencyId=" + currencyId + ", internal=" + internal
				+ ", initialBalance=" + initialBalance + "]";
	}
    
    public static Account get( int id ) throws Exception {
        if ( !init ) init() ;
        Account account = em.find( Account.class, id ) ;
        return account ;
    }
    
    public static Account getAccountByName( String name, String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	Account account = null ;
    	
    	Query q = em.createQuery( "select a from Account a where "
    			+ "a.instanceId = :instanceId and "
    			+ "a.name = :name" ) ;
    	
    	q.setParameter( "instanceId", instanceId ) ;
    	q.setParameter( "name", name ) ;
    	q.setMaxResults( 1 ) ;
    	
    	account = (Account) q.getSingleResult() ;
    	
    	return account ;
    }
    
    public static Account getIncomeAccount( String instanceId ) throws Exception {
    	return getAccountByName( DEFAULT_INCOME_ACCOUNT, instanceId ) ;
    }
    
    public static Account getExpenseAccount( String instanceId ) throws Exception {
    	return getAccountByName( DEFAULT_EXPENSE_ACCOUNT, instanceId ) ;
    }
    
    public static List<Account> getAll( String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	TypedQuery<Account> q = em.createQuery( "select a from Account a where "
    										  + "a.instanceId = :instanceId", Account.class ) ;
    	q.setParameter( "instanceId", instanceId ) ;
    	List<Account> results = q.getResultList() ;
    	
    	return results ;
    }
    
    public static void create( Account account ) throws Exception {
    	if ( !init ) init() ;
    	em.getTransaction().begin() ;
    	em.persist( account ) ;
    	em.flush() ;
    	em.getTransaction().commit() ;
    }

    public static void modify( Account account ) throws Exception {
    	if ( !init ) init() ;
    	Account original = em.find( Account.class, account.id ) ;
    	em.getTransaction().begin() ;
    	copy( original, account ) ;
    	em.getTransaction().commit() ;
    }
    
    
    public static void delete( Account account ) throws Exception {
    	em.getTransaction().begin() ;
    	em.remove( account ) ;
    	em.getTransaction().commit() ;
    }
    
    private static void copy( Account to, Account from ) {
    	to.accountTypeId 	= from.accountTypeId ;
    	to.name 			= from.name ;
    	to.bankId 			= from.bankId ;
    	to.currencyId 		= from.currencyId ;
    	to.initialBalance 	= from.initialBalance ;
    	to.instanceId 		= from.instanceId ;
    	to.internal 		= from.internal ;
    }
    
}

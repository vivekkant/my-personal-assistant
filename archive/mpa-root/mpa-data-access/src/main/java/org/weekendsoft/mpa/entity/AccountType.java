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
 * Entity Bean for AccountType
 * 
 * @author Vivek Kant
 *
 */
@Entity
@Table(name = "account_type")
public class AccountType extends BaseEntity implements Comparable<AccountType> {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "account_type_id")
    private int id ;
    
    @Column(name = "account_type_name")
    private String name ;
    
    @Column(name = "instance_id" )
    private String instanceId ;
       
    public AccountType( int id ) {
        super() ;
        this.id = id ;
    }

    public AccountType() {
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

	@Override
	public String toString() {
		return "AccountType [id=" + id + ", name=" + name + ", instanceId=" + instanceId + "]";
	}
    
    public static AccountType get( int id ) throws Exception {
        if ( !init ) init() ;
        AccountType accountType = em.find( AccountType.class, id ) ;
        return accountType ;
    }
    
    public static AccountType getAccountTypeByName( String name, String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	AccountType accountType = null ;
    	
    	Query q = em.createQuery( "select a from AccountType a where "
    			+ "a.instanceId = :instanceId and "
    			+ "a.name = :name" ) ;
    	
    	q.setParameter( "instanceId", instanceId ) ;
    	q.setParameter( "name", name ) ;
    	q.setMaxResults( 1 ) ;
    	
    	accountType = (AccountType) q.getSingleResult() ;
    	
    	return accountType ;
    }
    
    public static List<AccountType> getAll( String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	TypedQuery<AccountType> q = em.createQuery( "select a from AccountType a where "
    										  + "a.instanceId = :instanceId", AccountType.class ) ;
    	q.setParameter( "instanceId", instanceId ) ;
    	List<AccountType> results = q.getResultList() ;
    	
    	return results ;
    }
    
    public static void create( AccountType accountType ) throws Exception {
    	if ( !init ) init() ;
    	em.getTransaction().begin() ;
    	em.persist( accountType ) ;
    	em.flush() ;
    	em.getTransaction().commit() ;
    }

    public static void modify( AccountType accountType ) throws Exception {
    	if ( !init ) init() ;
    	AccountType original = em.find( AccountType.class, accountType.id ) ;
    	em.getTransaction().begin() ;
    	copy( original, accountType ) ;
    	em.getTransaction().commit() ;
    }
    
    
    public static void delete( AccountType accountType ) throws Exception {
    	em.getTransaction().begin() ;
    	em.remove( accountType ) ;
    	em.getTransaction().commit() ;
    }
    
    private static void copy( AccountType to, AccountType from ) {
    	to.name 			= from.name ;
    	to.instanceId 		= from.instanceId ;
    }

	public int compareTo( AccountType accountType ) {
		return this.name.compareTo( accountType.name ) ;
	}
    
}

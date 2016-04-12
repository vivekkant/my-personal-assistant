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
@Table(name = "bank")
public class Bank extends BaseEntity implements Comparable<Bank> {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private int id ;
    
    @Column(name = "bank_name")
    private String name ;
    
    @Column(name = "instance_id" )
    private String instanceId ;
       
    public Bank( int id ) {
        super() ;
        this.id = id ;
    }

    public Bank() {
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
		return "Bank [id=" + id + ", name=" + name + ", instanceId=" + instanceId + "]";
	}
    
    public static Bank get( int id ) throws Exception {
        if ( !init ) init() ;
        Bank bank = em.find( Bank.class, id ) ;
        return bank ;
    }
    
    public static Bank getBankByName( String name, String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	Bank bank = null ;
    	
    	Query q = em.createQuery( "select a from Bank a where "
    			+ "a.instanceId = :instanceId and "
    			+ "a.name = :name" ) ;
    	
    	q.setParameter( "instanceId", instanceId ) ;
    	q.setParameter( "name", name ) ;
    	q.setMaxResults( 1 ) ;
    	
    	bank = (Bank) q.getSingleResult() ;
    	
    	return bank ;
    }
    
    public static List<Bank> getAll( String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	TypedQuery<Bank> q = em.createQuery( "select a from Bank a where "
    										  + "a.instanceId = :instanceId", Bank.class ) ;
    	q.setParameter( "instanceId", instanceId ) ;
    	List<Bank> results = q.getResultList() ;
    	
    	return results ;
    }
    
    public static void create( Bank bank ) throws Exception {
    	if ( !init ) init() ;
    	em.getTransaction().begin() ;
    	em.persist( bank ) ;
    	em.flush() ;
    	em.getTransaction().commit() ;
    }

    public static void modify( Bank bank ) throws Exception {
    	if ( !init ) init() ;
    	Bank original = em.find( Bank.class, bank.id ) ;
    	em.getTransaction().begin() ;
    	copy( original, bank ) ;
    	em.getTransaction().commit() ;
    }
    
    
    public static void delete( Bank bank ) throws Exception {
    	em.getTransaction().begin() ;
    	em.remove( bank ) ;
    	em.getTransaction().commit() ;
    }
    
    private static void copy( Bank to, Bank from ) {
    	to.name 			= from.name ;
    	to.instanceId 		= from.instanceId ;
    }

	public int compareTo( Bank accountType ) {
		return this.name.compareTo( accountType.name ) ;
	}
    
}

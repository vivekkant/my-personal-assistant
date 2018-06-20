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
 * Entity Bean for Payee
 * 
 * @author Vivek Kant
 *
 */
@Entity
@Table(name = "payee")
public class Payee extends BaseEntity implements Comparable<Payee> {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "payee_id")
    private int id ;
    
    @Column(name = "payee_name")
    private String name ;
    
    @Column(name = "instance_id" )
    private String instanceId ;
    
    @Column(name = "default_category_id" )
    private Integer defaultCategoryId ;
    
    @Column(name = "default_subcategory_id" )
    private Integer defaultSubCategoryId ;
       
    public Payee( int id ) {
        super() ;
        this.id = id ;
    }

    public Payee() {
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

	public Integer getDefaultCategoryId() {
		return defaultCategoryId;
	}

	public void setDefaultCategoryId(Integer defaultCategory) {
		this.defaultCategoryId = defaultCategory;
	}

	public Integer getDefaultSubCategoryId() {
		return defaultSubCategoryId;
	}

	public void setDefaultSubCategoryId(Integer defaultSubCategory) {
		this.defaultSubCategoryId = defaultSubCategory;
	}

	@Override
	public String toString() {
		return "Payee [id=" + id + ", name=" + name + ", instanceId=" + instanceId + ", defaultCategoryId="
				+ defaultCategoryId + ", defaultSubCategoryId=" + defaultSubCategoryId + "]";
	}
    
    public static Payee get( int id ) throws Exception {
        if ( !init ) init() ;
        Payee payee = em.find( Payee.class, id ) ;
        return payee ;
    }
    
    public static Payee getPayeeByName( String name, String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	Payee payee = null ;
    	
    	Query q = em.createQuery( "select a from Payee a where "
    			+ "a.instanceId = :instanceId and "
    			+ "a.name = :name" ) ;
    	
    	q.setParameter( "instanceId", instanceId ) ;
    	q.setParameter( "name", name ) ;
    	q.setMaxResults( 1 ) ;
    	
    	payee = (Payee) q.getSingleResult() ;
    	
    	return payee ;
    }
    
    public static List<Payee> getAll( String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	TypedQuery<Payee> q = em.createQuery( "select a from Payee a where "
    										  + "a.instanceId = :instanceId", Payee.class ) ;
    	q.setParameter( "instanceId", instanceId ) ;
    	List<Payee> results = q.getResultList() ;
    	
    	return results ;
    }
    
    public static Payee create( Payee payee ) throws Exception {
    	if ( !init ) init() ;
    	em.getTransaction().begin() ;
    	em.persist( payee ) ;
    	em.flush() ;
    	em.getTransaction().commit() ;
    	return payee ;
    }

    public static Payee modify( Payee payee ) throws Exception {
    	if ( !init ) init() ;
    	Payee original = em.find( Payee.class, payee.id ) ;
    	if ( original == null ) {
    		return null ;
    	}
    		
    	em.getTransaction().begin() ;
    	copy( original, payee ) ;
    	em.getTransaction().commit() ;
    	return payee ;
    }
    
    public static void delete( Payee payee ) throws Exception {
    	em.getTransaction().begin() ;
    	em.remove( payee ) ;
    	em.getTransaction().commit() ;
    }
    
    private static void copy( Payee to, Payee from ) {
    	to.name 				= from.name ;
    	to.instanceId 			= from.instanceId ;
    	to.defaultCategoryId		= from.defaultCategoryId ;
    	to.defaultSubCategoryId 	= from.defaultSubCategoryId ;
    }

	public int compareTo( Payee accountType ) {
		return this.name.compareTo( accountType.name ) ;
	}
    
}

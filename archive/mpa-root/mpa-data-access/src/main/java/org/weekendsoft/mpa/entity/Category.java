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
 * Entity Bean for Bank
 * 
 * @author Vivek Kant
 *
 */
@Entity
@Table(name = "category")
public class Category extends BaseEntity implements Comparable<Category> {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id ;
    
    @Column(name = "category_name")
    private String name ;
    
    @Column(name = "instance_id" )
    private String instanceId ;
       
    public Category( int id ) {
        super() ;
        this.id = id ;
    }

    public Category() {
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
		return "Category [id=" + id + ", name=" + name + ", instanceId=" + instanceId + "]";
	}
    
    public static Category get( int id ) throws Exception {
        if ( !init ) init() ;
        Category category = em.find( Category.class, id ) ;
        return category ;
    }
    
    public static Category getCategoryByName( String name, String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	Category category = null ;
    	
    	Query q = em.createQuery( "select a from Category a where "
    			+ "a.instanceId = :instanceId and "
    			+ "a.name = :name" ) ;
    	
    	q.setParameter( "instanceId", instanceId ) ;
    	q.setParameter( "name", name ) ;
    	q.setMaxResults( 1 ) ;
    	
    	category = (Category) q.getSingleResult() ;
    	
    	return category ;
    }
    
    public static List<Category> getAll( String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	TypedQuery<Category> q = em.createQuery( "select a from Category a where "
    										  + "a.instanceId = :instanceId", Category.class ) ;
    	q.setParameter( "instanceId", instanceId ) ;
    	List<Category> results = q.getResultList() ;
    	
    	return results ;
    }
    
    public static void create( Category category ) throws Exception {
    	if ( !init ) init() ;
    	em.getTransaction().begin() ;
    	em.persist( category ) ;
    	em.flush() ;
    	em.getTransaction().commit() ;
    }

    public static void modify( Category category ) throws Exception {
    	if ( !init ) init() ;
    	Category original = em.find( Category.class, category.id ) ;
    	em.getTransaction().begin() ;
    	copy( original, category ) ;
    	em.getTransaction().commit() ;
    }
    
    
    public static void delete( Category category ) throws Exception {
    	em.getTransaction().begin() ;
    	em.remove( category ) ;
    	em.getTransaction().commit() ;
    }
    
    private static void copy( Category to, Category from ) {
    	to.name 			= from.name ;
    	to.instanceId 		= from.instanceId ;
    }

	public int compareTo( Category accountType ) {
		return this.name.compareTo( accountType.name ) ;
	}
    
}

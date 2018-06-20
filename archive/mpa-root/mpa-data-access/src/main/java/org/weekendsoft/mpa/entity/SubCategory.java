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
 * Entity Bean for SubCateogry
 * 
 * @author Vivek Kant
 *
 */
@Entity
@Table(name = "subcategory")
public class SubCategory extends BaseEntity implements Comparable<SubCategory> {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "subcategory_id")
    private int id ;
    
    @Column(name = "category_id")
    private int categoryId ; 
    
    @Column(name = "subcategory_name")
    private String name ;
    
    @Column(name = "instance_id" )
    private String instanceId ;
       
    public SubCategory( int id ) {
        super() ;
        this.id = id ;
    }

    public SubCategory() {
    	// Default Constructor
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
		return "SubCategory [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", instanceId="
				+ instanceId + "]";
	}
    
    public static SubCategory get( int id ) throws Exception {
        if ( !init ) init() ;
        SubCategory subcategory = em.find( SubCategory.class, id ) ;
        return subcategory ;
    }
    
    public static SubCategory getSubCategoryByName( String name, String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	SubCategory subcategory = null ;
    	
    	Query q = em.createQuery( "select a from SubCategory a where "
    			+ "a.instanceId = :instanceId and "
    			+ "a.name = :name" ) ;
    	
    	q.setParameter( "instanceId", instanceId ) ;
    	q.setParameter( "name", name ) ;
    	q.setMaxResults( 1 ) ;
    	
    	subcategory = (SubCategory) q.getSingleResult() ;
    	
    	return subcategory ;
    }
    
    public static List<SubCategory> getSubCategoriesByCategory( int categoryId, String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	TypedQuery<SubCategory> q = em.createQuery( "select a from SubCategory a where "
    										  + "a.instanceId = :instanceId and "
    										  + "a.categoryId = :categoryId", SubCategory.class ) ;
    	q.setParameter( "instanceId", instanceId ) ;
    	q.setParameter( "categoryId", categoryId ) ;
    	List<SubCategory> results = q.getResultList() ;
    	
    	return results ;
    }
    
    public static List<SubCategory> getAll( String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	TypedQuery<SubCategory> q = em.createQuery( "select a from SubCategory a where "
    										  + "a.instanceId = :instanceId", SubCategory.class ) ;
    	q.setParameter( "instanceId", instanceId ) ;
    	List<SubCategory> results = q.getResultList() ;
    	
    	return results ;
    }
    
    public static void create( SubCategory subcategory ) throws Exception {
    	if ( !init ) init() ;
    	em.getTransaction().begin() ;
    	em.persist( subcategory ) ;
    	em.flush() ;
    	em.getTransaction().commit() ;
    }

    public static void modify( SubCategory subcategory ) throws Exception {
    	if ( !init ) init() ;
    	SubCategory original = em.find( SubCategory.class, subcategory.id ) ;
    	em.getTransaction().begin() ;
    	copy( original, subcategory ) ;
    	em.getTransaction().commit() ;
    }
    
    
    public static void delete( SubCategory subcategory ) throws Exception {
    	em.getTransaction().begin() ;
    	em.remove( subcategory ) ;
    	em.getTransaction().commit() ;
    }
    
    private static void copy( SubCategory to, SubCategory from ) {
    	to.name 			= from.name ;
    	to.instanceId 		= from.instanceId ;
    }

	public int compareTo( SubCategory accountType ) {
		return this.name.compareTo( accountType.name ) ;
	}
    
}

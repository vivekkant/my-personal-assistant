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
 * Entity Bean for CompoundEntry
 * 
 * @author Vivek Kant
 *
 */
@Entity
@Table(name = "compound_entry")
public class CompoundEntry extends BaseEntity implements Comparable<CompoundEntry> {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "compound_entry_id")
    private int id ;
    
    @Column(name = "compound_entry_name")
    private String name ;
    
    @Column(name = "instance_id" )
    private String instanceId ;
       
    public CompoundEntry( int id ) {
        super() ;
        this.id = id ;
    }

    public CompoundEntry() {
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
		return "CompoundEntry [id=" + id + ", name=" + name + ", instanceId=" + instanceId + "]";
	}
    
    public static CompoundEntry get( int id ) throws Exception {
        if ( !init ) init() ;
        CompoundEntry compoundEntry = em.find( CompoundEntry.class, id ) ;
        return compoundEntry ;
    }
    
    public static CompoundEntry getCompoundEntryByName( String name, String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	CompoundEntry compoundEntry = null ;
    	
    	Query q = em.createQuery( "select a from CompoundEntry a where "
    			+ "a.instanceId = :instanceId and "
    			+ "a.name = :name" ) ;
    	
    	q.setParameter( "instanceId", instanceId ) ;
    	q.setParameter( "name", name ) ;
    	q.setMaxResults( 1 ) ;
    	
    	compoundEntry = (CompoundEntry) q.getSingleResult() ;
    	
    	return compoundEntry ;
    }
    
    public static List<CompoundEntry> getAll( String instanceId ) throws Exception {
    	if ( !init ) init() ;
    	
    	TypedQuery<CompoundEntry> q = em.createQuery( "select a from CompoundEntry a where "
    										  + "a.instanceId = :instanceId", CompoundEntry.class ) ;
    	q.setParameter( "instanceId", instanceId ) ;
    	List<CompoundEntry> results = q.getResultList() ;
    	
    	return results ;
    }
    
    public static void create( CompoundEntry compoundEntry ) throws Exception {
    	if ( !init ) init() ;
    	em.getTransaction().begin() ;
    	em.persist( compoundEntry ) ;
    	em.flush() ;
    	em.getTransaction().commit() ;
    }

    public static void modify( CompoundEntry compoundEntry ) throws Exception {
    	if ( !init ) init() ;
    	CompoundEntry original = em.find( CompoundEntry.class, compoundEntry.id ) ;
    	em.getTransaction().begin() ;
    	copy( original, compoundEntry ) ;
    	em.getTransaction().commit() ;
    }
    
    
    public static void delete( CompoundEntry compoundEntry ) throws Exception {
    	em.getTransaction().begin() ;
    	em.remove( compoundEntry ) ;
    	em.getTransaction().commit() ;
    }
    
    private static void copy( CompoundEntry to, CompoundEntry from ) {
    	to.name 			= from.name ;
    	to.instanceId 		= from.instanceId ;
    }

	public int compareTo( CompoundEntry accountType ) {
		return this.name.compareTo( accountType.name ) ;
	}
    
}

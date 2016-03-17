/**
 * 
 */
package org.weekendsoft.mpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity Bean for Instance
 * 
 * @author Vivek Kant
 *
 */
@Entity
@Table(name = "instance")
public class Instance extends BaseEntity implements Comparable<Instance> {

    private static final long serialVersionUID = 1L ;

    @Id
    @Column(name = "instance_id")
    private String id ;
    
    @Column(name = "instance_name")
    private String name ;
    
    @Column(name = "default_currency")
    private String currency ;
    
    public Instance( String id ) {
        super() ;
        this.id = id ;
    }
    
    public Instance( String id, String name, String currency ) {
        super() ;
        this.id = id ;
        this.name = name ;
        this.currency = currency ;
    }
    
    public Instance() {
        // Default
    }

    public String getId() {
        return id ;
    }

    public void setId(String id) {
        this.id = id ;
    }

    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name ;
    }

    public String getCurrency() {
        return currency ;
    }

    public void setCurrency(String currency) {
        this.currency = currency ;
    }
    
    @Override
    public String toString() {
        return "Instance [id=" + id + ", name=" + name + ", currency="
                + currency + "]";
    }

    public int compareTo( Instance instance ) {
            return this.id.compareTo( instance.id ) ;
    }
    
    public static Instance get( String id ) throws Exception {
        if ( !init ) init() ;
        Instance instance = em.find( Instance.class, id ) ;
        return instance ;
    }
    
    public static Instance getDefault() {
        Instance instance = new Instance( "DEFAULT", "Default Instance", "INR" ) ;
        return instance ;
    }
    
}

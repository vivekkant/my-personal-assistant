/**
 * 
 */
package org.weekendsoft.mpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity Bean for currency
 * 
 * @author Vivek Kant
 *
 */
@Entity
@Table(name = "currency")
public class Currency implements Serializable, Comparable<Currency> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "currency_id")
    private String id ;
    
    @Column(name = "currency_name")
    private String name ;
    
    @Column(name = "sort")
    private int sort ;
    
    public Currency( String id ) {
        super() ;
        this.id = id ;
    }
    
    public Currency( String id, String name, int sort ) {
        super() ;
        this.id = id ;
        this.name = name ;
        this.sort = sort ;
    }
    
    public Currency( String id, String name ) {
        super() ;
        this.id = id ;
        this.name = name ;
        this.sort = 999 ;
    }
    
    public Currency() {
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

    public int getSort() {
        return sort ;
    }

    public void setSort(int sort) {
        this.sort = sort ;
    }

    @Override
    public String toString() {
        return "Currency [id=" + id + ", name=" + name + ", sort=" + sort + "]" ;
    }
    
    public int compareTo( Currency currency ) {
        if ( this.sort > currency.sort ) {
            return 1 ;
        }
        else if ( this.sort < currency.sort ) {
            return -1 ;
        }
        else {
            return this.id.compareTo( currency.id ) ;
        }
    }
}

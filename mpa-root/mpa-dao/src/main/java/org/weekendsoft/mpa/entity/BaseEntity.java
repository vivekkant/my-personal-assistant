/**
 * 
 */
package org.weekendsoft.mpa.entity;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.weekendsoft.mpa.dao.master.PersistenceManager;

/**
 * @author Vivek Kant
 *
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L ;
    
    protected static EntityManager em ;
    protected static boolean init = false ;

    protected static void init() {
        if ( em == null || !em.isOpen() ) {
            em = PersistenceManager.getPersistenceManager().getEntityManager() ;
        }
        init = true ;
    }
}

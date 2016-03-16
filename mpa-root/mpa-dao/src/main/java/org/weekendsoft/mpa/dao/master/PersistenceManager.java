/**
 * 
 */
package org.weekendsoft.mpa.dao.master;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * @author Vivek Kant
 *
 */
public class PersistenceManager {

    public static final String ENTITY_MANAGER_DEF_SERVICE = "MPADefaultService" ;
    public static final String ENTITY_MANAGER_SERVICE = "MPAService" ;
    
    private static PersistenceManager pm = new PersistenceManager() ;
    
    private Properties props ;
    
    @PersistenceContext(unitName=ENTITY_MANAGER_DEF_SERVICE)
    private static EntityManager em;
    
    private PersistenceManager() {
        try {
            ClassLoader cl = PersistenceManager.class.getClassLoader() ;
            InputStream is = cl.getResourceAsStream( "db.properties" ) ;
            props = new Properties() ;
            props.load( is ) ;
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
    }
    
    public static PersistenceManager getPersistenceManager() {
        return pm ;
    }
    
    public EntityManager getEntityManager() {
        if ( em == null || !em.isOpen() ) {
            if ( props == null ) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory( ENTITY_MANAGER_DEF_SERVICE ) ;
                em = emf.createEntityManager() ;
            }
            else {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory( ENTITY_MANAGER_SERVICE, props ) ;
                em = emf.createEntityManager() ;
            }
        }
        
        return em ;
    }
    
}

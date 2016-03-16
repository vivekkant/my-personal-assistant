/**
 * 
 */
package org.weekendsoft.mpa.dao.master;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.weekendsoft.mpa.entity.Currency;

/**
 * @author Vivek Kant
 *
 */
public class CurrencyMaster {
    
    public static final String ENTITY_MANAGER_SERVICE = "MPAService" ;
    
    @PersistenceContext(unitName=ENTITY_MANAGER_SERVICE)
    private static EntityManager em;
    
    public CurrencyMaster() {
        if ( em == null || !em.isOpen() ) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory( ENTITY_MANAGER_SERVICE ) ;
            em = emf.createEntityManager() ;
        }
    }
    
    public List<Currency> getAll() throws Exception {
        List<Currency> currencies = em.createQuery( "from Currency", Currency.class ).getResultList() ;
        Collections.sort( currencies ) ;
        return currencies ;
    }
    
    public Currency get( String id ) throws Exception {
        Currency currency = em.find( Currency.class, id ) ;
        return currency ;
    }
    

}

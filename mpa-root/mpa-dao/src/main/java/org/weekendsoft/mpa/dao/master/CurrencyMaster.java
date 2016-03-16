/**
 * 
 */
package org.weekendsoft.mpa.dao.master;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import org.weekendsoft.mpa.entity.Currency;

/**
 * @author Vivek Kant
 *
 */
public class CurrencyMaster {
    
    private static EntityManager em;
    
    public CurrencyMaster() {
        if ( em == null || !em.isOpen() ) {
            em = PersistenceManager.getPersistenceManager().getEntityManager() ;
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

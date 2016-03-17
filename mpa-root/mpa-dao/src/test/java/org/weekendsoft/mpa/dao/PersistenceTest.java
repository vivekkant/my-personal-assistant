package org.weekendsoft.mpa.dao;

import java.util.List;

import org.weekendsoft.mpa.entity.Currency;

public class PersistenceTest {
    
    public static void main(String[] args) throws Exception {

        System.out.println( "----------- currencies by id -----------" ) ;
        Currency cur = new Currency( "INR" ) ;
        cur.get() ;
        System.out.println( cur ) ;

        System.out.println( "----------- List of all currencies -----------" ) ;
        List<Currency> result = cur.getAll() ;
        for ( Currency currency : result ) {
            System.out.println( currency );
        }
        
    }

}

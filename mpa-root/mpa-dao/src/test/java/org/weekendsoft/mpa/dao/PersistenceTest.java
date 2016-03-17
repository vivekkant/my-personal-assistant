package org.weekendsoft.mpa.dao;

import java.util.List;

import org.weekendsoft.mpa.entity.Currency;

public class PersistenceTest {
    
    public static void main(String[] args) throws Exception {

        System.out.println( "----------- List of all currencies -----------" ) ;
        List<Currency> result = Currency.getAll() ;
        for ( Currency currency : result ) {
            System.out.println( currency );
        }
        
        System.out.println( "----------- currencies by id -----------" ) ;
        Currency indiaCur = Currency.get( "INR" ) ;
        System.out.println( indiaCur ) ;
    }

}

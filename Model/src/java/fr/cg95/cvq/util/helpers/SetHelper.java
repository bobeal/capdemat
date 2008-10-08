package fr.cg95.cvq.util.helpers;

import java.util.HashSet;
import java.util.Set;

public class SetHelper {
    
    /**
     * The relative complement of A in B (also called the set theoretic difference of B and A), 
     * denoted by B\A, (or B-A) is the set of all elements which are members of B, 
     * but not members of A.
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws ClassNotFoundException 
     * 
     * 
     */
    public static <A extends Set<?> , B extends Set<?>> B MakeRelativeComplement(A a, B b) 
        throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Set<Object> removables = new HashSet<Object>();
        B result = b;
        
        for(Object entryB : b ) {
            for(Object entryA : a) {
                if(entryB.equals(entryA)) removables.add(entryB);
            }
        }
        result.removeAll(removables);
        
        return result;
    }
    
}

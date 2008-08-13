package fr.capwebct.capdemat.plugins.csvimporters.concerto.formatter;

import java.util.HashSet;
import java.util.Set;

import fr.cg95.cvq.business.users.LocalReferentialData;

import net.sf.anupam.csv.formatters.CSVFieldFormatter;

/**
 * A formatter that converts food diet designations into local referential data.
 * 
 * @csv.formatter-mapping name="foodDiet"
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class FoodDietFormatter implements CSVFieldFormatter {

    public Object format(String value) {

        if (value == null)
            return null;
        
        if (value.equals("Rgime sans porc")
                || value.equals("Régime sans porc")
                || value.contains("sans porc")) {

            LocalReferentialData lrd = new LocalReferentialData();
            lrd.setName("NoPork");
            Set<LocalReferentialData> foodDietSet = new HashSet<LocalReferentialData>();
            foodDietSet.add(lrd);
            
            return foodDietSet;
        }
        
        return null;
    }

}

package fr.cg95.cvq.generator.plugins.i18n;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import fr.cg95.cvq.generator.common.CommonStep;
import fr.cg95.cvq.generator.common.Step;

/**
 * @author rdj@zenexity.fr
 */
public class RequestI18n {

    private String acronym;
    private Map<String,Map<String,String>> i18nLabels = new HashMap<String, Map<String,String>>();
    private  List<Step> steps;
    

    public RequestI18n(String targetNamespace) {
        this.acronym = StringUtils.substringAfterLast(targetNamespace, "/");
    }
    
    public List<Step> getSteps() {
        return steps;
    }
    public void setSteps(List<Step> steps) {
        this.steps = new ArrayList<Step>();
        for (Step step : steps) {
            if (!(step instanceof CommonStep))
               this.steps.add(step);
        }
    }
    
    public String getAcronym() {
        return acronym;
    }
    
    public Map<String, Map<String,String>> getI18nLabels() {
        return i18nLabels;
    }
    
    public void addI18nLabel(String lang, String descType, String label) {
        if (i18nLabels.get(lang) == null) {
            Map<String, String> map = new HashMap<String, String>();
            i18nLabels.put(lang, map);
        }
        i18nLabels.get(lang).put(descType, label);
    }
    
}

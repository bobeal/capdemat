package fr.cg95.cvq.util.translation.impl;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.util.translation.ITranslationService;

/**
 * @author jsb@zenexity.fr
 *
 */
public class TranslationService implements ITranslationService {

    private ReloadableResourceBundleMessageSource messageSource;

    public String translate(String code) {
        return translate(code, null, null);
    }

    public String translate(String code, Object[] args) {
        return translate(code, args, null);
    }

    public String translate(String code, Locale locale) {
        return translate(code, null, locale);
    }

    public String translate(String code, Object[] args, Locale locale) {
        if (locale == null) {
            try {
                locale = SecurityContext.getCurrentLocale();
            } catch (CvqException e) {
                locale = Locale.FRANCE;
            }
        }
        return messageSource.getMessage(code, args, locale);
    }

    public String translateRequestTypeLabel(String label) {
        return translateRequestTypeLabel(label, null);
    }

    public String translateRequestTypeLabel(String label, Locale locale) {
        StringBuffer polygramm = new StringBuffer();
        for (String word : StringUtils.split(WordUtils.uncapitalize(label), null)) {
            polygramm.append(word.charAt(0));
        }
        try {
            return translate(polygramm.append("r.label").toString(), locale);
        } catch (NoSuchMessageException e) {
            return label;
        }
    }

    public void setMessageSource(ReloadableResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }
}

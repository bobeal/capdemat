package fr.cg95.cvq.service.users;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;

import org.apache.commons.lang3.ArrayUtils;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.IndividualRole;
import fr.cg95.cvq.business.users.RoleType;

public class HasLegalResponsiblesCheck  extends AbstractAnnotationCheck<HasLegalResponsibles> {

    private static final long serialVersionUID = 1L;

    private static IUserSearchService userSearchService;

    @Override
    public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context,
        Validator validator)
        throws OValException {
        Child child = (Child) validatedObject;
        int legalResponsibles = 0;
        for (Adult adult : userSearchService.getAdults(child.getHomeFolder().getId())) {
            if (adult.getIndividualRoles() != null) {
                for (IndividualRole individualRole : adult.getIndividualRoles()) {
                    if (((child.getId() != null
                        && child.getId().equals(individualRole.getIndividualId()))
                        || child.getFullName().equals(individualRole.getIndividualName()))
                        && ArrayUtils.contains(RoleType.childRoleTypes, individualRole.getRole()))
                        legalResponsibles++;
                }
            }
        }
        return legalResponsibles > 0 && legalResponsibles < 4;
    }

    public static void setUserSearchService(IUserSearchService userSearchService) {
        HasLegalResponsiblesCheck.userSearchService = userSearchService;
    }
}

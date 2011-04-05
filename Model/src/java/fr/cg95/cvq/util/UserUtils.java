package fr.cg95.cvq.util;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.authority.IAgentService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.translation.ITranslationService;

public class UserUtils {

    private static IAgentService agentService;

    private static IHomeFolderService homeFolderService;

    private static IIndividualService individualService;

    private static ITranslationService translationService;

    public static class UserDetails {
        public String nature;
        public String name;
        public UserDetails(String nature, String name) {
            this.nature = nature;
            this.name = name;
        }
    }

    public static UserDetails getUserDetails(Long id) {
        if (id == null || id == 0) {
            return new UserDetails("", "");
        } else if (id == -1) {
            return new UserDetails("system", translationService.translate("system"));
        } else {
            try {
                Agent agent = agentService.getById(id);
                return new UserDetails("agent", agent.getFirstName() + ' ' + agent.getLastName());
            } catch (CvqObjectNotFoundException e1) {
                try {
                    Individual individual = individualService.getById(id);
                    return new UserDetails("eCitizen", individual.getFirstName() + ' ' + individual.getLastName());
                } catch (CvqObjectNotFoundException e2) {
                    try {
                        homeFolderService.getById(id);
                        return new UserDetails("eCitizen", translationService.translate("homeFolder.header"));
                    } catch (CvqObjectNotFoundException e3) {
                        return new UserDetails("", "");
                    }
                }
            }
        }
    }

    public static String getNature(Long id) {
        return getUserDetails(id).nature;
    }

    public static String getDisplayName(Long id) {
        return getUserDetails(id).name;
    }

    public static void setAgentService(IAgentService agentService) {
        UserUtils.agentService = agentService;
    }

    public static void setHomeFolderService(IHomeFolderService homeFolderService) {
        UserUtils.homeFolderService = homeFolderService;
    }

    public static void setIndividualService(IIndividualService individualService) {
        UserUtils.individualService = individualService;
    }

    public static void setTranslationService(ITranslationService translationService) {
        UserUtils.translationService = translationService;
    }
}

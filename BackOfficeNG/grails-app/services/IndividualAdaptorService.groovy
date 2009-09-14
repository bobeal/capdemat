import fr.cg95.cvq.business.users.SexType
import fr.cg95.cvq.business.users.TitleType

class IndividualAdaptorService {

    public getIndividualDescription(individual) {
        def result = ["firstName" : "", "lastName" : "", "title" : ""]
        if (!individual) return result
        result.firstName = individual.firstName
        result.lastName = individual.lastName
        if (individual.class.simpleName == "Child") {
            switch (SexType.forString(individual.sex)) {
                case SexType.MALE :
                    result.title = TitleType.MISTER
                    break;
                case SexType.FEMALE :
                    result.title = TitleType.MISS
                    break;
                default :
                    result.title = TitleType.UNKNOWN
            }
        } else if (individual.class.simpleName == "Adult") {
            result.title = individual.title
        }
        return result
    }
}
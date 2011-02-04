import fr.cg95.cvq.business.users.Child
import fr.cg95.cvq.business.users.SexType
import fr.cg95.cvq.business.users.TitleType
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.util.translation.ITranslationService

class IndividualAdaptorService {

    ITranslationService translationService
    IIndividualService individualService

    public getIndividualDescription(individual) {
        def result = ["firstName" : "", "lastName" : "", "title" : ""]
        if (!individual) return result
        result.firstName = individual.firstName
        result.lastName = individual.lastName
        if (individual.class.simpleName == "Child") {
            switch (individual.sex) {
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

    public adaptSubjects(subjects) {
        def result = [:]
        subjects.each {
            def subject = individualService.getById(it)
            result[it] = subject instanceof Child && !subject.born ? translationService.translate("request.subject.childNoBorn", subject.fullName) : subject.fullName
        }
        return result
    }

    public adaptMeansOfContact(meansOfContact) {
        def result = []
        meansOfContact.each {
            result.add([
                key : it.type,
                label : translationService.translate("meansOfContact." + StringUtils.pascalToCamelCase(it.type.toString()))
            ])
        }
        return result.sort {it.label}
    }
}

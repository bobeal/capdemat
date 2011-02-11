import com.google.gson.JsonObject

import fr.cg95.cvq.business.users.Child
import fr.cg95.cvq.business.users.SexType
import fr.cg95.cvq.business.users.TitleType
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.util.translation.ITranslationService
import fr.cg95.cvq.exception.CvqValidationException

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

    public historize(individual, bean, dto, name, fields) throws CvqValidationException {
        def atom = new JsonObject()
        atom.addProperty("name", name)
        def diff = new JsonObject()
        atom.add("fields", diff)
        fields.each {
            if (dto[it] != bean[it]) {
                def field = new JsonObject()
                field.addProperty("from", bean[it].toString())
                field.addProperty("to", dto[it].toString())
                diff.add(it, field)
                bean[it] = dto[it]
            }
        }
        def invalidFields = individualService.validate(individual)
        if (!invalidFields.isEmpty()) throw new CvqValidationException(invalidFields)
        if (diff.entrySet().size() > 0) individualService.modify(individual, atom)
    }
}

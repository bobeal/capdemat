import fr.cg95.cvq.service.request.school.ISaintouenInscriptionScolaireGlobaleRequestService;
import grails.converters.JSON

class FrontofficeSaintouenInscriptionScolaireGlobaleController {
    ISaintouenInscriptionScolaireGlobaleRequestService saintouenInscriptionScolaireGlobaleRequestService;

    def schoolSectors = {
        render(
            saintouenInscriptionScolaireGlobaleRequestService.getSchools(Long.valueOf(params.childId)).get("schoolSectors")
        as JSON)
    }

}
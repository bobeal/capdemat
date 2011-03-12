package fr.cg95.cvq.service.request.school.external;

import java.util.Map;

import fr.cg95.cvq.business.users.Child;

public interface IScholarBusinessProviderService {

    Map<String, Map<String, String>> getSchools(Child child);

    Map<String, String> getHolidayCamps(Child child);

    Map<String, String> getLeisureCenters(Child child);

    Map<String, String> getTransportLines(Child child);

    Map<String, String> getTransportStops(Child child, String lineId);
}

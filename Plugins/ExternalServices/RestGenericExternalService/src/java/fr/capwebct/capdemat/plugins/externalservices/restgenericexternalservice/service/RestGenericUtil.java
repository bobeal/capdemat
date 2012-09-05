package fr.capwebct.capdemat.plugins.externalservices.restgenericexternalservice.service;

import fr.cg95.cvq.util.web.WS.HttpResponse;

public class RestGenericUtil {

    private RestGenericUtil() {}

    public static String externalIdFromIISString(HttpResponse response) {
        return response.getString().replaceAll("<.*?>", "");
    }

}

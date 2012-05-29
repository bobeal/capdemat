class ServiceUrlMappings {
  static mappings = {

    "/service/fakePayment/$action?/$id?" (controller : "serviceFakePayment" )
    "/service/spplus/$action?/$id?" (controller : "serviceSpplus" )
    "/service/systempay/$action?/$id?" (controller : "serviceSystemPay" )
    "/autocomplete/$action?" (controller: "serviceAutocomplete")
    "/service/request/$requestId/documents" (controller: "serviceRequestExternal", action: "requestDocuments")
    "/service/request/$requestId/document/$documentId?" (controller: "serviceRequestExternal", action: "requestDocument")
    "/service/paylineV4/$action?/$id?" (controller : "servicePaylineV4")
    "/service/provisioning/$localAuthority/$action?/$id?" (controller : "serviceProvisioning")
    "/service/requestType/$requestTypeLabel/localReferential" (controller : "serviceRequestExternal"){action = [POST : "localReferential"]}
    "/service/request/$requestId/state" (controller : "serviceRequestExternal"){action = [POST : "requestState"]}
    "/service/requestType/$requestTypeLabel/season" (controller : "serviceRequestExternal"){action = [GET : "requestTypeSeason"]}
  }
}

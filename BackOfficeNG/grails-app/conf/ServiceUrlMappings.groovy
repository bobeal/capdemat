class ServiceUrlMappings {
  static mappings = {

    "/service/fakePayment/$action?/$id?" (controller : "serviceFakePayment" )
    "/service/spplus/$action?/$id?" (controller : "serviceSpplus" )
    "/autocomplete/$action?" (controller: "serviceAutocomplete")
    "/service/request/$requestId/documents" (controller: "serviceRequestExternal", action: "requestDocuments")
    "/service/request/$requestId/document/$documentId?" (controller: "serviceRequestExternal", action: "requestDocument")
    "/service/paylineV4/$action?/$id?" (controller : "servicePaylineV4")
    "/service/provisioning/$localAuthority/$action?/$id?" (controller : "serviceProvisioning")
  }
}

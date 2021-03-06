class BackofficeUrlMappings {
  static mappings = {
    "/backoffice/requestAdmin/$action?/$id?" (controller : "backofficeRequestAdmin" )
    "/backoffice/requestArchives/$action?/$id?" (controller : "backofficeRequestArchives" )
    "/backoffice/requestType/$action?/$id?" (controller : "backofficeRequestType" )
    "/backoffice/payment/$action?/$id?" (controller : "backofficePayment" )
    "/backoffice/category/$action?/$id?" (controller : "backofficeCategory" )
    "/backoffice/request/$action?/$id?" (controller : "backofficeRequest" )
    "/backoffice/requestInstruction/$action?/$id?" (controller : "backofficeRequestInstruction" )
    "/backoffice/localAuthority/$action?/$id?" (controller : "backofficeLocalAuthority" )
    "/backoffice/home/$action?/$id?" (controller : "backofficeHome" )
    "/backoffice/contact/$action?/$id?" (controller : "backofficeContact" )
    "/backoffice/login/$action?/$id?" (controller : "backofficeLogin" )
    "/backoffice/documentInstruction/$action?/$id?" (controller : "backofficeDocumentInstruction" )
    "/backoffice/homeFolder/$id/state" (controller : "backofficeHomeFolder", action : "state")
    "/backoffice/homeFolder/individual/$id/state" (controller : "backofficeHomeFolder", action : "state")
    "/backoffice/homeFolder/individual/$id/identity" (controller : "backofficeHomeFolder", action : "identity")
    "/backoffice/homeFolder/individual/$id/$externalServiceLabel/mapping" (controller : "backofficeHomeFolder", action : "mapping")
    "/backoffice/homeFolder/adult/$id/address" (controller : "backofficeHomeFolder", action : "address")
    "/backoffice/homeFolder/adult/$id/contact" (controller : "backofficeHomeFolder", action : "contact")
    "/backoffice/homeFolder/child/$id/responsibles" (controller : "backofficeHomeFolder", action : "responsibles")
    "/backoffice/homeFolder/$action?/$id?" (controller : "backofficeHomeFolder" )
    "/backoffice/displayGroup/$action?/$id?" (controller : "backofficeDisplayGroup" )
    "/backoffice/agent/$action?/$id?" (controller : "backofficeAgent" )
    "/backoffice/statistic/$action?/$id?" (controller : "backofficeStatistic" )
    "/backoffice/externalApplication/$action?/$id?" (controller : "backofficeExternalApplication" )
    "/backoffice/external/$action?/$id?" (controller : "backofficeExternal" )
    "/backoffice/tasks/$action?/$id?" (controller : "backofficeTasks" )
    "/backoffice/ticketBooking/$action?/$id?" (controller : "backofficeTicketBooking" )
    "/backoffice/userSecurity/$action?/$id?" (controller : "backofficeUserSecurity" )
    "/backoffice/userDocumentInstruction/$action?/$id?" (controller : "backofficeUserDocumentInstruction" )
  }
}

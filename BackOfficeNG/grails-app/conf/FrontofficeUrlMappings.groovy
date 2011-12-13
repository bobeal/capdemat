class FrontofficeUrlMappings {
  static mappings = {

    "/frontoffice/requestType/$action?/$id?" (controller : "frontofficeRequestType" )
    "/frontoffice/activity/$action?/$id?" (controller : "frontofficeActivity" )
    "/frontoffice/payment/$action?/$id?" (controller : "frontofficePayment" )
    "/frontoffice/document/$action?/$id?" (controller : "frontofficeDocument" )
    "/frontoffice/request/$action?/$id?" (controller : "frontofficeRequest" )
    "/frontoffice/requestDocument/$action?/$id?" (controller : "frontofficeRequestDocument" )
    "/frontoffice/home/$action?/$id?" (controller : "frontofficeHome" )
    "/frontoffice/homeFolder/$action?/$id?" (controller : "frontofficeHomeFolder" )
    "/frontoffice/homeFolderDocument/$action?/$id?" (controller : "frontofficeHomeFolderDocument" )
    "/frontoffice/ticketBooking/$action?/$id?" (controller : "frontofficeTicketBooking" )
    "/frontoffice/technocarte/$action/$id?" (controller : "frontofficeTechnocarte")
    "/frontoffice/globalSchoolRegistration/$action?/$id?" (controller : "frontofficeGlobalSchoolRegistration")
    "/frontoffice/holidayCampRegistration/$action?/$id?" (controller : "frontofficeHolidayCampRegistration")
    "/frontoffice/leisureCenterRegistration/$action?/$id?" (controller : "frontofficeLeisureCenterRegistration")
    "/frontoffice/schoolTransportRegistration/$action?/$id?" (controller : "frontofficeSchoolTransportRegistration")
    "/frontoffice/saintouenInscriptionScolaireGlobale/$action?/$id?" (controller : "frontofficeSaintouenInscriptionScolaireGlobale")
  }
}

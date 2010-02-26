class FrontofficeUrlMappings {
  static mappings = {

    "/frontoffice/requestType/$action?/$id?" (controller : "frontofficeRequestType" )
    "/frontoffice/activity/$action?/$id?" (controller : "frontofficeActivity" )
    "/frontoffice/payment/$action?/$id?" (controller : "frontofficePayment" )
    "/frontoffice/requestCreation/$action?/$id?" (controller : "frontofficeRequestCreation" )
    "/frontoffice/document/$action?/$id?" (controller : "frontofficeDocument" )
    "/frontoffice/request/$action?/$id?" (controller : "frontofficeRequest" )
    "/frontoffice/home/$action?/$id?" (controller : "frontofficeHome" )
    "/frontoffice/homeFolder/$action?/$id?" (controller : "frontofficeHomeFolder" )

  }
}

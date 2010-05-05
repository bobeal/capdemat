class ServiceUrlMappings {
  static mappings = {
    "/service/fakePayment/$action?/$id?" (controller : "serviceFakePayment")
    "/autocomplete/$action?" (controller: "serviceAutocomplete")
  }
}

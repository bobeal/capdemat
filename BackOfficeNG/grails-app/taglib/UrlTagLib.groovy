class UrlTagLib {

    private String action = "youReallyShouldntNameYourActionLikeThis"

    def baseUrl = { params ->
        params.action = action
        def url = g.createLink(params)
        out << url.substring(0, url.size() - (action.size() + 1))
    }
}

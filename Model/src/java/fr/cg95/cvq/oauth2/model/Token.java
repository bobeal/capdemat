package fr.cg95.cvq.oauth2.model;

public class Token {

    private final String accessToken;
    private final String tokenType;
    private final int expiresIn;
    private final String scope;
    private final String refreshToken;

    public Token(String accessToken, String tokenType, int expiresIn, String scope,
            String refreshToken) {
        super();
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.scope = scope;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

}

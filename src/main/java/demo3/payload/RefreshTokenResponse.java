package demo3.payload;

public class RefreshTokenResponse {

	private String accessToken;
	private String refreshToken;
	private String tokenType = "Bearer";

	public RefreshTokenResponse(String accessToken, String refreshToken) {
		    this.accessToken = accessToken;
		    this.refreshToken = refreshToken;
		  }

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String token) {
		this.accessToken = token;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

}

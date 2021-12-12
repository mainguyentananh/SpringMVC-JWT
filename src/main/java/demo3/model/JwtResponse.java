package demo3.model;

public class JwtResponse implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
   
    private String accessToken;
    private String tokenType;
	
    
    public JwtResponse() {	
	}

	public JwtResponse(String accessToken, String tokenType) {

		this.accessToken = accessToken;
		this.tokenType = tokenType;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}


	
	
}

package demo3.payload;

import java.util.List;

public class JwtResponse implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String username;
	private String accessToken;
	private String refreshToken;
	private String tokenType = "Bearer";
	private List<String> roles;

	public JwtResponse() {
	}

	public JwtResponse(int id, String username, String accessToken, String refreshToken, List<String> roles) {
		this.id = id;
		this.username = username;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}

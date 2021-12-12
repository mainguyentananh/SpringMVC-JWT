package demo3.config;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import demo3.model.Account;
import demo3.model.Role;


public class UserPrincipal implements UserDetails{
	

	private static final long serialVersionUID = 1L;
	private int id;
	@JsonIgnore
	private String username;
	@JsonIgnore
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;

	
	
	public UserPrincipal(int id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static UserPrincipal create(Account account) {
		Set<Role> roles = account.getRole();
		List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getRolename())).collect(Collectors.toList());
		return new UserPrincipal(account.getId_account(), account.getUsername(), account.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	
 }
	


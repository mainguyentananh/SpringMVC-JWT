package demo3.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_account")
	private int id_account;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@OneToMany(mappedBy = "account")
	private List<Account_Role> account_AR;

	@OneToOne(mappedBy = "RT_account")
	private RefreshToken refreshToken;

	public Account() {
	}

	public Account(int id_account, String username, String password, List<Account_Role> account_AR,
			RefreshToken refreshToken) {
		this.id_account = id_account;
		this.username = username;
		this.password = password;
		this.account_AR = account_AR;
		this.refreshToken = refreshToken;
	}

	public int getId_account() {
		return id_account;
	}

	public void setId_account(int id_account) {
		this.id_account = id_account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Account_Role> getAccount_AR() {
		return account_AR;
	}

	public void setAccount_AR(List<Account_Role> account_AR) {
		this.account_AR = account_AR;
	}

	public Set<Role> getRole() {
		Set<Role> roles = new HashSet<Role>();
		for (int i = 0; i < this.getAccount_AR().size(); i++) {
			roles.add(this.getAccount_AR().get(i).getRole());
		}
		return roles;
	}

	public RefreshToken getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(RefreshToken refreshToken) {
		this.refreshToken = refreshToken;
	}

}

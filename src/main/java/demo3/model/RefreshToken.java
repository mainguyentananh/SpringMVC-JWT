package demo3.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RefreshToken")
public class RefreshToken implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_rt")
	private int id;

	@Column(name = "refreshtoken")
	private String refreshtoken;

	@Column(name = "expirydate")
	private Instant expiryDate;

	@OneToOne
	@JoinColumn(name = "id_account")
	private Account RT_account;

	public RefreshToken() {
	}

	public RefreshToken(int id, String refreshtoken, Instant expiryDate, Account rT_account) {
		this.id = id;
		this.refreshtoken = refreshtoken;
		this.expiryDate = expiryDate;
		RT_account = rT_account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRefreshtoken() {
		return refreshtoken;
	}

	public void setRefreshtoken(String refreshtoken) {
		this.refreshtoken = refreshtoken;
	}

	public Instant getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Instant expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Account getRT_account() {
		return RT_account;
	}

	public void setRT_account(Account rT_account) {
		RT_account = rT_account;
	}

}

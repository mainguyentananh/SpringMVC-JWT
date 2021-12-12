package demo3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_role")
	private int id_role;

	@Column(name = "rolename")
	private String rolename;
	
	@OneToMany(mappedBy = "role")
	private List<Account_Role> role_AR;

	public Role() {
	}

	public Role(int id_role, String rolename, List<Account_Role> role_AR) {
		this.id_role = id_role;
		this.rolename = rolename;
		this.role_AR = role_AR;
	}

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<Account_Role> getRole_AR() {
		return role_AR;
	}

	public void setRole_AR(List<Account_Role> role_AR) {
		this.role_AR = role_AR;
	}
	
}

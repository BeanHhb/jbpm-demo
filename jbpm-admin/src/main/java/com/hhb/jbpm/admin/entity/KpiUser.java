package com.hhb.jbpm.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author huanghebin
 * @date 2020/9/18 16:04
 */
@Data
@Entity
@Table(name="kpi_user")
public class KpiUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "age")
	private int age;

	@Column(name = "status")
	private int status;

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@JoinTable(
			name="kpi_user_role",
			joinColumns=@JoinColumn(name="uid",referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="rid")
	)
	@JsonIgnore
	private List<KpiRole> roles = new ArrayList<KpiRole>();

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", status="
				+ status + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		for(KpiRole role:roles) {
			role.setRolename("ROLE_"+role.getRolename());
			System.out.println(role.getAuthority());
		}
		return roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}

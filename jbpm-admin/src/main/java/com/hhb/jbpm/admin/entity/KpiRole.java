package com.hhb.jbpm.admin.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author huanghebin
 * @date 2020/9/18 16:13
 */
@Data
@Entity
@Table(name="kpi_role")
public class KpiRole implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;

	private String rolename;

	private int status;

	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", status=" + status + "]";
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return rolename;
	}
}


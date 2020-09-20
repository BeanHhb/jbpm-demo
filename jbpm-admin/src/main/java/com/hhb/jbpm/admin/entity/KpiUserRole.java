package com.hhb.jbpm.admin.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author huanghebin
 * @date 2020/9/18 16:21
 */
@Data
@Entity
@Table(name="kpi_user_role")
public class KpiUserRole {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "rid")
	private int rid;

	@Column(name = "uid")
	private int uid;

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", rid=" + rid + ", uid=" + uid + "]";
	}

}

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
	private int id;

	private int rid;

	private int uid;

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", rid=" + rid + ", uid=" + uid + "]";
	}

}

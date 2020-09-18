package com.hhb.jbpm.admin.dao;

import com.hhb.jbpm.admin.entity.KpiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author huanghebin
 * @date 2020/9/18 16:22
 */
@Repository
public interface KpiUserRepository extends JpaRepository<KpiUser, Long> {

	@Query("from KpiUser where username=?1")
	public KpiUser findUserByName(String username);
}

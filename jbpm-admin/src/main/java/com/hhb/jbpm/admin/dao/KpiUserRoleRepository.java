package com.hhb.jbpm.admin.dao;

import com.hhb.jbpm.admin.entity.KpiUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huanghebin
 * @date 2020/9/18 16:25
 */
@Repository
public interface KpiUserRoleRepository extends JpaRepository<KpiUserRole, Long> {

}

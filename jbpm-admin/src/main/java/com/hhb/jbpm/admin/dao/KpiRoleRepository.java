package com.hhb.jbpm.admin.dao;

import com.hhb.jbpm.admin.entity.KpiRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huanghebin
 * @date 2020/9/18 16:24
 */
@Repository
public interface KpiRoleRepository extends JpaRepository<KpiRole, Long> {

}

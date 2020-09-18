package com.hhb.jbpm.admin.service;

import com.hhb.jbpm.admin.dao.KpiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author huanghebin
 * @date 2020/9/18 16:26
 */
@Service
public class KpiUserService implements UserDetailsService {

	@Autowired
	KpiUserRepository kpiUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return kpiUserRepository.findUserByName(username);
	}
}

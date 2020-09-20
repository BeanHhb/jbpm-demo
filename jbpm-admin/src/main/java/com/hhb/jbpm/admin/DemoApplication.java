package com.hhb.jbpm.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author huanghebin
 * @date 2020/9/18 11:35
 */
@SpringBootApplication
@EntityScan(basePackages = "com.hhb.jbpm.admin.entity")
@EnableJpaRepositories(basePackages = "com.hhb.jbpm.admin.dao")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

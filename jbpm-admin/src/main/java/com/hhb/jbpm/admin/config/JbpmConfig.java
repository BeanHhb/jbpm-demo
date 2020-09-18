package com.hhb.jbpm.admin.config;

import org.jbpm.services.task.identity.DBUserGroupCallbackImpl;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.*;
import org.kie.api.task.TaskService;
import org.kie.api.task.UserGroupCallback;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.manager.context.EmptyContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.persistence.EntityManagerFactory;

/**
 * @author huanghebin
 * @date 2020/9/18 11:35
 */
@Configuration
public class JbpmConfig {

	@Bean
	RuntimeEnvironment runtimeEnvironment(EntityManagerFactory entityManagerFactory) {
		RuntimeEnvironment runtimeEnvironment = RuntimeEnvironmentBuilder.Factory.get()
				.newDefaultBuilder().entityManagerFactory(entityManagerFactory)
				//Test.bpmn放置于resource文件夹下
				.addAsset(ResourceFactory.newClassPathResource("Test.bpmn"), ResourceType.BPMN2)
				.get();
		return runtimeEnvironment;
	}

	@Bean
	RuntimeManager runtimeManager(RuntimeManagerFactory runtimeManagerFactory,RuntimeEnvironment runtimeEnvironment) {
		RuntimeManager runtimeManager = runtimeManagerFactory.newSingletonRuntimeManager(runtimeEnvironment);
		return runtimeManager;
	}
	@Bean
	RuntimeEngine runtimeEngine(RuntimeManager runtimeManager) {
		RuntimeEngine runtimeEngine = runtimeManager.getRuntimeEngine(EmptyContext.get());
		return runtimeEngine;
	}
	@Bean
	KieSession kieSession(RuntimeEngine runtimeEngine) {
		KieSession kieSession = runtimeEngine.getKieSession();
		return kieSession;
	}
	@Bean
	TaskService taskService(RuntimeEngine runtimeEngine) {
		TaskService taskService = runtimeEngine.getTaskService();
		return taskService;
	}
	//userGroupCallback用于判断用户是否存在，组是否存在，找到用户所属的组，默认已经配置了SpringSecurityUserGroupCallback作为userGroupCallback的bean，但是我们希望使用自己的数据库表来进行判断，所以配置DBUserGroupCallbackImpl作为 userGroupCallback的bean，需要使用jbpm.usergroup.callback.properties来配置
	@Bean
	@DependsOn("jndiDataSource")
	UserGroupCallback userGroupCallback() {
		return new DBUserGroupCallbackImpl(true);
	}

}
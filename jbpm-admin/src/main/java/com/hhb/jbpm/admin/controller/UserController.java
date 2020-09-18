package com.hhb.jbpm.admin.controller;

import com.hhb.jbpm.admin.dao.KpiUserRepository;
import com.hhb.jbpm.admin.entity.KpiUser;
import org.kie.api.runtime.KieSession;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.TaskSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huanghebin
 * @date 2020/9/18 16:31
 */
@RestController
@RequestMapping("kpi")
public class UserController {

	@Autowired
	private KieSession kieSession;
	@Autowired
	private TaskService taskService;
	@Autowired
	private KpiUserRepository userRepository;

	@RequestMapping(value="index")
	public String Index() {
		return "<h1 style='color:red'>Welcome, Pleas Login!</h1>";
	}
	@RequestMapping(value="error")
	public String error() {
		return "<h1 style='color:red'>User have no right to access!</h1>";
	}

	@PostMapping(value = "startProcess")
	public Long startProcess(String userId) {
		Map<String, Object> data = new HashMap<String, Object>(16);
		data.put("Manager", userId);
		return kieSession.startProcess("Test", data).getId();
	}
	@GetMapping(value="getTask")
	public List<TaskSummary> getTask() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		return taskService.getTasksAssignedAsPotentialOwner(auth.getName(), "en_US");
	}
	@PostMapping("startTask")
	public void startTask(String userId,Long taskId) {
		taskService.start(taskId, userId);
	}
	@PostMapping("completeTask")
	public void completeTask(String userId,Long taskId) {
		taskService.complete(taskId, userId, null);
	}

	@PostMapping("claim")
	public void claim(String userId,Long taskId) {
		taskService.claim(taskId, userId);
	}
	//用于测试 jpa是否配置生效
	@GetMapping("getUserByUsername/{username}")
	public KpiUser getUserName(@PathVariable("username") String username) {

		KpiUser user=userRepository.findUserByName(username);
		System.out.println(userRepository.getClass());
		return user;
	}
}

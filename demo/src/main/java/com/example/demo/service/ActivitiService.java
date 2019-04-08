package com.example.demo.service;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ActivitiService {
    //注入为我们自动配置好的服务
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;
    //开始流程，传入申请者的id以及公司的id
    public void startProcess(Long personId, Long compId) {
        System.out.println("method startActivityDemo begin....");

        System.out.println( "调用流程存储服务，查询部署数量："
                + repositoryService.createDeploymentQuery().count());

        //流程启动
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("apply","zhangsan");//申请者id
        map.put("approve","lisi");//审批者id
        runtimeService.startProcessInstanceByKey("leave", map);
    }

    //获得某个人的任务别表
    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskCandidateUser(assignee).list();
    }

    //完成任务
    public void completeTasks(Boolean joinApproved, String taskId) {
        Map<String, Object> taskVariables = new HashMap<String, Object>();
        taskVariables.put("joinApproved", joinApproved);
        taskService.complete(taskId, taskVariables);
    }


}

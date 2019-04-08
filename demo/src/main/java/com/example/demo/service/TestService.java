package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TestService {
    public void startActiviti(){
        System.out.println("任务已经执行......................");
    }
    public List<String> user() {
        return Arrays.asList("xiaoming","xiaohong");

    }
}

package com.example.demoquartz1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoQuartz1Application implements CommandLineRunner {

    @Autowired
    private SchedulerJobService schedulerJobService;
    public static void main(String[] args) {
        SpringApplication.run(DemoQuartz1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        schedulerJobService.scheduleNewJob();
    }
}

package com.example.demoquartz1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Properties;

@Configuration
public class SchedulerConfig {

    @Autowired
    private ApplicationContext applicationContext;
//    @Autowired
//    private QuartzProperties quartzProperties;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {

//        SchedulerJobFactory jobFactory = new SchedulerJobFactory();
//        jobFactory.setApplicationContext(applicationContext);
//        SchedulerFactoryBean factory = new SchedulerFactoryBean();
//        factory.setOverwriteExistingJobs(true);
//        factory.setJobFactory(jobFactory);
//        return factory;

        SchedulerFactoryBean quartzScheduler = new SchedulerFactoryBean();



        SchedulerJobFactory jobFactory = new SchedulerJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        quartzScheduler.setJobFactory(jobFactory);



        return quartzScheduler;
    }

}

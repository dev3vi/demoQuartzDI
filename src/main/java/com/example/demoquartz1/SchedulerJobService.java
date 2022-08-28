package com.example.demoquartz1;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class SchedulerJobService {
    @Autowired
    private SchedulerJobCreator schedulerJobCreator;
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    @Autowired
    private ApplicationContext context;

    @SuppressWarnings("unchecked")
    public void scheduleNewJob(){
        System.out.println("scheduleNewJob");
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            JobDetail jobDetail = JobBuilder
                    .newJob((Class<? extends QuartzJobBean>) Class.forName(TestJob.class.getName()))
                    .withIdentity("jobName1", "jobGr1").build();
//            JobDetail jobDetail = schedulerJobCreator.createJob(
//                    (Class<? extends QuartzJobBean>) Class.forName(TestJob.class.getName()), false,
//                    context);
            Trigger trigger = schedulerJobCreator.createCronTrigger("0 52 12 * * ?");

            scheduler.scheduleJob(jobDetail, trigger);

            log.info(">>>>> jobName = [" + "jobName1" + "]" + " scheduled.");

        } catch (ClassNotFoundException e) {
            log.error("Class Not Found - {}", TestJob.class.getName(), e);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }
}

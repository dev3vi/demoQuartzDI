package com.example.demoquartz1;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class TestJob extends QuartzJobBean {

    @Autowired
    private PrintDI printDI;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        printDI.prints();
        System.out.println("job is started! - " + new Date());
    }

}

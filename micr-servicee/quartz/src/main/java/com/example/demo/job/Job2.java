package com.example.demo.job;

import com.example.demo.entity.BaseJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Job2 implements BaseJob {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(Thread.currentThread().getName().toString()+":"+this.getClass().getName()+":"+sdf.format(date));
    }
}

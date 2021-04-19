package com.example.demo;

import com.example.demo.job.Job1;
import org.mybatis.spring.annotation.MapperScan;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

    /**
     * // 通过SchedulerFactory获取一个调度器实例
     * SchedulerFactory sf = new StdSchedulerFactory();
     * Scheduler scheduler = sf.getScheduler();
     * //构建job信息
     * JobDetail jobDetail = JobBuilder.newJob(getClass(sysJob.getJobClassPath()).getClass()).withIdentity(jobClassName, jobGroupName).build();
     * //表达式调度构建器(即任务执行的时间)
     * CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(sysJob.getJobCron());
     * //按新的cronExpression表达式构建一个新的trigger
     * CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName)
     * .withSchedule(scheduleBuilder).startNow().build();
     * scheduler.scheduleJob(jobDetail, trigger);
     *
     * @param args
     */
    public static void main(String[] args) throws SchedulerException {
        SpringApplication.run(DemoApplication.class, args);
		/**
		 * 基于内存存储最简单的demo
		 */
//		// 创建调度器
//		SchedulerFactory sf = new StdSchedulerFactory();
//		Scheduler scheduler = sf.getScheduler();
//		// 启动调度器
//		scheduler.start();
//		// 创建任务
//		JobDetail jobDetail = JobBuilder.newJob(Job1.class).withIdentity("first", "group-1").build();
//		// 创建调度规则
//		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/2 * * * * ? ");
//		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("secnd", "group-2").withSchedule(scheduleBuilder).startNow().build();
//		// 将任务与规则绑定一起设置到调度器
//		scheduler.scheduleJob(jobDetail, trigger);
    }

}

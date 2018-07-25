package com.offcn.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


//  两种方式的时间触发器
public class Quartz {

//  SimpleScheduleBuilder方式的创建，比第二种简单
    public static void main1(String[] args) throws Exception{

//      1.job
        JobDetail job = JobBuilder.newJob(Myjob.class).withIdentity("job1", "group1").build();

//      2.时间规则表
        SimpleScheduleBuilder sbr = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).withRepeatCount(10);

//      3.创建触发器
        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(sbr).startNow().build();

//      4.调度器
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();

//      5.线程睡眠
        Thread.sleep(200*1000);
    }

//  CronScheduleBuilder方式的创建
    public static void main(String[] args)  {
//      job
        JobDetail job = JobBuilder.newJob(Myjob.class).withIdentity("job1", "group1").build();

//      时间规则表
        CronScheduleBuilder cs = CronScheduleBuilder.cronSchedule("0/10 * * * * ? *");

//      触发器
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(cs).startNow().build();
        try {
//          调度器
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();

//          线程睡眠
            Thread.sleep(200*1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

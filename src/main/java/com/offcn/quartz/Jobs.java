package com.offcn.quartz;

import java.util.Date;

//  在一个类中执行多任务，applicationContext-Quartz.xml
public class Jobs {

//    任务一
    public void job1(){
        System.out.println(new Date()+"job1");
    }

//    任务一
    public void job2(){
        System.out.println(new Date()+"job2");
    }

}

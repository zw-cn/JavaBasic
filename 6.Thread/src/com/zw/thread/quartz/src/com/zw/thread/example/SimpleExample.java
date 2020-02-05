package com.zw.thread.example;/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.evenSecondDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * This Example will demonstrate how to start and shutdown the Quartz scheduler and how to schedule a job to run in
 * Quartz.
 * 
 * @author Bill Kratzer
 */
public class SimpleExample {

  public void run() throws Exception {
    //1.创建调度器工厂
    SchedulerFactory sf = new StdSchedulerFactory();

    //2.获取调度器
    Scheduler sched = sf.getScheduler();

    //3.设置运行时间
    Date runTime = evenSecondDate(new Date());

    //4.创建任务对象
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();

    //5.设置触发器
//    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).withSchedule(simpleSchedule().withIntervalInSeconds(1).withRepeatCount(2)).build();

    //6.调度器绑定任务和触发器
    sched.scheduleJob(job, trigger);

    //7.执行调度器
    sched.start();

    try {
      // wait 65 seconds to show job
      Thread.sleep(5L * 1000L);
      // executing...
    } catch (Exception e) {
      //
    }

    // shut down the scheduler
    System.out.println("------- Shutting Down ---------------------");
    sched.shutdown(true);
    System.out.println("------- Shutdown Complete -----------------");
  }

  public static void main(String[] args) throws Exception {

    SimpleExample example = new SimpleExample();
    example.run();

  }

}

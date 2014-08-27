package com.palm.quartz.job;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.palm.quartz.util.SpringHelper;

public class QuartzJobTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSpring() throws InterruptedException {
		SpringHelper.init();
		Thread.sleep(1000000);
	}

//	@Test
	public void testStart() throws SchedulerException, InterruptedException {
		JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
				.withIdentity("name", "group").build();
		ScheduleBuilder<?> builder = null;
		// 简单定时器
//		builder = SimpleScheduleBuilder.simpleSchedule()
//				.withIntervalInSeconds(10) // 时间间隔
//				.withRepeatCount(5); // 重复次数(将执行6次)
		// 表达式定时器
		builder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");// 一秒执行一次
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("name", "group").startNow().withSchedule(builder)
				.build();
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
		Thread.sleep(1000000);
	}
	
//	@Test
	public void testExpression() {// 验证quartz表达式是否正确
		String expresssion = "0/1 * * * * ?";
		boolean result = CronExpression.isValidExpression(expresssion);
		System.out.println(result);
	}

	@After
	public void tearDown() throws Exception {
		
	}

}

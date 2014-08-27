package com.palm.quartz.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * QuartzJob(Quartz2.2.1版本)
 * DisallowConcurrentExecution不允许并发
 * @author weixiang.qin
 * 
 */
@DisallowConcurrentExecution
public class QuartzJob implements Job {
	private Logger logger = LoggerFactory.getLogger(ScheduleJob.class);

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		logger.info("QuartzJob.execute...");
		sleep();
	}

	private void sleep() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

package com.palm.quartz.job;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.palm.quartz.util.Config;

/**
 * ScheduleJob(Quartz2.2.1版本)
 * 
 * @author weixiang.qin
 * 
 */
public class ScheduleJob {
	private Logger logger = LoggerFactory.getLogger(ScheduleJob.class);
	@Resource
	private Config config;
	
	public void execute() {
		logger.info("ScheduleJob.execute..." + config.getConfig());
		sleep();
	}
	
	private void sleep(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

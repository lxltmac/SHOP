package com.wsh.auth.schedule;

import com.wsh.auth.schedule.job.ClearInvalidTokenTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
public class ClearInvalidTokenConfigurer implements SchedulingConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskExecutor());
		
		//每天1点清除无效的Token （测试0/10 * * * * ?)
		//taskRegistrar.addCronTask(new ClearInvalidTokenTask(), "0/10 * * * * ?");
		taskRegistrar.addCronTask(new ClearInvalidTokenTask(), "0 0 1 * * ?");
	}

	@Bean(destroyMethod = "shutdown")
	public Executor taskExecutor() {
		return Executors.newScheduledThreadPool(10);
	}

}

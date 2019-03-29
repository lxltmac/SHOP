package com.wsh;

import org.apache.log4j.Logger;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Application {
	
	private static Logger logger = Logger.getLogger(Application.class);
	
	/**
	 * 服务启动入口
	 * @param args
	 */
	public static void main(String[] args) {

		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.setBannerMode(Banner.Mode.CONSOLE);
		springApplication.run(args);
		
		logger.info("=======SHOP项目已经启动成功了=============");
	}
}

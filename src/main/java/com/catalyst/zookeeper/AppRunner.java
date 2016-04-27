package com.catalyst.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * spring boot runner class
 * @author jgao
 *
 */
@SpringBootApplication
public class AppRunner {
	/**
	 * use this to start spring boot application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AppRunner.class, args);
	}
}

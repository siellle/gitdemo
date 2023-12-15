package com.sfac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description WishAccountApplication
 * @Author JiangHu
 * @Date 2023/7/9 15:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WishItingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WishItingApplication.class, args);
	}
}

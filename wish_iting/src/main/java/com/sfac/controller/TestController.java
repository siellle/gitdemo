package com.sfac.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TestController
 * @Author JiangHu
 * @Date 2023/7/10 9:23
 */
@RestController
@RequestMapping(value = "/api/iting")
public class TestController {

	@RequestMapping(value = "/hw")
	public String helloWorld(){
		return "iting hello world.";
	}
}

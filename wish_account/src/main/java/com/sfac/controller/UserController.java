package com.sfac.controller;

import com.github.pagehelper.PageInfo;
import com.sfac.account.User;
import com.sfac.common.vo.Result;
import com.sfac.common.vo.Search;
import com.sfac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Description UserController
 * @Author JiangHu
 * @Date 2023/7/10 11:38
 */
@RestController
@RequestMapping(value = "/api/account")
public class UserController {

	@Autowired
	private UserService modelService;

	/**
	 * 127.0.0.1/api/account/user ---- post
	 */
	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<User> insertModel(@RequestBody User model) {
		return modelService.insertModel(model);
	}

	/**
	 * 127.0.0.1/api/account/user ---- put
	 */
	@PutMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<User> updateModel(@RequestBody User model) {
		return modelService.updateModel(model);
	}

	/**
	 * 127.0.0.1/api/account/user/1 ---- delete
	 */
	@DeleteMapping(value = "/user/{id}")
	public Result<Object> deleteModelById(@PathVariable int id) {
		return modelService.deleteModelById(id);
	}

	/**
	 * 127.0.0.1/api/account/user/1 ---- get
	 */
	@GetMapping(value = "/user/{id}")
	public User getModelById(@PathVariable int id) {
		return modelService.getModelById(id);
	}

	/**
	 * 127.0.0.1/api/account/users ---- post
	 */
	@PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
	public PageInfo<User> getModelsBySearch(@RequestBody Search search) {
		return modelService.getModelsBySearch(search);
	}

	/**
	 * 127.0.0.1/api/account/login ---- post
	 */
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<User> login(@RequestBody User model) {
		return modelService.login(model);
	}
}

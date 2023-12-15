package com.sfac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.account.User;
import com.sfac.common.vo.Result;
import com.sfac.common.vo.Search;
import com.sfac.dao.UserDao;
import com.sfac.service.UserService;
import com.sfac.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

/**
 * @Description UserServiceImpl
 * @Author JiangHu
 * @Date 2023/7/10 11:26
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao modelDao;

	@Override
	@Transactional
	public Result<User> insertModel(User model) {
		User temp = modelDao.getUserByUserName(model.getUserName());
		if (temp != null) {
			return Result.faild("用户名已经存在。");
		}

		model.setCreateDate(LocalDateTime.now());
		model.setUpdateDate(LocalDateTime.now());
		model.setPassword(MD5Util.getMD5(model.getPassword()));
		modelDao.insert(model);

		return Result.ok(model);
	}

	@Override
	@Transactional
	public Result<User> updateModel(User model) {
		User temp = modelDao.getUserByUserName(model.getUserName());
		if (temp != null && temp.getId() != model.getId()) {
			return Result.faild("用户名已经存在。");
		}

		model.setUpdateDate(LocalDateTime.now());
		// TODO 修改密码单独接口
		model.setPassword(MD5Util.getMD5(model.getPassword()));
		modelDao.updateById(model);

		return Result.ok(model);
	}

	@Override
	@Transactional
	public Result<Object> deleteModelById(int id) {
		modelDao.deleteById(id);
		return Result.ok();
	}

	@Override
	public User getModelById(int id) {
		return modelDao.selectById(id);
	}

	@Override
	public PageInfo<User> getModelsBySearch(Search search) {
		search.init();
		PageHelper.startPage(search.getCurrentPage(), search.getPageSize());
		return new PageInfo(Optional
				.ofNullable(modelDao.getUsersBySearch(search))
				.orElse(Collections.emptyList()));
	}

	@Override
	public Result<User> login(User model) {
		User user = modelDao.getUserByUserNameAndPassword(
				model.getUserName(), MD5Util.getMD5(model.getPassword()));
		if (user == null) {
			return Result.faild("用户名或密码错误。");
		} else  {
			return Result.ok(user);
		}
	}
}

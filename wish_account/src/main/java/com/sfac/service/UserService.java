package com.sfac.service;

import com.sfac.account.User;
import com.sfac.common.vo.Result;

/**
 * UserService
 */
public interface UserService extends ModelService<User> {

	Result<User> login(User model);
}

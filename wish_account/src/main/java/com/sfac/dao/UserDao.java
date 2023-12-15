package com.sfac.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sfac.account.User;
import com.sfac.common.vo.Search;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserDao
 */
@Mapper
@Repository
public interface UserDao extends BaseMapper<User> {

	@Select("<script>"
			+ "select * from account_user "
			+ "<where> "
			+ "<if test='keyword != \"\" and keyword != null'>"
			+ " and (user_name like '%${keyword}%') "
			+ "</if>"
			+ "</where>"
			+ "<choose>"
			+ "<when test='sort != \"\" and sort != null'>"
			+ " order by ${sort} ${direction}"
			+ "</when>"
			+ "<otherwise>"
			+ " order by id desc"
			+ "</otherwise>"
			+ "</choose>"
			+ "</script>")
	List<User> getUsersBySearch(Search search);

	@Select("select * from account_user where user_name = #{userName} limit 1")
	User getUserByUserName(String userName);

	@Select("select * from account_user where user_name=#{userName} and password=#{password} limit 1")
	User getUserByUserNameAndPassword(
			@Param("userName") String userName,
			@Param("password") String password);
}

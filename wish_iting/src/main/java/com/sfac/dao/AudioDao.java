package com.sfac.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sfac.common.vo.Search;
import com.sfac.iting.Audio;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AudioDao
 */
@Mapper
@Repository
public interface AudioDao extends BaseMapper<Audio> {

	@Select("<script>"
			+ "select * from iting_audio "
			+ "<where> "
			+ "<if test='keyword != \"\" and keyword != null'>"
			+ " and (name like '%${keyword}%' or singer like '%${keyword}%' "
			+ " or lyric like '%${keyword}%') "
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
	List<Audio> getAudiosBySearch(Search search);

	@Select("select * from iting_audio where name=#{name} and singer=#{singer}")
	Audio getAudioByNameAndSinger(@Param("name") String name, @Param("singer") String singer);
}

package com.sfac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.common.vo.Result;
import com.sfac.common.vo.Search;
import com.sfac.dao.AudioDao;
import com.sfac.iting.Audio;
import com.sfac.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

/**
 * @Description AudioServiceImpl
 * @Author JiangHu
 * @Date 2023/7/10 14:09
 */
@Service
public class AudioServiceImpl implements AudioService {

	@Autowired
	private AudioDao modelDao;

	@Override
	@Transactional
	public Result<Audio> insertModel(Audio model) {
		Audio temp = modelDao.getAudioByNameAndSinger(model.getName(), model.getSinger());
		if (temp != null) {
			return Result.faild("该音频已经存在。");
		}

		model.setCreateDate(LocalDateTime.now());
		model.setUpdateDate(LocalDateTime.now());
		modelDao.insert(model);

		return Result.ok(model);
	}

	@Override
	@Transactional
	public Result<Audio> updateModel(Audio model) {
		Audio temp = modelDao.getAudioByNameAndSinger(model.getName(), model.getSinger());
		if (temp != null && temp.getId() != model.getId()) {
			return Result.faild("该音频已经存在。");
		}

		model.setUpdateDate(LocalDateTime.now());
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
	public Audio getModelById(int id) {
		return modelDao.selectById(id);
	}

	@Override
	public PageInfo<Audio> getModelsBySearch(Search search) {
		search.init();
		PageHelper.startPage(search.getCurrentPage(), search.getPageSize());
		return new PageInfo<>(Optional
				.ofNullable(modelDao.getAudiosBySearch(search))
				.orElse(Collections.emptyList()));
	}
}

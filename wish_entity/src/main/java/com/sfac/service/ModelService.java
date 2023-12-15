package com.sfac.service;

import com.github.pagehelper.PageInfo;
import com.sfac.common.vo.Result;
import com.sfac.common.vo.Search;

/**
 * ModelService
 * @param <T>
 */
public interface ModelService<T> {

	Result<T> insertModel(T model);

	Result<T> updateModel(T model);

	Result<Object> deleteModelById(int id);

	T getModelById(int id);

	PageInfo<T> getModelsBySearch(Search search);
}

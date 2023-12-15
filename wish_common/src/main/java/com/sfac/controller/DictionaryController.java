package com.sfac.controller;

import com.sfac.common.vo.ImageType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description DictionaryController,字典类接口，返回枚举对象列表
 * @Author JiangHu
 * @Date 2023/7/10 14:37
 */
@RestController
@RequestMapping(value = "/api/common")
public class DictionaryController {
	public static Map<String, Class> map = new HashMap<>() {{
		put("imageTypes", ImageType.class);
	}};

	/**
	 * 127.0.0.1/api/common/dictionary/imageTypes ---- get
	 */
	@GetMapping(value = "/dictionary/{key}")
	public List<Object> getDictionaries(@PathVariable String key) {
		Class clazz = map.get(key);
		try {
			if (clazz != null) {
				Method method = clazz.getDeclaredMethod("values");
				Object[] result = (Object[]) method.invoke(null);
				return Arrays.asList(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}

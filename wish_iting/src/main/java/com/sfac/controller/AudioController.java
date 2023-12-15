package com.sfac.controller;

import com.github.pagehelper.PageInfo;
import com.sfac.common.vo.Result;
import com.sfac.common.vo.Search;
import com.sfac.iting.Audio;
import com.sfac.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Description AudioController
 * @Author JiangHu
 * @Date 2023/7/10 14:15
 */
@RestController
@RequestMapping("/api/iting")
public class AudioController {

	@Autowired
	private AudioService modelService;

	/**
	 * 127.0.0.1/api/iting/audio ---- post
	 */
	@PostMapping(value = "/audio", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<Audio> insertModel(@RequestBody Audio model) {
		return modelService.insertModel(model);
	}

	/**
	 * 127.0.0.1/api/iting/audio ---- put
	 */
	@PutMapping(value = "/audio", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<Audio> updateModel(@RequestBody Audio model) {
		return modelService.updateModel(model);
	}

	/**
	 * 127.0.0.1/api/iting/audio/1 ---- delete
	 */
	@DeleteMapping(value="/audio/{id}")
	public Result<Object> deleteModelById(@PathVariable int id) {
		return modelService.deleteModelById(id);
	}

	/**
	 * 127.0.0.1/api/iting/audio/1 ---- get
	 */
	@GetMapping(value = "/audio/{id}")
	public Audio getModelById(@PathVariable int id) {
		return modelService.getModelById(id);
	}

	/**
	 * 127.0.0.1/api/iting/audios ---- post
	 */
	@PostMapping(value="/audios", consumes = MediaType.APPLICATION_JSON_VALUE)
	public PageInfo<Audio> getModelsBySearch(@RequestBody Search search) {
		return modelService.getModelsBySearch(search);
	}
}

package com.sfac.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ImageType
 */
@JsonFormat(shape= JsonFormat.Shape.OBJECT)
public enum ImageType {
	PROFILE_BIG("profileBig", 500, 500, 2048),
	PROFILE_SMALL("profileSmall", 50, 50, 200),
	;
	public String name;
	public int width;
	public int heigh;
	public int size;

	ImageType(String name, int width, int heigh, int size) {
		this.name = name;
		this.width = width;
		this.heigh = heigh;
		this.size = size;
	}
}

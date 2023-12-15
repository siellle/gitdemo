package com.sfac.iting;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.sfac.common.AbstractEntity;

/**
 * Description: 音频资源
 * 
 * @author JiangHu
 * @date 2023-06-01 16:03:44
 */
@Entity
@Table(name = "iting_audio")
@TableName(value = "iting_audio")
public class Audio extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private String subject; // 音频主题，专辑名、小说名等
	private String category; // 音频种类：歌曲、有声小说等
	private String style; // 风格：流行、古风等
	private String name; // 名字
	private String wording; // 作词
	private String arranger; // 作曲
	private String singer; // 歌手
	private String language; // 语言
	@Column(columnDefinition = "text")
	private String lyric; // 歌词
	private String url; // 地址：/static/audios/音频种类/音乐名称_歌手.mp3
	private String cover; // 封面：/static/images/audios/***.jpg
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private LocalDate releaseDate; // 发行日期
	private long clickNumber; // 点击次数
	private int recommendNumber; // 推荐数
	private int collectionNumber; // 收藏数
	private boolean original; // 是否原创
	private String flag; // 标识
	private int grade; // 资源分级
	private int duration; // 时长，单位秒
//	@Transient
//	@TableField(exist = false)
//	List<Comment> comments; // 评论
	
	/**
	 * Description: 音频种类
	 * @author JiangHu
	 * @date 2023-06-02 15:31:00
	 */
	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum AudioCategory {
		SONG("song", "歌曲"),
		AUDIO_BOOKS("audioBooks", "有声读物"),
		TEST("test", "测试"),
		;
		public String name;
		public String description;
		
		private AudioCategory(String name, String description) {
			this.name = name;
			this.description = description;
		}
		
		public static AudioCategory getAudioCategoryByName(String name) {
			for (AudioCategory item : AudioCategory.values()) {
				if (name.equals(item.name)) {
					return item;
				}
			}
			return null;
		}
	}
	
	/**
	 * Description: 音频风格
	 * @author JiangHu
	 * @date 2023-06-02 15:41:24
	 */
	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum AudioStyle {
		LIUXING("流行"),
		GUFENG("古风"),
		MINSU("民俗"),
		QINGYINYUE("纯音乐"),
		YAOGUN("摇滚"),
		NONE("未知"),
		;
		public String name;

		private AudioStyle(String name) {
			this.name = name;
		}
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWording() {
		return wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public String getArranger() {
		return arranger;
	}

	public void setArranger(String arranger) {
		this.arranger = arranger;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public long getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(long clickNumber) {
		this.clickNumber = clickNumber;
	}

	public boolean isOriginal() {
		return original;
	}

	public void setOriginal(boolean original) {
		this.original = original;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getRecommendNumber() {
		return recommendNumber;
	}

	public void setRecommendNumber(int recommendNumber) {
		this.recommendNumber = recommendNumber;
	}

	public int getCollectionNumber() {
		return collectionNumber;
	}

	public void setCollectionNumber(int collectionNumber) {
		this.collectionNumber = collectionNumber;
	}

}

package com.sfac.common.vo;

/**
 * @Description Result
 * @Author JiangHu
 * @Date 2023/7/10 10:30
 */
public class Result<T> {

	private int status;
	private String message;
	private T data;

	public Result() {
	}

	public Result(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public Result(int status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public static Result faild() {
		return new Result(ResultCode.FAILD.code, "Operate faild.");
	}

	public static Result faild(String message) {
		return new Result(ResultCode.FAILD.code, message);
	}

	public static Result ok() {
		return new Result(ResultCode.SUCCESS.code, "Operate success.");
	}

	public static <T> Result ok(T data) {
		return new Result(ResultCode.SUCCESS.code, "Operate success.", data);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public enum ResultCode {
		SUCCESS(200, "sucess"),
		FAILD(500, "faild"),
		;
		public int code;
		public String name;

		ResultCode(int code, String name) {
			this.code = code;
			this.name = name;
		}
	}
}

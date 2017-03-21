package cn.edu.xiyou.json;

public enum CodeEnum {

	SUCCESS(0, "成功"),//成功
	
	SERVERERROR(10, "服务器异常"),//服务器异常
	
	PASSWORDERROR(40, "密码错误"),//密码错误
	
	NULLERROR(50, "参数为空"),//参数为空
	
	FILEERROR(60, "文件上传错误"),//文件上传错误
	
	AUTHERROR(70, "验证码错误");//验证码错误
	
	private Integer code;
	
	private String message;
	
	private CodeEnum(Integer code, String message){
		this.code = code;
		this.message = message;
	}
	
	public Integer getCode(){
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}

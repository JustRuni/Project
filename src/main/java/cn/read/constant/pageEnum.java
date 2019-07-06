package cn.read.constant;

public enum pageEnum {
	Add_success(1000,"新增成功"),
	Add_fail(1001,"新增失败"),
	;
	private Integer code;
    private String msg;
    
    public static final String KEY = "pageCode";
    
    pageEnum(Integer code,String msg) {
	this.code = code;
	this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

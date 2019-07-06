package cn.read.dao;

public class SysUser {
	private Integer id;
	private String manngerName;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getManngerName() {
		return manngerName;
	}
	public void setManngerName(String manngerName) {
		this.manngerName = manngerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

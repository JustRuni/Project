package cn.read.dao;

import java.util.Date;

public class SysLog {
	private Integer id;
	private Date visitTime ;
	private String username ;
	private String ip ;
	private String url ;
	private Long executeTime ;
	private String method ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getExecuteTime() {
		return executeTime;
	}
	public void setExecuteTime(Long executeTime) {
		this.executeTime = executeTime;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
}


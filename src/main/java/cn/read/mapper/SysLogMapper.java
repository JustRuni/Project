package cn.read.mapper;

import java.util.List;

import cn.read.dao.SysLog;

public interface SysLogMapper {
	public void saveSysLog(SysLog sysLog);

	public List<SysLog> findAllhistory();
}

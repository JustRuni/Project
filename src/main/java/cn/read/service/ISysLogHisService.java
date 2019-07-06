package cn.read.service;

import java.util.List;

import cn.read.dao.SysLog;

public interface ISysLogHisService {
	public List<SysLog> findAllHistory(Integer page,Integer size);
}

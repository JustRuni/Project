package cn.read.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.read.dao.SysLog;
import cn.read.mapper.SysLogMapper;
import cn.read.service.ISysLogService;

@Service
public class SysLogService implements ISysLogService {
	
	@Autowired
	private SysLogMapper sysLogMapper;
	
	public void save(SysLog sysLog) {
		sysLogMapper.saveSysLog(sysLog);
	}

}

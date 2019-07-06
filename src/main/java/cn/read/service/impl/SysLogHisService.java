package cn.read.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.read.dao.SysLog;
import cn.read.mapper.SysLogMapper;
import cn.read.service.ISysLogHisService;

@Service
public class SysLogHisService implements ISysLogHisService {
	@Autowired
	private SysLogMapper sysLogMapper;
	
	public List<SysLog> findAllHistory(Integer page,Integer size) {
		PageHelper.startPage(page,size);
		List<SysLog> list = sysLogMapper.findAllhistory();
		return list;
	}

}

package cn.read.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import cn.read.dao.SysLog;
import cn.read.service.ISysLogHisService;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
	@Autowired
	private ISysLogHisService iSysLogHisService;
	
	@RequestMapping("/findAllHis")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView FindAllHis(@RequestParam(name = "page",required=true,defaultValue="1") Integer page,@RequestParam(name = "size",required=true,defaultValue="10") Integer size){
	
		List<SysLog> list = iSysLogHisService.findAllHistory(page, size);
		PageInfo pageInfo = new PageInfo(list);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("list-sysLog");
		return mv;
	}
}

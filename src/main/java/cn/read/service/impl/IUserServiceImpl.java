package cn.read.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.read.dto.UserInfo;
import cn.read.mapper.UserMapper;
import cn.read.service.IUserService;

@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {

	@Autowired
	private UserMapper usermapper;
	
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userinfo = usermapper.findByUsername(username);
		  User user = new User(userinfo.getUsername(), userinfo.getPassword(), userinfo.getStatusStr() == 0 ? false : true, true, true, true, getAuthorities(userinfo));
		//User user = new User(userinfo.getUsername(), "{noop}"+userinfo.getPassword(),getAuthorities(userinfo));
		return user;
	}
	public List<SimpleGrantedAuthority> getAuthorities(UserInfo userinfo) {
		List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
		list.add(new SimpleGrantedAuthority("ROLE_"+userinfo.getRoles()));
		return list;
	}

}

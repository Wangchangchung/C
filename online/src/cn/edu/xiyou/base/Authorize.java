package cn.edu.xiyou.base;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.edu.xiyou.sys.base.XAuthorize;

/**
 * 用户权限认证、授权
 * @author lzp
 *
 */
@Component("authorize")
public class Authorize implements XAuthorize{
	
	/**
	 * 权限设置
	 * @return
	 */
	public Map<String, String> setChainMap(){
		Map<String, String> map = new LinkedHashMap<String, String>();
		/**
		 * 示例代码：map的key为权限路径，value为权限名称
		 */
		//map.put("/person/**", "perms[\"person\"]");
		//map.put("/hello/**", "perms[\"hello\"]");
		return map;
	}
	
	
	/**
	 * 用户认证
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean doSetAuthenticationInfo(String username,String password){
		/**
		 * 系统自动返回当前登录用户的用户名和密码，在这里进行认证，如果用户名密码正确则返回true，否则返回false
		 */
		return true;
	}
	
	
	/**
	 * 用户授权
	 * @return
	 */
	public List<String> doSetAuthorizationInfo(String username){
		/**
		 * 这里进行授权，系统返回当前登录用户名，这里需要根据用户名给该用户授权，将用户的权限名称添加到list中，返回。
		 */
		List<String> list = new ArrayList<String>();
		//list.add("person");
		return list;
	}
}

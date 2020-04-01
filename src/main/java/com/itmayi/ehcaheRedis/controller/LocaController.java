/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.itmayi.ehcaheRedis.controller;

import com.itmayi.day01.entity.User;
import com.itmayi.ehcaheRedis.service.UserService;
import com.itmayi.ehcaheRedis.util.EhCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能说明: <br>
 * 创建作者:每特教育-余胜军<br>
 * 创建时间:2018年8月4日 下午4:02:00<br>
 * 教育机构:每特教育|蚂蚁课堂<br>
 * 版权说明:上海每特教育科技有限公司版权所有<br>
 * 官方网站:www.itmayiedu.com|www.meitedu.com<br>
 * 联系方式:qq644064779<br>
 * 注意:本内容有每特教育学员共同研发,请尊重原创版权
 */
@RestController
public class LocaController {

	@Autowired
	private EhCacheUtil ehCacheUtil;

	@Autowired
	private UserService userService;


	@RequestMapping("/addLoca")
	public String addLoca(String key, String value) {
		ehCacheUtil.put("userCache", key, value);
		return "success";
	}

	@RequestMapping("/getEh")
	public String getEh(String key) {
		return (String) ehCacheUtil.get("userCache", key);
	}

	/**
	 * 根据userId查询用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/getRedisUser")
	public User getUser(Integer id) {
		User user = userService.getUserById(id);
		return user;
	}
}

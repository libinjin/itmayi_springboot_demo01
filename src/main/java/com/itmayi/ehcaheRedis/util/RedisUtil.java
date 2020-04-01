/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.itmayi.ehcaheRedis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

//  springboot 2.0 整合redis
@Component
public class RedisUtil {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public void set(String key, Object object, Long time) {
		// 让该方法能够支持多种数据类型存放
		if (object instanceof String) {
			setString(key, (String) object);
		}
		// 如果存放时Set类型
		if (object instanceof Set) {
			setSet(key, object);
		}
		// 设置有效期

		if (time != null) {
			stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
		}

	}

	/**
	 * 做redis-cluster的时候没有事务
	 * @param key
	 * @param object
	 */
	public void setString(String key, String object) {
		//开启事务
		/*stringRedisTemplate.setEnableTransactionSupport(true);
		try {
			//类似于begin，开启事务
			stringRedisTemplate.multi();*/
			stringRedisTemplate.opsForValue().set(key, object);

			System.out.println("存入完毕，马上开始提交redis事务");
		/*	//事务提交
			stringRedisTemplate.exec();
		} catch (Exception e) {
			//回滚
			stringRedisTemplate.discard();
			e.printStackTrace();
		}*/
	}

	public void setSet(String key, Object object) {
		Set<String> valueSet = (Set<String>) object;
		for (String string : valueSet) {
			stringRedisTemplate.opsForSet().add(key, string);
		}
	}

	public String getString(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}



}

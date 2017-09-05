package com.topview.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.topview.domain.Product;


public class RedisConfig {
	@Bean
	public RedisConnectionFactory redisCF(){
		JedisConnectionFactory cf = new JedisConnectionFactory();
		cf.setHostName("118.89.39.138");
		//cf.setPort(6739);//redisĬ�ϵĶ˿�
		//cf.setPassword("");
		return cf;
	}
	@Bean
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory cf){
		return new StringRedisTemplate(cf);
	}
	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate){
		return new RedisCacheManager(redisTemplate);
	}
	
	/*@Bean
	public RedisTemplate<String,Product> redisTemplate(RedisConnectionFactory cf){
		RedisTemplate<String,Product> redisTemplate = new RedisTemplate<String, Product>();
		redisTemplate.setConnectionFactory(cf);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Product>(Product.class));
		return redisTemplate;
	}*/
}

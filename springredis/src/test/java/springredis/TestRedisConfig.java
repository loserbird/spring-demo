package springredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topview.config.RedisConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RedisConfig.class})
public class TestRedisConfig {
	
	@Autowired
	StringRedisTemplate redisTemplate;
	
	@Test
	public void test01(){
		redisTemplate.opsForValue().set("name", "bingqin");
	}
}

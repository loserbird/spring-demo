package springredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topview.config.ApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class KeyValueSerializersTest {

  @Autowired RedisConnectionFactory connectionFactory;

  @Test public void testStringLongSerializers() {
    RedisTemplate<String, Long> redis = new RedisTemplate<String, Long>();
    redis.setConnectionFactory( connectionFactory );
    redis.setKeySerializer( ApplicationConfig.StringSerializer.INSTANCE );
    redis.setValueSerializer( ApplicationConfig.LongSerializer.INSTANCE );
    redis.afterPropertiesSet();
    ValueOperations<String, Long> ops = redis.opsForValue();

    String key = "springredis:test";

    ops.setIfAbsent( key, 1L );
    Long l = ops.increment( key, 1 );

  }

}

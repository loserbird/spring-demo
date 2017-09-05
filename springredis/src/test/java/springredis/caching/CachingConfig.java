package springredis.caching;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import com.topview.config.ApplicationConfig;
import com.topview.config.ApplicationConfig.IntSerializer;

@Configuration
@EnableCaching
public class CachingConfig extends ApplicationConfig {

  @SuppressWarnings({"unchecked"})
  @Bean public RedisCacheManager redisCacheManager() {
    RedisTemplate<String,String> tmpl = new RedisTemplate<String,String>();
    tmpl.setConnectionFactory( redisConnectionFactory() );
    //tmpl.setKeySerializer( IntSerializer.INSTANCE );
   // tmpl.setValueSerializer( new JdkSerializationRedisSerializer() );
    tmpl.afterPropertiesSet();
    RedisCacheManager cacheMgr = new RedisCacheManager( tmpl );
    cacheMgr.setDefaultExpiration(3000);
    return cacheMgr;
  }
  
  @Bean  
  public KeyGenerator customKeyGenerator() {  
      return new KeyGenerator() {  
          @Override  
          public Object generate(Object o, Method method, Object... objects) {  
              StringBuilder sb = new StringBuilder();  
              sb.append(o.getClass().getName());  
              sb.append(method.getName());  
              for (Object obj : objects) {  
                  sb.append(obj.toString());  
              }  
              return sb.toString();  
          }  
      };  
  }  

  @Bean public CacheableTest cacheableTest() {
    return new CacheableTest();
  }

}

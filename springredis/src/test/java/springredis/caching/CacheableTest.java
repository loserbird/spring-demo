package springredis.caching;

import org.springframework.cache.annotation.Cacheable;

public class CacheableTest {
	  @Cacheable(value = "hello")
	  public String getCacheableValue() {
	    long now = System.currentTimeMillis();
	    return "Hello World (@ " + now + ")!";
	  }
}

package springredis.caching;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CachingConfig.class})
public class CachingTest {

  @Autowired CacheableTest cacheableTest;

  @Test public void testCaching() {
    String s1 = cacheableTest.getCacheableValue();
    System.out.println(s1);
    String s2 = cacheableTest.getCacheableValue();
    System.out.println(s1.equals(s2));
  }
}

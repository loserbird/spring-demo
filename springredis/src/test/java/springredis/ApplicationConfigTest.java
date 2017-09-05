package springredis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.topview.config.ApplicationConfig;

public class ApplicationConfigTest {
	 @Test public void boostrapFromJavaConfig() {
		    ApplicationContext appCtx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		  }
}

package springredis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import com.topview.config.ApplicationConfig;

@Configuration
public class PubSubConfig extends ApplicationConfig {

  public static final String DUMP_CHANNEL = "springredis-channel";

  @Bean RedisMessageListenerContainer container() {
    RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    container.setConnectionFactory(redisConnectionFactory());
    container.addMessageListener(dumpToConsoleListener(), new ChannelTopic(DUMP_CHANNEL));
    return container;
  }

  @Bean MessageListener dumpToConsoleListener() {
    return new MessageListener() {
      @Override public void onMessage(Message message, byte[] pattern) {
        System.out.println("FROM MESSAGE: " + new String(message.getBody()));
      }
    };
  }

}

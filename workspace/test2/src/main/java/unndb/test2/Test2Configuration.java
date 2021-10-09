package unndb.test2;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
@EnableCaching
public class Test2Configuration {

	@Bean
	public RedisCacheConfiguration cacheConfiguration() {
	    return RedisCacheConfiguration.defaultCacheConfig()
	      .entryTtl(Duration.ofSeconds(30))
	      .disableCachingNullValues()
	      .serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
	}
}

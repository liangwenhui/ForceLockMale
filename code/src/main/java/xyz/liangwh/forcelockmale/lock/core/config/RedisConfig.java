package xyz.liangwh.forcelockmale.lock.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisConfig {
    /**
     * database: 0
     *     host:  134.175.130.172
     *     password: lwh@13660161032
     *     port: 6379
     *     timeout: 0
     *     jedis:
     *       pool:
     *         max-active: 8
     *         max-idle: 8
     *         min-idle: 2
     *         max-wait: 3000
     */
    private String host;
    private int database;
    private int port;
    private String password;
    private int timeout;

    @Bean(name="jedisPoolConfig")
    @ConfigurationProperties(prefix = "spring.redis.jedis.pool")
    public JedisPoolConfig getJedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }
    @Bean(name = "jedisPool")
    public JedisPool getJedisPool (@Qualifier(value = "jedisPoolConfig") JedisPoolConfig config){
        JedisPool jedisPool = new JedisPool(config, host, port, timeout, password);
        return jedisPool;

    }

}

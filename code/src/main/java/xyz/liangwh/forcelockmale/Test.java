package xyz.liangwh.forcelockmale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;

@RestController
@RequestMapping("test")
public class Test {
    @Autowired
    JedisPool jedisPool;
    @RequestMapping("tjp")
    public void testJedisPool(){
        Jedis jedis = jedisPool.getResource();
        jedis.set("hello","happy");
        ArrayList keys = new ArrayList<String>();
        ArrayList args = new ArrayList();
        keys.add("hello");
        args.add("hello");
        Object o = jedis.eval("if (redis.call('exists',KEYS[1])==1) then return redis.call('del',ARGV[1]) end",keys,args);
        System.out.println(o);
    }


}

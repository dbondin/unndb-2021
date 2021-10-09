package test1;

import redis.clients.jedis.Jedis;

public class Test1 {

	public static void main(String[] args) {
		
		Jedis j = new Jedis();
		
		System.out.println(j.get("s1"));
		
		j.hmget("user:100", "name", "age").forEach(s -> System.out.println(s));
	}

}

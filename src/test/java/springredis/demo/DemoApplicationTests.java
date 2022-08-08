package springredis.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import springredis.demo.entity.Event;
import springredis.demo.repository.TimeDelayRepository;
import springredis.demo.structures.OutAPICaller;
import springredis.demo.structures.SimulateHeapKeeper;
import springredis.demo.structures.SimulateNewEvent;

import java.util.*;


@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private TimeDelayRepository timeDelayRepository;



	@Test
	void contextLoads() {

		RedisConnection redisConnection = RedisConnectionUtils.getConnection(redisTemplate.getConnectionFactory(),true);
		redisConnection.flushDb();



		SimulateNewEvent simulateNewEvent = new SimulateNewEvent(timeDelayRepository, redisTemplate);
		SimulateHeapKeeper simulateHeapKeeper = new SimulateHeapKeeper(redisTemplate);
		OutAPICaller outAPICaller = new OutAPICaller(timeDelayRepository, redisTemplate);

		new Thread(simulateNewEvent).start();
		new Thread(simulateHeapKeeper).start();
		new Thread(outAPICaller).start();
		while (true){

		}



	}

	@Test
	void testEvent(){
		Date date = new Date();
		System.out.println(date);
		date.setTime(date.getTime()+10000);
		System.out.println(date);
	}

}

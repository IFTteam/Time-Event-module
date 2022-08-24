package springredis.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import springredis.demo.repository.TimeDelayRepository;
import springredis.demo.structures.OutAPICaller;
import springredis.demo.structures.SimulateHeapKeeper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Slf4j
public class TaskCoordinator implements DisposableBean {


    private volatile boolean someCondition = true;

    private final String taskQueueKey = "CoretaskQueue";



    private ExecutorService executorService;

    // dao 和service注入
    @Autowired
    public TaskCoordinator(RedisTemplate redisTemplate, TimeDelayRepository timeDelayRepository) {
        SimulateHeapKeeper simulateHeapKeeper = new SimulateHeapKeeper(redisTemplate);

        OutAPICaller outAPICaller = new OutAPICaller(timeDelayRepository, redisTemplate);
        new Thread(simulateHeapKeeper).start();
        new Thread(outAPICaller).start();
    }



    @Override
    public void destroy() throws Exception {
        someCondition = false;
    }
}


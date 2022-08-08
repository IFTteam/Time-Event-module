package springredis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springredis.demo.entity.TimeTask;
import springredis.demo.repository.TimeDelayRepository;

import java.util.Date;
import java.util.List;

@RestController
public class TimeEventController {
    @Autowired
    private TimeDelayRepository timeDelayRepository;

    @GetMapping("/allTasks")
    public List<TimeTask> getAll(){
        return timeDelayRepository.findAll();
    }

    @PostMapping("/addNewTask")
    public TimeTask add(@RequestParam("node_id")Long nodeId,
                        @RequestParam("journey_id")Long journeyId,
                        @RequestParam("user_id")Long userId,
                        @RequestParam("audience_id")Long audienceId,
                        @RequestParam("repeat")Integer repeat,
                        @RequestParam("trigger_time") Long triggerTime,
                        @RequestParam("target_node_id")Long targetNodeId,
                        @RequestParam("repeat_interval")String repeatInterval){

        TimeTask timeTask = new TimeTask(nodeId,journeyId,userId,repeat,repeatInterval,targetNodeId,triggerTime,0,audienceId);
        return timeDelayRepository.save(timeTask);
    }

    @GetMapping("/taskbytime")
    public List<TimeTask> getTaskByTime(@RequestParam("triggerTime")Long triggerTime){
        return timeDelayRepository.findTasksBeforeTime(triggerTime);
    }

}

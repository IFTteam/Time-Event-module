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
    public TimeTask add(TimeTask timeTask){


        return timeDelayRepository.save(timeTask);
    }

    @GetMapping("/taskbytime")
    public List<TimeTask> getTaskByTime(@RequestParam("triggerTime")Long triggerTime){
        return timeDelayRepository.findTasksBeforeTime(triggerTime);
    }

}

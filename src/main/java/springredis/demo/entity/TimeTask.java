package springredis.demo.entity;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;



@Entity
@Data
public class TimeTask {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;


    @Column(name="node_id")
    private Long nodeId;
    @Column(name="journey_id")
    private Long journeyId;
    @Column(name="user_id")
    private Long userId;

    private Long audienceId;
    @Column(name="repeat_times")
    private Integer repeatTimes;
    private String repeatInterval;

    private Long targetNodeId;
    private Long triggerTime;

    private Integer task_status;
    //status of the task
    //0-in sql db, 1-in heap, 2-task complete, -1-task cancelled

    public TimeTask() {
    }

    public TimeTask(Long nodeId, Long journeyId, Long userId, Integer repeat, String repeatInterval, Long targetNodeId, Long triggerTime, Integer task_status, Long audienceId) {
        this.nodeId = nodeId;
        this.journeyId = journeyId;
        this.userId = userId;
        this.repeatTimes = repeat;
        this.repeatInterval = repeatInterval;
        this.targetNodeId = targetNodeId;
        this.triggerTime = triggerTime;
        this.task_status = task_status;
        this.audienceId = audienceId;
    }

}

package springredis.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;



@Entity
@Data

public class TimeTask extends BaseTaskEntity {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;


    private Integer repeatTimes;
    private String repeatInterval;

    private Long triggerTime;

    private Integer taskStatus;


    //status of the task
    //0-in sql db, 1-in heap, 2-task complete, -1-task cancelled
}

package springredis.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Node extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;

    private Integer headOrTail;
    private String status;

    private List<Long> nexts;
    private List<Long> lasts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getHeadOrTail() {
        return headOrTail;
    }

    public void setHeadOrTail(Integer headOrTail) {
        this.headOrTail = headOrTail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Long> getNexts() {
        return nexts;
    }

    public void setNexts(List<Long> nexts) {
        this.nexts = nexts;
    }

    public List<Long> getLasts() {
        return lasts;
    }

    public void setLasts(List<Long> lasts) {
        this.lasts = lasts;
    }

    public Node() {
        super();
    }

    public Node(String name, String type, String status, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
        super(createdAt, createdBy,updatedAt,updatedBy);
        this.name = name;
        this.type = type;
        this.status = status;
    }
}

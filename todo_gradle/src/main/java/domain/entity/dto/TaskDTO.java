package domain.entity.dto;

import domain.entity.Task;
import java.util.Date;
import java.util.UUID;

public class TaskDTO {
    private UUID id;
    private String name;
    private String description;
    private Date deadline = new Date();
    private boolean isDone = false;

    public TaskDTO(Task task){
        this.id = task.getId();
        this.description = task.getDescription();
        this.name = task.getName();
        this.deadline = task.getDeadline();
    }
}

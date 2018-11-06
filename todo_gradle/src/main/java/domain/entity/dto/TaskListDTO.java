package domain.entity.dto;

import domain.entity.TaskList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskListDTO {

    private UUID id;
    private String name;
    private List<TaskDTO> tasks = new ArrayList<TaskDTO>();

    public TaskListDTO(TaskList tasklist){
        this.id = tasklist.getId();
        this.name = tasklist.getName();
        tasklist.getTasks().forEach((e)->this.tasks.add(new TaskDTO(e)));
    }
}

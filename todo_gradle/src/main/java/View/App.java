package View;

import domain.db.MainDB;
import domain.db.models.TaskListModel;
import domain.db.models.TaskModel;
import domain.entity.Task;
import domain.entity.TaskList;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import domain.entity.dto.TaskDTO;
import sequelize.model.SequelizeResult;
import sequelize.statement.Operation;
import sequelize.statement.Statement;
import ui.listeners.Listener;

public class App implements Listener {
    private MainDB state = new MainDB();

    public void init(){
        state.addListener(this);
        this.mockState()
                .thenAccept((Boolean is)->getSomeData());
    }

    private CompletableFuture<Boolean> mockState(){
        return TaskListModel.create(new TaskList("TaskList"))
                .thenApply((Integer listId) -> {
//                    Task task1 = new Task("name1","description1","22-12-2000");
//                    Task task2 = new Task("name1","description2","22-12-2010");
//                    TaskModel.addToList(task1, listId);
//                    TaskModel.addToList(task2, listId);
//                    TaskModel.addToList(new Task("name3","description2","22-12-2020"), listId);
//
//                    TaskListModel.getTasks(listId)
//                            .thenAccept(System.out::print);
//                    TaskListModel.findTasksBetween(
//                            listId,
//                            task1.getDeadline(),
//                            task2.getDeadline()
//                    ).thenAccept(System.out::print);
//
//                    return true;

                    TaskModel.create(new Task("name","description","22-10-2022"));
                    return true;
                });


    }

    private void getSomeData(){
        TaskModel.findOne(
                new Statement()
                    .where("name", Operation.eq, "name")
                    .and()
                    .where("description", Operation.eq, "description")
        ).thenAccept(System.out::println);


    }


    public void update(){
        System.out.println("Updated!");
    }
}

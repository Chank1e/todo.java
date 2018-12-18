package domain.db.models;

import domain.Main;
import domain.db.MainDB;
import domain.entity.dto.TaskDTO;
import sequelize.DataTypes;
import sequelize.Sequelize;
import sequelize.model.Schema;
import sequelize.model.Model;
import sequelize.model.SchemaValues;

import domain.entity.Task;
import sequelize.model.SequelizeResult;
import sequelize.statement.Operation;
import sequelize.statement.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class TaskModel implements  _Model{
    private static String name = "Task";

    private static Schema schema = new Schema()
                        .withCreatedAt()
                        .withUpdatedAt()
                        .insert("name", DataTypes.TEXT)
                        .insert("description", DataTypes.TEXT)
                        .insert("deadline", DataTypes.TIMESTAMP);

    public static CompletableFuture<Integer> create(Task task) {
        Model model = MainDB.getModel(name);

        return model.create(
                new SchemaValues()
                        .insert("name", task.getName())
                        .insert("description", task.getDescription())
                        .insert("deadline", task.getDeadline())
        ).thenApply((SequelizeResult res) -> (Integer) res.getData().get(0).get("id"));


    }

    public static CompletableFuture<TaskDTO> addToList(Task task, Integer listId) {
        Model model = MainDB.getModel(name);

        return model.create(
                new SchemaValues()
                        .insert("name", task.getName())
                        .insert("description", task.getDescription())
                        .insert("deadline", task.getDeadline())
                        .insert("list_id", listId)
        ).thenApply((SequelizeResult result) -> {
            Map<String, Object> row = result.getData().get(0);
            Task tmpTask = new Task((String)row.get("name"), (String)row.get("description"), (String)row.get("deadline"));
            return new TaskDTO(tmpTask);
        });
    }


    public static void update(Integer id, Task task) {
        Model model = MainDB.getModel(name);

        model.update(
                new SchemaValues()
                    .insert("name", task.getName())
                    .insert("description", task.getDescription())
                    .insert("deadline", task.getDeadline()),
                new Statement()
                    .where("id", Operation.eq, id)
        );
    }

    public static void delete(Integer id) {
        Model model = MainDB.getModel(name);

        model.delete(
                new Statement()
                    .where("id", Operation.eq, id)
        );
    }

    public static CompletableFuture<List<TaskDTO>> findAll(Statement statement){
        return MainDB.getModel(name).findAll(statement)
                .thenApply((SequelizeResult result) -> {
                    System.out.println(result.getData());
                    List<TaskDTO> res = new ArrayList<>();
                    result.getData().forEach((Map<String, Object> row)->{
                        Task tmpTask = new Task(
                                (String)row.get("name"),
                                (String)row.get("description"),
                                (String)row.get("deadline"));
                        TaskDTO tmpRes = new TaskDTO(tmpTask);
                        res.add(tmpRes);
                    });
                    return res;
                });
    }
    public static CompletableFuture<TaskDTO> findOne(Statement statement){
        return MainDB.getModel(name).findOne(statement)
                .thenApply((SequelizeResult result) -> {
                    Map<String, Object> row = result.getData().get(0);
                    Task tmpTask = new Task(
                            (String)row.get("name"),
                            (String)row.get("description"),
                            (String)row.get("deadline"));
                    TaskDTO res = new TaskDTO(tmpTask);
                    return res;
                });
    }

    public String getName() {
        return name;
    }

    @Override
    public Model defineModel(Sequelize seq) {
        return seq.define(name, schema);
    }
}

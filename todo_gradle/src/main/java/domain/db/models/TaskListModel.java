package domain.db.models;

import domain.db.MainDB;
import domain.entity.Task;
import domain.entity.TaskList;
import domain.entity.dto.TaskDTO;
import sequelize.DataTypes;
import sequelize.Sequelize;
import sequelize.model.Model;
import sequelize.model.Schema;
import sequelize.model.SchemaValues;
import sequelize.model.SequelizeResult;
import sequelize.statement.Operation;
import sequelize.statement.Statement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class TaskListModel implements _Model {
    private static String name = "TaskList";
    private static Schema schema = new Schema()
                                        .withCreatedAt()
                                        .withUpdatedAt()
                                        .insert("name", DataTypes.TEXT);

    public static CompletableFuture<Integer> create(TaskList tasklist) {
        Model model = MainDB.getModel(name);

        return model.create(
                new SchemaValues()
                        .insert("name", tasklist.getName())
        ).thenApply((SequelizeResult res) -> (Integer) res.getData().get(0).get("id"));
    }


    public static void update(Integer id, TaskList tasklist) {
        Model model = MainDB.getModel(name);

        model.update(
                new SchemaValues()
                        .insert("name", tasklist.getName()),
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

    public static CompletableFuture<SequelizeResult> findAll(Statement statement){
        return MainDB.getModel(name).findAll(statement);
    }
    public static CompletableFuture<SequelizeResult> findOne(Statement statement){
        return MainDB.getModel(name).findOne(statement);
    }

    public static CompletableFuture<List<TaskDTO>> findTasksBetween(Integer listId, Date dateFrom, Date dateTo) {
        return TaskModel.findAll(
                new Statement()
                    .where("list_id", Operation.eq, listId)
                    .and()
                    .where("deadline", Operation.gt, dateFrom)
                    .and()
                    .where("deadline", Operation.lt, dateTo)
        );
    }

    public static CompletableFuture<List<TaskDTO>> getTasks(Integer listId) {
        return TaskModel.findAll(
                new Statement()
                    .where("list_id", Operation.eq, listId)
        );
    }

    @Override
    public Model defineModel(Sequelize seq) {
        return seq.define(name, schema);
    }

    @Override
    public String getName() {
        return name;
    }
}

package domain.db.models;

import sequelize.Sequelize;
import sequelize.model.Model;

interface  _Model {

    Model defineModel(Sequelize seq);

    String getName();

}

import View.App;
import domain.db.MainDB;

import java.text.ParseException;
public class Main {
    public static void main(String[] args) throws ParseException {
        MainDB.init();
        App app = new App();

        app.init();

    }
}

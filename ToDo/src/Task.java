import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Locale;

public class Task {
    private String _hash;
    private String name;
    private String description;
    private Date deadline = new Date();
    private boolean isDone = false;

    private static String _defaultDateFormat = "dd-MM-yyyy";

    Task(String name, String description){
        this.name = name;
        this.description = description;
        this.generateHashForTask();
    }

    Task(){
        this.name = "";
        this.description = "";
        this.generateHashForTask();
    }
    private void generateHashForTask(){
        _hash = Long.toHexString(Double.doubleToLongBits(Math.random()));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDeadline(String deadline) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(_defaultDateFormat, Locale.getDefault());
        Date parsedDeadline = sdf.parse(deadline);
        this.deadline = parsedDeadline;
    }

    public Date getDeadline() {
        return deadline;
    }

    public boolean isEqualTo(Task anotherTask){
        return this._hash == anotherTask._hash;
    }
}

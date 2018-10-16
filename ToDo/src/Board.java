import java.util.ArrayList;

public class Board {
    private String name;
    private ArrayList<List> lists = new ArrayList<List>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void connectList(List list){
        lists.add(list);
    }
}

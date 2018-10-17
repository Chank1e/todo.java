[![Build Status](https://travis-ci.org/Chank1e/todo.java.svg?branch=master)](https://travis-ci.org/Chank1e/todo.java)

### Todo app - Java

---

#### *Pashkevich Alexandr M3204*

1. Packages:

- **Instances** - "Модели" данных и методы доступа к ним.
- **Model** - Класс для хранения данных. Грубо говоря - БД. Также дает доступ к изменению данных через. Например:
```java
import Model.TaskState;
import java.util.HashMap;
import java.util.Map;

class App {
    private TaskState state = new TaskState();
    
    public void init(){
        Map<String, Object> tmp = new HashMap<>();
        tmp.put("hello", "world");
        state.setState(tmp);
    }
}

```
После этого `state` будет(если представлять в виде JSON):
```json
{
    "hello":"world"
}
```
- **View** - Классы для инициализации интерфейса.





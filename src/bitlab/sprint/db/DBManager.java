package bitlab.sprint.db;

import java.util.ArrayList;
import java.util.Objects;

public class DBManager {
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static long id = 6L;

    static {
        tasks.add(new Task(1L,
                "Создать веб приложение на Джава ЕЕ",
                "Создать веб приложение на Джава ЕЕ",
                "23.10.2023", true));
        tasks.add(new Task(2L,
                "Clean Room",
                "Создать веб приложение на Джава ЕЕ",
                "24.10.2023", true));
        tasks.add(new Task(3L,
                "Do home tasks",
                "Создать веб приложение на Джава ЕЕ",
                "25.10.2023", true));
        tasks.add(new Task(4L,
                "Go To JYYYYYM!",
                "Создать веб приложение на Джава ЕЕ",
                "26.10.2023", false));
        tasks.add(new Task(5L,
                "Italiano learning si",
                "Создать веб приложение на Джава ЕЕ",
                "27.10.2023", false));

    }

    public static ArrayList<Task> getAllTasks(){
        return tasks;
    }

    public static void addTask(Task task){
        task.setId(id);
        tasks.add(task);
        id++;
    }

    public static Task getTask(Long id){
        return tasks.stream()
                .filter(task -> Objects.equals(task.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public static void updateTask(Task updatedTask){
        for (int i = 0; i < tasks.size(); i++) {
            if(Objects.equals(tasks.get(i).getId(), updatedTask.getId())){
                tasks.set(i, updatedTask);
                break;
            }
        }
    }

    public static void deleteTask(long id){
        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getId() == id) {
                tasks.remove((int)id);
                System.out.println("Success");
                break;
            }
        }
    }
}

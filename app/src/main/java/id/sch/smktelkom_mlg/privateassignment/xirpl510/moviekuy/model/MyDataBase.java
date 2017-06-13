package id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy.model;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy.database.Task;


public interface MyDataBase {


    void addTask(Task task);

    ArrayList<Task> getAllTasks(String status);

    int editTask(Task task);

    void deleteTask(Task task);

    void deleteAll();

    void delAllInStatus(String status);


}

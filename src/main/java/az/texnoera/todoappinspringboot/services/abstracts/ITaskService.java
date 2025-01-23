package az.texnoera.todoappinspringboot.services.abstracts;

import az.texnoera.todoappinspringboot.model.requests.RequestTask;
import az.texnoera.todoappinspringboot.model.requests.UpdateTaskRequest;
import az.texnoera.todoappinspringboot.model.response.ResponseTask;

import java.util.List;

public interface ITaskService {
    List<ResponseTask> getTasks(Integer userId);
    ResponseTask getTask(Integer id);
    ResponseTask addTask(RequestTask newTask);
    ResponseTask updateTask(int id, UpdateTaskRequest newTask);
    void deleteTask(int id);

}

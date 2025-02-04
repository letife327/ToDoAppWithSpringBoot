package az.texnoera.todoappinspringboot.services.abstracts;

import az.texnoera.todoappinspringboot.model.requests.RequestTask;
import az.texnoera.todoappinspringboot.model.requests.UpdateTaskRequest;
import az.texnoera.todoappinspringboot.model.response.ResponseTask;
import az.texnoera.todoappinspringboot.util.Result;

public interface ITaskService {
    Result<ResponseTask> getTasks(Integer userId, Integer page, Integer size);
    ResponseTask getTask(Integer id);
    void addTask(RequestTask newTask);
    ResponseTask updateTask(int id, UpdateTaskRequest newTask);
    void deleteTask(int id);

}

package TaskBarchynaiIakubova.demo;

import TaskBarchynaiIakubova.demo.models.Task;
import TaskBarchynaiIakubova.demo.requests.TaskRequest;
import TaskBarchynaiIakubova.demo.responces.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Response save(TaskRequest taskRequest) {

        Task task = Task.builder()
                .title(taskRequest.title())
                .description(taskRequest.description())
                .completed(taskRequest.completed())
                .build();

        taskRepository.save(task);

        return new Response("Task successfully saved");

    }

    public Response deleteByTaskId(Long taskId) {


    }
}

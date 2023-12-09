package TaskBarchynaiIakubova.demo.api;

import TaskBarchynaiIakubova.demo.TaskService;
import TaskBarchynaiIakubova.demo.models.Task;
import TaskBarchynaiIakubova.demo.requests.TaskRequest;
import TaskBarchynaiIakubova.demo.responces.Response;
import TaskBarchynaiIakubova.demo.responces.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
@CrossOrigin(origins = "*", originPatterns = "*", maxAge = 5000, exposedHeaders = "Access-Control-Allow-Origin", allowedHeaders = "*")
@Tag(name = "Task API", description = "Task endpoints")
public class TaskApi {

    private TaskService taskService;

    @PostMapping
    Response save(@RequestBody TaskRequest taskRequest) {

        return taskService.save(taskRequest);
    }

    @DeleteMapping("/{taskId}")
    Response delete(@PathVariable Long taskId) {

        return taskService.deleteByTaskId(taskId);
    }

    @PutMapping("/{taskId}")
    Response update(@PathVariable Long taskId,
                    @RequestBody TaskRequest taskRequest) {

        return taskService.update(taskId, taskRequest);
    }

    @GetMapping("/{taskId}")
    TaskResponse findById(@PathVariable Long taskId) {

        return taskService.findById(taskId);
    }

    @GetMapping
    List<TaskResponse> findAll(@PathVariable Long userId) {

        return taskService.findAllByUser(userId);
    }

}

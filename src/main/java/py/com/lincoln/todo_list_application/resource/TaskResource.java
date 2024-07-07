package py.com.lincoln.todo_list_application.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.lincoln.todo_list_application.domain.Task;
import py.com.lincoln.todo_list_application.dto.TaskResponseDto;
import py.com.lincoln.todo_list_application.dto.TaskUpdateDto;
import py.com.lincoln.todo_list_application.service.TaskService;

import java.net.URI;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskResource {
    public final TaskService taskService;


    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.created(URI.create("/tasks/taskID")).body(taskService.createTask(task));
    }

    @GetMapping
    public ResponseEntity<Page<TaskResponseDto>> getAllTasks(@RequestParam(value = "page", defaultValue = "0") int page,
                                                             @RequestParam(value = "size", defaultValue = "10") int size){
        return ResponseEntity.ok().body(taskService.getAllTask(page, size));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable(value = "id") String id, @RequestBody TaskUpdateDto taskUpdateDto) {
        return ResponseEntity.ok().body(taskService.updateTask(id, taskUpdateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable(value = "id") String id){
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }


}

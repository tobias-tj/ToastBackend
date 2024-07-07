package py.com.lincoln.todo_list_application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import py.com.lincoln.todo_list_application.domain.Task;
import py.com.lincoln.todo_list_application.domain.User;
import py.com.lincoln.todo_list_application.dto.TaskResponseDto;
import py.com.lincoln.todo_list_application.dto.TaskUpdateDto;
import py.com.lincoln.todo_list_application.repository.TaskRepository;
import py.com.lincoln.todo_list_application.repository.UserRepository;

import java.util.Optional;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public Page<TaskResponseDto> getAllTask(int page, int size){
        Page<Task> tasks = taskRepository.findAll(PageRequest.of(page, size, Sort.by("taskTitle")));
        return tasks.map(this::convertToTaskResponseDto);
    }



    public Task getTask(String id){
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task Not Found!"));
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public String updateTask(String id, TaskUpdateDto taskUpdateDto){
        System.out.println("Modified Task");
        Task task = getTask(id);
        updateTaskFields(task, taskUpdateDto);
        taskRepository.save(task);
        return "Task with ID " + id + " updated successfully";
    }

    public void deleteTaskById(String id){
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(taskOptional.isPresent()){
            Task taskToDelete = taskOptional.get();
            taskRepository.delete(taskToDelete);
        } else {
            throw new RuntimeException("No se encontró la tarea con ID: " + id);
        }
    }

    private void updateTaskFields(Task task, TaskUpdateDto taskUpdateDto) {
        if (taskUpdateDto.getTaskTitle() != null) {
            task.setTaskTitle(taskUpdateDto.getTaskTitle());
        }
        if (taskUpdateDto.getTaskDescription() != null) {
            task.setTaskDescription(taskUpdateDto.getTaskDescription());
        }
        if (taskUpdateDto.getTaskPriority() != null) {
            task.setTaskPriority(taskUpdateDto.getTaskPriority());
        }
        if (taskUpdateDto.getInitialDateTask() != null) {
            task.setInitialDateTask(taskUpdateDto.getInitialDateTask());
        }
        if (taskUpdateDto.getCompletedDateTask() != null) {
            task.setCompletedDateTask(taskUpdateDto.getCompletedDateTask());
        }
        if (taskUpdateDto.getUserId() != null) {
            User user = userRepository.findById(taskUpdateDto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            task.setUser(user);
        }
    }

    private TaskResponseDto convertToTaskResponseDto(Task task) {
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setId(task.getId());
        taskResponseDto.setTaskTitle(task.getTaskTitle());
        taskResponseDto.setTaskDescription(task.getTaskDescription());
        taskResponseDto.setTaskPriority(task.getTaskPriority());
        taskResponseDto.setInitialDateTask(task.getInitialDateTask());
        taskResponseDto.setCompletedDateTask(task.getCompletedDateTask());

        if (task.getUser() != null) {
            taskResponseDto.setUserId(task.getUser().getId());
            taskResponseDto.setUserName(task.getUser().getName());
        }

        return taskResponseDto;
    }

}

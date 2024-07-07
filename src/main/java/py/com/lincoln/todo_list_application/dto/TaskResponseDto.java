package py.com.lincoln.todo_list_application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDto {
    private String id;
    private String taskTitle;
    private String taskDescription;
    private String taskPriority;
    private Date initialDateTask;
    private Date completedDateTask;
    private String userId;
    private String userName;
}

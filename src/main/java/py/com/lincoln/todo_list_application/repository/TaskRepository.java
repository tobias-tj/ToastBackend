package py.com.lincoln.todo_list_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.com.lincoln.todo_list_application.domain.Task;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    Optional<Task> findById(String id);
}

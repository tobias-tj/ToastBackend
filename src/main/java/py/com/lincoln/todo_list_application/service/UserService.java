package py.com.lincoln.todo_list_application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import py.com.lincoln.todo_list_application.domain.User;
import py.com.lincoln.todo_list_application.repository.UserRepository;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;

    public Page<User> getAllUsers(int page, int size){
        return userRepo.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    public User getUser(String id){
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User Not Found!"));
    }

    public User createUser(User user){
        return userRepo.save(user);
    }

    public String updateEmail(String id, String email){
        System.out.println("Modified Email");
        User user = getUser(id);
        user.setEmail(email);
        userRepo.save(user);
        return email;
    }


}

package com.example.tasks.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/users")
public class TaskController {
    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {

        this.taskService = taskService;
    }

    @GetMapping("/")
    public String redirectToHomePage() {
        return "crud"; // Sin la extensión .html
    }

    @GetMapping
    public List<TaskApplication> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<String> createTasks(@RequestBody TaskApplication user) {
        taskService.createTasks(user);
        return ResponseEntity.ok("Producto registrado");
    }
    @PutMapping
    public ResponseEntity<Object> updateTasks(@RequestBody TaskApplication user) {
        return taskService.createTasks(user);
    }
    @DeleteMapping(path = "{userId}")
    public ResponseEntity<Object> deleteTasks(@PathVariable("userId") Long userId) {
        return taskService.deleteTasks(userId);
    }
}

package com.example.tasks.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private TaskApplication user;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskApplication> getAllTasks() {
        return this.taskRepository.findAll();
    }

    public ResponseEntity<Object> createTasks(Task user) {
        Optional<TaskApplication> existingUser = taskRepository.findUserAplicationByName(user.getName());
        HashMap<String, Object> datos = new HashMap<>();

        if (existingUser.isPresent()) {
            datos.put("data", false);
            datos.put("message", "La Tarea ya existe");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        } else {
            TaskApplication savedUser = taskRepository.save(user);
            datos.put("data", savedUser);
            datos.put("message", "Tarea creado");

            return new ResponseEntity<>(datos, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> updateTasks() {
        Optional<TaskApplication> existingUser = taskRepository.findById(user.getId());
        HashMap<String, Object> datos = new HashMap<>();

        if (existingUser.isPresent()) {
            TaskApplication savedUser = taskRepository.save(user);
            datos.put("data", savedUser);
            datos.put("message", "Producto actualizado");

            return new ResponseEntity<>(datos, HttpStatus.OK);
        } else {
            datos.put("data", false);
            datos.put("message", "El producto con ID " + user.getId() + " no existe");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> deleteTasks(Long userId) {
        boolean exists = taskRepository.existsById(userId);
        HashMap<String, Object> datos = new HashMap<>();

        if (!exists) {
            datos.put("data", false);
            datos.put("message", "El producto con id " + userId + " no existe");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }

        taskRepository.deleteById(userId);
        datos.put("data", true);
        datos.put("message", "El producto con id " + userId + " ha sido eliminado");
        return new ResponseEntity<>(datos, HttpStatus.OK);
    }
}

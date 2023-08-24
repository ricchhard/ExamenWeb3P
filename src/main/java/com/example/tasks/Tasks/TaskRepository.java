package com.example.tasks.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface TaskRepository extends JpaRepository<TaskApplication, Long>{
    Optional<TaskApplication> findUserAplicationByName(String name);
}

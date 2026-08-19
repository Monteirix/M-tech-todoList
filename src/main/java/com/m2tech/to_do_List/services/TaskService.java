package com.m2tech.to_do_List.services;

import com.m2tech.to_do_List.entities.Task;
import com.m2tech.to_do_List.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(){return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id){ return taskRepository.findById(id);
    }

    public Task save(Task task) { return  taskRepository.save(task); }

    public boolean deleteById(Long id){
       if(taskRepository.existsById(id)){
           taskRepository.deleteById(id);
       return true;
       }else{
           return false;
       }
    }


    public Optional<Task> update(Long id, Task taskDetails) {
        return taskRepository.findById(id).map(taskExistence -> {
            taskExistence.setTitle(taskDetails.getTitle());
            taskExistence.setDescription(taskDetails.getDescription());
            taskExistence.setCompleted(taskDetails.isCompleted());

            return taskRepository.save(taskExistence);

        });
    }
}

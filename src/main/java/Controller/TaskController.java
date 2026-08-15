package Controller;

import Entities.Task;
import Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/api/task")
@CrossOrigin("*")
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping
    public List<Task>  getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id){
        return service.findById(id).map(task -> ResponseEntity.ok(task))
                .orElse(ResponseEntity.notFound().build());


    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task newTask = service.save(task);

        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        boolean deletado = service.deleteById(id);

        if (deletado){
            return  ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }




}

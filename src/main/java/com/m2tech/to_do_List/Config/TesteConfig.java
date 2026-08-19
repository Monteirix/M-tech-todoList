package com.m2tech.to_do_List.Config;

import com.m2tech.to_do_List.entities.Task;
import com.m2tech.to_do_List.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {


    private final TaskRepository taskRepository;

    public TesteConfig(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
   public void run(String... args)throws Exception {

        Task t2 = new Task(null,"Aprender Java", "ser programador prof", false);
        Task t1 = new Task(null,"Casar ", "Formar a familia Monteiro guedes", false);

        taskRepository.saveAll(Arrays.asList(t1,t2));

    }
}

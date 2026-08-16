package Config;

import Entities.Task;
import Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;



    @Override
   public void run(String... args)throws Exception {

        Task t1 = new Task(null,"Aprender Java", "ser programador prof", false);
        Task t2 = new Task(null,"Casar ", "Formar a familia Monteiro guedes", false);

        taskRepository.saveAll(Arrays.asList(t1,t2));

    }
}

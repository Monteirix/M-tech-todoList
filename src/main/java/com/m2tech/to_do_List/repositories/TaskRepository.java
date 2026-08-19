package com.m2tech.to_do_List.repositories;

import com.m2tech.to_do_List.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository  extends JpaRepository<Task,Long> {

}

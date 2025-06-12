package com.vitorbnr.todolist.repository;

import com.vitorbnr.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}

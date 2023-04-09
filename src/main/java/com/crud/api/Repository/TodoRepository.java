package com.crud.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.Model.Task;

public interface TodoRepository extends JpaRepository<Task, Long> {

}

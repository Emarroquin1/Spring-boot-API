package com.crud.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.Model.Task;
import com.crud.api.Repository.TodoRepository;

@RestController
public class TodoController {
	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping("/")
	public String Hola() {
		return "hola mundo";
	}
	
	@GetMapping("/tasksList")
	public List<Task> getTasks(){
		
		return todoRepository.findAll();
	}

	
	@PostMapping("/saveTask")
	public  List<Task> saveTask(@RequestBody Task task) {
		todoRepository.save(task);
		
		return todoRepository.findAll();
	}
	
	@PutMapping("/updateTask/{id}")
	public Task updatedTask(@PathVariable long id, @RequestBody Task task){
		Task updateTask= todoRepository.findById(id).get();
		updateTask.setTitle(task.getTitle());
		updateTask.setDescription(task.getTitle());
		todoRepository.save(updateTask);
		
		return updateTask;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Task> deletedTask(@PathVariable long id){
		Task deletedTask = todoRepository.findById(id).get();
		todoRepository.delete(deletedTask);
		
		return todoRepository.findAll();
	}
}



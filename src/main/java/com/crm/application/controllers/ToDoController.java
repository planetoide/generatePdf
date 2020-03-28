package com.crm.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crm.application.models.PostToDoModel;
import com.crm.application.models.ToDo;
import com.crm.application.services.IToDoService;

//@CrossOrigin
@RestController
@RequestMapping("/rest/toDo")
public class ToDoController {
	@Autowired
	private IToDoService toDoService;
	
	@PostMapping
	public ToDo create(@RequestBody PostToDoModel postToDoModel) {
		return toDoService.save(postToDoModel);
	}
	
	@GetMapping
	public List<ToDo> getToDoList() {
		return toDoService.getAllToDo();
	}
	
	@GetMapping("/findByUser")
	public List<ToDo> getToDoListByUser(@RequestParam Long idUser) {
		return toDoService.getAllByUser(idUser);
	}
	
	@PutMapping
	public ToDo update(@RequestBody ToDo toDo) {
		return toDoService.update(toDo);
	}
	
	@DeleteMapping
	public String deleteItem(@RequestParam Long id) {
		try {
			toDoService.delete(id);
			return "Se ha eliminado correctamnte";
		} catch(Exception ex) {
			return "no se ha podido eliminar" + ex;
		}
	}
	
	
}

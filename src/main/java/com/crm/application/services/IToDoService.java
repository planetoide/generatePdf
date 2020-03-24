package com.crm.application.services;

import java.util.List;

import com.crm.application.models.PostToDoModel;
import com.crm.application.models.ToDo;

public interface IToDoService {
	public ToDo save(PostToDoModel postToDoModel);
	public List<ToDo> getAllToDo();
	public ToDo update(ToDo toDo);
	public void delete(Long id);
	public List<ToDo> getAllByUser(Long idUser);
}

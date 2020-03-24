package com.crm.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.application.dao.IToDoDao;
import com.crm.application.dao.IUserDao;
import com.crm.application.models.PostToDoModel;
import com.crm.application.models.ToDo;
import com.crm.application.models.User;

@Service
public class ToDoServiceImpl implements IToDoService{
	@Autowired
	private IToDoDao toDoDao;
	
	@Autowired
	private IUserDao userDao;

	@Override
	public ToDo save(PostToDoModel postToDoModel) {
		User tempUser = userDao.findById(postToDoModel.getIdUser()).get();
		ToDo tempToDo = new ToDo();
		tempToDo.setDateEnd(postToDoModel.getDateEnd());
		tempToDo.setDescription(postToDoModel.getDescription());
		tempToDo.setIsDone(postToDoModel.getIsDone());
		tempToDo.setUser(tempUser);
		return toDoDao.save(tempToDo);
	}

	@Override
	public List<ToDo> getAllToDo() {
		return (List<ToDo>) toDoDao.findAll();
	}

	@Override
	public ToDo update(ToDo toDo) {
		ToDo tempToDo = toDoDao.findById(toDo.getId()).get();
		tempToDo.setDescription(toDo.getDescription());
		tempToDo.setDateEnd(toDo.getDateEnd());
		tempToDo.setIsDone(toDo.getIsDone());
		tempToDo.setUser(toDo.getUser());
		return toDoDao.save(tempToDo);
	}

	@Override
	public void delete(Long id) {
		toDoDao.deleteById(id);
	}

	@Override
	public List<ToDo> getAllByUser(Long idUser) {
		User tempUser = userDao.findById(idUser).get();
		return toDoDao.findAllByUser(tempUser);
	}



}

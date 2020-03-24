package com.crm.application.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crm.application.models.ToDo;
import com.crm.application.models.User;

public interface IToDoDao extends CrudRepository<ToDo, Long>{
	List<ToDo> findAllByUser(User user);
}

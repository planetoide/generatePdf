package com.crm.application.dao;

import org.springframework.data.repository.CrudRepository;

import com.crm.application.models.User;

public interface IUserDao extends CrudRepository<User, Long>{
	User findByEmail(String email);
}

package com.crm.application.services;

import com.crm.application.models.User;

public interface IUserService {
	public User save(User user); //crear usuario
	public User findByEmail(String email); //buscar por email
}

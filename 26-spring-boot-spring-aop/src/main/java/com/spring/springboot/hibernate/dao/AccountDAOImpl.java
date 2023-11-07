package com.spring.springboot.hibernate.dao;

import org.springframework.stereotype.Repository;

import com.spring.springboot.hibernate.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Override
	public void addAccount(Account theAccount, boolean flag) {
		System.out.println("Adding account to the DataBase from AccountDAO");
	}

}

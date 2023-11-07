package com.spring.springboot.hibernate.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

	@Override
	public void addAccount() {
		System.out.println("Adding account to the DataBase from MembershipDAO");
	}

}

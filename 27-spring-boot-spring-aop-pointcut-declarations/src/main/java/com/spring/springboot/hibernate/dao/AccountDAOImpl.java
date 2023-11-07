package com.spring.springboot.hibernate.dao;

import java.util.*;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Repository;

import com.spring.springboot.hibernate.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Override
	public void addAccount(Account theAccount, boolean flag) {
		System.out.println("=====Adding account to the DataBase from AccountDAO=====");
	}

	@Override
	public void getName() {
		System.out.println("=====From getName()=====");
	}

	@Override
	public void setName() {
		System.out.println("=====From setName()=====");
	}

	@Override
	public void getServiceCode() {
		System.out.println("=====From getServiceCode()=====");
	}

	@Override
	public void setServiceCode() {
		System.out.println("=====From setServiceCode()=====");
	}

	@Override
	public List<Account> findAccounts() {
		return findAccounts(false);
	}

	@Override
	public List<Account> findAccounts(boolean tripWire) {
		if (tripWire) {
			throw new RuntimeException("Error occured");
		}
		List<Account> account = new ArrayList<>();
		Account temp1 = new Account(" Venkata Reddy", "venkatareddy629@gmail.com");
		Account temp2 = new Account(" Gopi Reddy", "gopireddy629@gmail.com");
		account.add(temp1);
		account.add(temp2);
		return account;
	}

}

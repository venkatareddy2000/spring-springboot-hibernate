package com.spring.springboot.hibernate.dao;

import java.util.List;

import com.spring.springboot.hibernate.Account;

public interface AccountDAO {

	public void addAccount(Account theAccount, boolean flag);

	public void getName();

	public void setName();

	public void getServiceCode();

	public void setServiceCode();

	public List<Account> findAccounts();

	public List<Account> findAccounts(boolean tripWire);

}

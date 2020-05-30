package com.notyfd.demo;

import com.notyfd.demo.entity.AccountEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Service
public class AccountDAO {

	private static final String Q_FIND_ACCOUNTS = "SELECT account from AccountEntity account where account.parent is null";

	private final AccountRepository repository;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	public AccountDAO(AccountRepository repository) {
		this.repository = repository;
	}

	public List<AccountEntity> getAccountTree() {
		List<AccountEntity> accountList = null;
		try {
			accountList = entityManager.createQuery(Q_FIND_ACCOUNTS, AccountEntity.class).getResultList();
			log.info("found ");
		} catch (Exception e) {
			log.info("Exception " + e.getMessage());
		}
		return accountList;
	}

}

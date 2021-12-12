package demo3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo3.dao.AccountDao;
import demo3.model.Account;

@Service
@Transactional
public class AccountService {
	@Autowired
	private AccountDao repo;

	public Account getAccountByUsername(String username) {
		return repo.findByUserName(username);
	}
}

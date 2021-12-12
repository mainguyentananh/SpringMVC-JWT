package demo3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo3.config.UserPrincipal;
import demo3.dao.AccountDao;
import demo3.model.Account;

@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private AccountDao repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = repo.findByUserName(username);
		if (account == null)
			throw new UsernameNotFoundException("Not found account with username: " + username);
				
		return UserPrincipal.create(account);
	}
	
	public UserDetails loadUserById(int id) {
		Account account = repo.findById(id);
		if (account == null)
			throw new UsernameNotFoundException("User not found with id "+id);
		return UserPrincipal.create(account);
	}

}

package demo3.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo3.dao.AccountDao;
import demo3.dao.RefreshTokenDao;
import demo3.exception.RefreshTokenException;
import demo3.model.RefreshToken;

@Service
@Transactional
@PropertySource("classpath:jwtconfig.properties")
public class RefreshTokenService {

	
	@Value("${jwtRefreshExpirationMs}")
	private int jwtRefreshExpirationMs;
	
	@Autowired
	private RefreshTokenDao repo;
	
	@Autowired
	private AccountDao accountRepo;
	
	public void save(RefreshToken rt) {
		repo.save(rt);
	}
	
	public RefreshToken findByToken(String refreshtoken){
		return repo.findByToken(refreshtoken);
	}
	
	public void delete(RefreshToken rt) {
		repo.delete(rt);
	}

	public RefreshToken finByIdAccount(int id_account) {
		return repo.finByIdAccount(id_account);
	}
	
	public RefreshToken createRefreshToken(int userId) {
	    RefreshToken refreshToken = new RefreshToken();
	    refreshToken.setRT_account(accountRepo.findById(userId));
	    refreshToken.setRefreshtoken(UUID.randomUUID().toString());
	    refreshToken.setExpiryDate(Instant.now().plusMillis(jwtRefreshExpirationMs));
	    repo.save(refreshToken);
	    return refreshToken;
	  }

	  public RefreshToken verifyExpiration(RefreshToken token) {
	    if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
	      repo.delete(token);
	     throw new RefreshTokenException(token.getRefreshtoken(), "Refresh token was expired. Please make a new signin request");
	    
	    }
	    return token;
	  }
	
}

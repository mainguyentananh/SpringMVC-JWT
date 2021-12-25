package demo3.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo3.config.JwtTokenProvider;
import demo3.config.UserPrincipal;
import demo3.model.RefreshToken;
import demo3.payload.JwtResponse;
import demo3.payload.LoginRequest;
import demo3.payload.LogoutRequest;
import demo3.payload.RefreshTokenRequest;
import demo3.payload.RefreshTokenResponse;
import demo3.service.RefreshTokenService;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	private RefreshTokenService refreshTokenService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		if (authentication != null) {
			UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
			RefreshToken checkRT = refreshTokenService.finByIdAccount(userDetails.getId());
			if(checkRT != null)
			{
				refreshTokenService.delete(checkRT);
			}
			
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
			        .collect(Collectors.toList());
			String jwt = tokenProvider.generateToken(authentication);
			RefreshToken rt = refreshTokenService.createRefreshToken(userDetails.getId());
			return new ResponseEntity<>(new JwtResponse(userDetails.getId(),userDetails.getUsername(),jwt,rt.getRefreshtoken(),roles), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	  @PostMapping("/logout")
	  public ResponseEntity<?> logoutUser(@Valid @RequestBody LogoutRequest LogoutRequest) {
	    refreshTokenService.delete(refreshTokenService.finByIdAccount(LogoutRequest.getId()));
	    return ResponseEntity.ok("Logout Success");
	  }
	
	  
	  
	  @PostMapping("/refreshtoken")
	  public ResponseEntity<?> refreshtoken(@Valid @RequestBody RefreshTokenRequest request) {
		String requestRefreshToken = request.getRefreshToken();
		if(refreshTokenService.findByToken(requestRefreshToken) == null) {
			return new ResponseEntity<>("RefreshToken not in database!",HttpStatus.NOT_FOUND);
		}
	    RefreshToken rt = refreshTokenService.verifyExpiration(refreshTokenService.findByToken(requestRefreshToken));
	    String jwt = tokenProvider.generateTokenFromIdAccout(rt.getRT_account().getId_account());
	    return new ResponseEntity<>(new RefreshTokenResponse(jwt, rt.getRefreshtoken()),HttpStatus.OK);
	    
	    }
	  
	  
}

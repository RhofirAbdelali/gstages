package miage.abdelali.ari.Controllers;

import java.security.Principal;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import miage.abdelali.ari.Dto.UserAuthDto;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserDetailsService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	private SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();

	@GetMapping("/user")
	public String userPrincipal(Principal principal) {
		if (principal == null) {
			return "No principal";
		}
		UserDetails existingUser = userService.loadUserByUsername(principal.getName());
		return "Current user: " + existingUser.getUsername() + ", roles: " + existingUser.getAuthorities().stream()
				.map(authority -> authority.getAuthority()).collect(Collectors.joining(", "));
	}

	public record LoginRequest(String username, String password) {
	}

	@PostMapping("/login")
	public ResponseEntity<UserAuthDto> authenticateUser(@RequestBody LoginRequest loginRequest,
			HttpServletRequest request, HttpServletResponse response) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.username(),
				loginRequest.password());
		Authentication authentication = authenticationManager.authenticate(token);

		SecurityContext context = SecurityContextHolder.createEmptyContext();
		context.setAuthentication(authentication);
		securityContextRepository.saveContext(context, request, response);

		UserDetails existingUser = userService.loadUserByUsername(authentication.getName());
		if (existingUser == null) {
			throw new InternalAuthenticationServiceException("Can't find user after authentication");
		}

		return ResponseEntity.ok(createUserAuthDto(existingUser));
	}

	public UserAuthDto createUserAuthDto(UserDetails userDetails) {
		UserAuthDto user = new UserAuthDto();
		user.setUsername(userDetails.getUsername());
		user.setRoles(userDetails.getAuthorities().stream().map(authority -> authority.getAuthority()).toList());
		return user;
	}
}
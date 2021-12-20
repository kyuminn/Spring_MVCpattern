package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.command.LoginCommand;
import member.exception.IdPasswordNotMatchingException;
import member.service.AuthService;
import member.vo.AuthInfo;
import validator.LoginCommandValidator;


@RequestMapping("/login")
public class LoginController {
	@Autowired
	private AuthService authService;
	
	public LoginController(AuthService authService) {
		this.authService= authService;
	}
	
// 보통 form을 보여주는 건 get 요청으로, form 파라미터를 처리하는 것은 post 방식으로 받는다
// @CookieValue에서 value 속성은 쿠키의 이름 , required 속성은 필수 여뷰 (true가 default)
	@RequestMapping(method=RequestMethod.GET)
	public String Form(LoginCommand loginCommand,@CookieValue(value="REMEMBER",required=false)Cookie cookie) {
		if (cookie!=null) {
			loginCommand.setEmail(cookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		return "login/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(LoginCommand loginCommand, Errors errors,HttpSession session,HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if (errors.hasErrors()) {
			return "login/loginForm";
		}
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			// 로그인에 성공하면 session 에 로그인 정보 저장
			session.setAttribute("authInfo", authInfo);
			Cookie rememberCookie = new Cookie("REMEMBER",loginCommand.getEmail());
			rememberCookie.setPath("/");
			if (loginCommand.isRememberEmail()) {
				rememberCookie.setMaxAge(60*60*24*30);
			}else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie); // 브라우저에 저장하도록 서버에서 쿠키 생성 후 response 객체에 넣어줌
			return "login/loginSuccess";
		}catch(IdPasswordNotMatchingException e) {
			errors.reject("IdPasswordNotMatching"); // 글로벌 에러코드! 특정 파라미터 값이 아닌 객체 전체 검증 (아이디와 패스워드 중 어떤것이 잘못되었는지 사용자는 알 수 없음) 
			return "login/loginForm";
		}
	}
}

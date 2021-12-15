package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.command.LoginCommand;
import member.exception.IdPasswordNotMatchingException;
import member.service.AuthService;
import member.vo.AuthInfo;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private AuthService authService;
	
	public LoginController(AuthService authService) {
		this.authService= authService;
	}
	
// 보통 form을 보여주는 건 get 요청으로, form 파라미터를 처리하는 것은 post 방식으로 받는다
	
	@RequestMapping(method=RequestMethod.GET)
	public String Form() { // 여기엔 loginCommand 객체 안넣어도 되남...?
		return "login/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("formData")LoginCommand loginCommand, Errors errors) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if (errors.hasErrors()) {
			return "login/loginForm";
		}
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			return "login/loginSuccess";
		}catch(IdPasswordNotMatchingException e) {
			errors.reject("IdPasswordNotMatching"); // 글로벌 에러코드! 특정 파라미터 값이 아닌 객체 전체 검증 (아이디와 패스워드 중 어떤것이 잘못되었는지 사용자는 알 수 없음) 
			return "loign/loginForm";
		}
	}
}

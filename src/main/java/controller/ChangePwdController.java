package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.command.ChangePwdCommand;
import member.exception.IdPasswordNotMatchingException;
import member.service.ChangePasswordService;
import member.vo.AuthInfo;
import validator.ChangePwdCommandValidator;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {
	
	//changePwdSvc bean 도 등록해줘야 함 (spring-member.xml에 있음)
	@Autowired
	private ChangePasswordService changePwdSvc;
	
	public ChangePwdController(ChangePasswordService changePwdSvc) {
		this.changePwdSvc= changePwdSvc;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(@ModelAttribute("command")ChangePwdCommand pwdCmd) {
		return "edit/changePwdForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")ChangePwdCommand pwdCmd,Errors errors,HttpSession session) {
		new ChangePwdCommandValidator().validate(pwdCmd, errors);
		if(errors.hasErrors()) {
			return "edit/changePwdForm";
		}
		// 세션에서 로그인 한 상태인 사용자 가져오기
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		try {
			changePwdSvc.ChangePassword(authInfo.getEmail(), pwdCmd.getCurrentPassword(), pwdCmd.getNewPassword());
			return "edit/changePwd";
		}catch(IdPasswordNotMatchingException e) {
			errors.rejectValue("currentPassword", "notMatching");
			return "edit/changePwdForm";
		}
	}
}

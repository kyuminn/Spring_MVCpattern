package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.exception.AlreadyExistingMemberException;
import member.request.RegisterRequest;
import member.service.MemberRegisterService;

// pull test!!
@Controller
public class RegisterController {
	
	@RequestMapping( value="/register/step1",method=RequestMethod.GET)
	public String handleStep1() {
		return "register/step1";
	}
	
/*
 request Paramater를 가져오는 방식 1	
	@RequestMapping(value="/register/step2", method=RequestMethod.POST)
	public String handleStep2(HttpServletRequest request) {
		String agreeParam= request.getParameter("agree");
		if (agreeParam == null || !agreeParam.equals("true")) {
			return "register/step1";
		}
		return "register/step2";
	}
*/
	
	
// request Paramater를 가져오는 방식 2
	@RequestMapping(value="register/step2",method=RequestMethod.POST)
	public String handleStep2(@RequestParam(value="agree", defaultValue="false")Boolean agree,Model model) {
		if (!agree) {
			return "register/step1";
		}
		model.addAttribute("formData", new RegisterRequest());
		return "register/step2";
	}
	
// 약관 동의를 거치지 않고 직접(GET) 회원가입 양식을 처리했을때 리다이렉트 설정
	@RequestMapping(value="register/step2", method=RequestMethod.GET)
	public String handleStep2() {
			return "redirect:/register/step1";
		}
	
	/*
	 step2.jsp 에서 넘어온 parameter를 request 객체로 일일이 꺼낼 수도 있지만, 좀 더 효율적으로
	 스프링에서 제공하는 커맨드 객체 기능을 이용해보기
	 커맨드 객체 => setter method가 있는 메서드를 사용하여 넘어온 파라미터 값을 저장할 수 있다
	 이 프로젝트의 경우 RegisterRequest class에 setter method 지정되어 있음!
	 이 프로젝트의 커맨드 객체 > RegisterRequest !
	 DTO(VO) 가 커맨드 객체가 될 수 있음!!
	 */
	@Autowired
	private MemberRegisterService regSvc;
	public void setMemberRegisterService(MemberRegisterService regSvc) {
		this.regSvc=regSvc;
	}
	// spring이 RegisterRequest의 첫 글자만 소문자로 변경한 registerRequest를 커맨드 객체를 참조하는 이름으로 전달해준다. (아무것도 설정 안해줬을때)
	// registerRequest."param이름" 을 통해 jsp 페이지에서 사용할 수 있다
	
	// 만약 커맨드 객체의 이름을 따로 지정하고 싶으면 ModelAttribute 설정을 하면 됨!
	// 설정 후에는 formData.param이름으로 사용하면 됨
	@RequestMapping(value="register/step3", method=RequestMethod.POST)
	public String handleStep3(@ModelAttribute("formData")RegisterRequest regReq) {
		try {
			regSvc.regist(regReq);
			return "register/step3";
		}catch(AlreadyExistingMemberException e) {
			return "register/step2";
		}
	}
}

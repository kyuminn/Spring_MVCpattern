package controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import member.dao.MemberDao;
import member.exception.MemberNotFoundException;
import member.vo.MemberVo;


public class MemberDetailController {
	@Autowired
	private MemberDao memberDao;
	
	public MemberDetailController(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	
	@RequestMapping("/member/detail/{id}")
	public String detail(@PathVariable("id")Long memId,Model model) {
		MemberVo vo = memberDao.selectById(memId);
		if (vo!=null) {
			model.addAttribute("vo",vo);
			return "member/memberDetail";
		}else {
			throw new MemberNotFoundException();
		}
	}
	
	//스프링 MVC는 컨트롤러에 @ExceptionHandler가 지정되어 있으면 해당 메서드가 해당 예외를 처리하도록 우선함
	// 그래서 컨트롤러에서 발생된 예외들을 1.try~catch로 지정하거나 (29번째줄) 혹은  2. @ExceptionHandler를 지정한 메서드를 구현하면 된다
	// @ExceptionHandler = 특정 콘트롤러에서 발생한 예외 처리 / 만약 여러개의 콘트럴러에서 공통적으로 발생하는 예외가 있다면? =>CommandExceptionHandler  에서 정의
	
//	@ExceptionHandler(TypeMismatchException.class)
//	public String handleTypeMismatchException() {
//		return "member/invalidId";
//	}
	
	@ExceptionHandler(MemberNotFoundException.class)
	public String handleMemberNotFoundException() {
		return "member/noMember";
	}
}

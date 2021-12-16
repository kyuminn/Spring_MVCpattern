package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import member.command.ListCommand;
import member.dao.MemberDao;
import member.vo.MemberVo;
//hey
@Controller
public class ListController {
	@Autowired
	private MemberDao memberDao;
	
	public ListController(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	
	@RequestMapping("/member/list")
	public String list(@ModelAttribute("cmd")ListCommand listCommand,Errors errors, Model model) {
		if (errors.hasErrors()) { // @DateTimeFormat 으로 지정된 형식에 맞지 않는 예외 발생 시 스프링에서 Errors 에 typeMismatch 에러코드 추가
			return "member/memberList";
		}
		if (listCommand.getFrom()!=null && listCommand.getTo()!=null) {
			List<MemberVo> members = memberDao.selectByRegdate(listCommand.getFrom(), listCommand.getTo());
			model.addAttribute("members",members);
		}
		return "member/memberList";
	}
}

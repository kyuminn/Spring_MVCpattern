package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import member.command.ListCommand;
import member.dao.MemberDao;
import member.vo.MemberVo;

@Controller
public class ListController {
	@Autowired
	private MemberDao memberDao;
	
	public ListController(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	
	@RequestMapping("/member/list")
	public String list(@ModelAttribute("cmd")ListCommand listCommand, Model model) {
		if (listCommand.getFrom()!=null && listCommand.getTo()!=null) {
			List<MemberVo> members = memberDao.selectByRegdate(listCommand.getFrom(), listCommand.getTo());
			model.addAttribute("members",members);
		}
		return "member/memberList";
	}
}

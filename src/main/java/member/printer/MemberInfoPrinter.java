package member.printer;



import org.springframework.beans.factory.annotation.Autowired;

import member.dao.MemberDao;
import member.exception.MemberNotFoundException;
import member.vo.MemberVo;

public class MemberInfoPrinter {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter memberPrinter;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao= memberDao;
	}
	
	public void setMemberPrinter(MemberPrinter memberPrinter) {
		this.memberPrinter = memberPrinter;
	}
	
	public void printMemberInfo(String email) {
		MemberVo member = memberDao.selectByEmail(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		memberPrinter.print(member);
		System.out.println();
	}
}

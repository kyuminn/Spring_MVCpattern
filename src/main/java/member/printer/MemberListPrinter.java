package member.printer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import member.dao.MemberDao;
import member.vo.MemberVo;

// Autowired는 dataType에 맞는 bean을 찾아서 의존주입해주기 때문에
// appctx.xml에 memeberPrinter도  bean으로 등록해줘야 함!!
public class MemberListPrinter {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter memberPrinter;
	
	public MemberListPrinter(MemberDao memberDao,MemberPrinter memberPrinter) {
		this.memberDao= memberDao;
		this.memberPrinter = memberPrinter;
	}
	public MemberListPrinter() {
	}
	
	public void printAll() {
		Collection<MemberVo> members = memberDao.selectAll();
		for(MemberVo m : members) {
			memberPrinter.print(m);
		}
	}
}

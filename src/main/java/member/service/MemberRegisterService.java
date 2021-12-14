package member.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import member.dao.MemberDao;
import member.exception.AlreadyExistingMemberException;
import member.request.RegisterRequest;
import member.vo.MemberVo;

public class MemberRegisterService {
	@Autowired
	private MemberDao memberDao;
	
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao= memberDao;
	}
	
	public void regist(RegisterRequest req) {
		MemberVo member = memberDao.selectByEmail(req.getEmail());
		if (member!=null) {
			throw new AlreadyExistingMemberException("dup email"+req.getEmail());
		}
		MemberVo newMember = new MemberVo(req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}
}

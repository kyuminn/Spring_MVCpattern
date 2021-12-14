package member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import member.dao.MemberDao;
import member.exception.MemberNotFoundException;
import member.vo.MemberVo;

public class ChangePasswordService {
	@Autowired
	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao= memberDao;
	}
	
	@Transactional
	public void ChangePassword(String email, String oldPw, String newPw) {
		MemberVo vo = memberDao.selectByEmail(email);
		if (vo == null) {
			throw new MemberNotFoundException();
		}
		vo.changePassword(oldPw, newPw);
		memberDao.update(vo);
	}
}

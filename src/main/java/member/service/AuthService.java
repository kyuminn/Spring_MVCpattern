package member.service;

import member.dao.MemberDao;
import member.exception.IdPasswordNotMatchingException;
import member.vo.AuthInfo;
import member.vo.MemberVo;

public class AuthService {
	private MemberDao memberDao;
	
	
//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao=memberDao;
//	}
	
	public AuthService(MemberDao memberDao) {
		this.memberDao= memberDao;
	}
	
	public AuthInfo authenticate(String email, String password) {
		MemberVo vo = memberDao.selectByEmail(email);
		if (vo == null) {
			throw new IdPasswordNotMatchingException();
		}
		if(!vo.matchPassword(password)) {
			throw new IdPasswordNotMatchingException();
		}
		return new AuthInfo(vo.getId(), vo.getEmail(), vo.getName());
	}
}

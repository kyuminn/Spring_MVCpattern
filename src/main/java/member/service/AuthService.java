package member.service;

import org.springframework.beans.factory.annotation.Autowired;

import member.dao.MemberDao;
import member.exception.IdPasswordNotMatchingException;
import member.vo.AuthInfo;
import member.vo.MemberVo;

public class AuthService {
	@Autowired
	private MemberDao memberDao;
	
	
//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao=memberDao;
//	}
	
	public AuthService(MemberDao memberDao) {
		this.memberDao= memberDao;
	}
	
	public AuthInfo authenticate(String email, String password) {
		MemberVo vo = memberDao.selectByEmail(email);
		// ID와 Password에서 같은 Exception을 발생시킴 => 나중에 글로벌 에러코드로 처리
		if (vo == null) {
			throw new IdPasswordNotMatchingException();
		}
		if(!vo.matchPassword(password)) {
			throw new IdPasswordNotMatchingException();
		}
		return new AuthInfo(vo.getId(), vo.getEmail(), vo.getName());
	}
}

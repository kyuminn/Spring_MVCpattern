package member.dao;

import java.util.Date;
import java.util.List;

import member.vo.MemberVo;

public interface MemberDao {
	public void update(MemberVo member);
	public void insert(MemberVo member);
	public MemberVo selectByEmail(String email);
	public List<MemberVo> selectAll();
	public int count();
	public List<MemberVo> selectByRegdate(Date from, Date to);
	public MemberVo selectById(Long id);
}

package member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.RowMapper;

import member.vo.MemberVo;

public class MemberDaoImpl implements MemberDao {
	
	//Mybatis로 DB 연동할 경우 sqlSessionTemplate 객체 이용
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate= sqlSessionTemplate;
	}
	
	public MemberVo selectByEmail(String email) {
		return sqlSessionTemplate.selectOne("selectByEmail",email);
	}
	
	public List<MemberVo> selectAll(){
		return sqlSessionTemplate.selectList("list");
	}
	
	public int count() {
		return sqlSessionTemplate.selectOne("count");
	}
	
	public void update(MemberVo vo) {
		sqlSessionTemplate.update("update", vo);
	}
	public void insert(MemberVo vo) {
		sqlSessionTemplate.insert("insert", vo);
	}
	
	// 날짜를 이용한 전체 멤버 반환
	public List<MemberVo> selectByRegdate(Date from, Date to){
		HashMap<String,Date> map = new HashMap<String,Date>();
		map.put("from", from);
		map.put("to", to);
		return sqlSessionTemplate.selectList("selectByRegdate",map);
	}
	
	
	public MemberVo selectById(Long id) {
		List<MemberVo> results =sqlSessionTemplate.selectList("selectById", id);
		return results.isEmpty()? null : results.get(0);
	}
	
}

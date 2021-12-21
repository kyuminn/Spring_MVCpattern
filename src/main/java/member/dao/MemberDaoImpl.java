package member.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.vo.MemberVo;
@Repository
public class MemberDaoImpl implements MemberDao {
	
	//Mybatis로 DB 연동할 경우 sqlSessionTemplate 객체 이용
	
	@Autowired
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
	// MyBatis를 이용할 때 파라미터는 하나만 보낼 수 있음
	//만약 여러개의 파라미터를 전달하고 싶으면 Map 객체 이용 or 값을 담은 Command 객체 이용하기
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

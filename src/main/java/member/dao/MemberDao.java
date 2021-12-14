package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import org.springframework.jdbc.core.PreparedStatementCreator;
import member.rowMapper.MemberRowMapper;
import member.vo.MemberVo;

public class MemberDao {
	
	//jdbcTemplate 객체 : jsp에서 사용하던 Connection, PreparedStatement, ResultSet 의 역할을 적절히 대신해줌.
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public MemberVo selectByEmail(String email) {
		String sql="select * from member where email=?";
//		
//		RowMapper<MemberVo> rowMapper = new RowMapper<MemberVo>() {
//			@Override
//			public MemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
//				MemberVo vo = new MemberVo();
//				vo.setId(rs.getLong("id"));
//				vo.setEmail(rs.getString("email"));
//				vo.setPassword(rs.getString("password"));
//				vo.setRegdate(rs.getDate("regdate"));
//				return vo;
//			}
//		};
		
		List<MemberVo> result = jdbcTemplate.query(sql, new MemberRowMapper(), email);
		return result.isEmpty()? null : result.get(0);
	}
	
	public List<MemberVo> selectAll(){
		
		String sql="select * from member";
//		RowMapper<MemberVo> rowMapper = new RowMapper<MemberVo>() {
//			@Override
//			public MemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
//				MemberVo vo = new MemberVo();
//				vo.setId(rs.getLong("id"));
//				vo.setEmail(rs.getString("email"));
//				vo.setName(rs.getString("name"));
//				vo.setRegdate(rs.getDate("regdate"));
//				return vo;
//			}
//		};
		List<MemberVo> result=jdbcTemplate.query(sql, new MemberRowMapper());
		return result;
	}
	
	//결과가 하나의 행만을 가지는 것을 알때 사용하는 메서드 : queryForObject
	
	public int count() {
		String sql="select count(*) from member";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
	
	// insert, update, delete 쿼리 실행 시 사용하는 update() method
	
	public void update(MemberVo vo) {
		String sql="update member set name=?, password=? where email=?";
		jdbcTemplate.update(sql, vo.getName(), vo.getPassword(), vo.getEmail());
	}
	
	// pstmt creator 사용해보기
	public void insert(final MemberVo vo) {

		String sql="insert into member values(member_seq.nextval,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql,new String[] {"id"});
				pstmt.setString(1, vo.getEmail());
				pstmt.setString(2, vo.getPassword());
				pstmt.setString(3, vo.getName());
				pstmt.setTimestamp(4, new Timestamp(vo.getRegdate().getTime()));
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		vo.setId(keyValue.longValue());
	}
	
}

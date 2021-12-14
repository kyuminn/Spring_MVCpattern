package member.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import member.vo.MemberVo;

public class MemberRowMapper implements RowMapper<MemberVo> {

	@Override
	public MemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVo vo = new MemberVo();
		vo.setId(rs.getLong("id"));
		vo.setEmail(rs.getString("email"));
		vo.setName(rs.getString("name"));
		vo.setPassword(rs.getString("password"));
		vo.setRegdate(rs.getDate("regdate"));
		return vo;
	}
	
}

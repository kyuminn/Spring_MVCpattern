package member.vo;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import member.exception.IdPasswordNotMatchingException;

@Getter
@Setter
@NoArgsConstructor
public class MemberVo {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date regdate;
	
	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword)) throw new IdPasswordNotMatchingException();
		this.password= newPassword;
	}

	public MemberVo(String email, String password, String name, Date regdate) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.regdate = regdate;
	}
}

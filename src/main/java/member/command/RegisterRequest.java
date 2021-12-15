package member.command;

import lombok.Getter;
import lombok.Setter;

// 등록을 위한 정보가 담겨있는 객체
// form 태그에서 적은 request의 parameter가 담길 command 객체와 같은 역할을 한다!
@Getter
@Setter
public class RegisterRequest {
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	
	public boolean isPasswordEqualsToConfirmPassword() {
		return password.equals(confirmPassword);
	}
	
}

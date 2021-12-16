package member.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 로그인 성공 후 인증 상태를 세션에 보관하기 위한 클래스 작성
@Getter
@AllArgsConstructor
public class AuthInfo {
	private Long id;
	private String email;
	private String name;
	
}

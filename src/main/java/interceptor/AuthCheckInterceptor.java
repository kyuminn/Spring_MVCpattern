package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// handler= controller
// handler 실행 전/ handler 실행 후+ 뷰 실행 전 / 뷰 실행 이후
// 세 시점에 끼어들어가서 작업을 수행할 수 있음
//HandlerInterceptor interface가 아닌 그 인터페이스를 구현해놓은 HandelrInterceptorAdapter를 상속하면
// 필요한 메서드만 override 해서 사용할 수 있다 (인터페이스를 바로 구현할 경우 모든 메서드를 다 오버라이딩해야함)
public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

	// 로그인 하지 않은 상태에서 비밀번호 변경 폼을 요청하면 세션이 없으므로 changePwdController 실행 전에
	// 인터셉터가 동작해서 로그인 페이지로 리다이렉트 
	
	// controller 실행 전에 수행되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false); // session이 존재하지 않으면 새로 만들지 않음
		if (session !=null) {
			Object authInfo  = session.getAttribute("authInfo");
			if (authInfo !=null) {
				return true; // true 반환되면 Controller 동작
			}
		}
		// session안에 AuthInfo 가 없으면 로그인 페이지로 리다이렉트
		response.sendRedirect(request.getContextPath()+"/login");
		return false;
	}
}

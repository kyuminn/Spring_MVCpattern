package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// handler= controller
// handler 실행 전/ handler 실행 후+ 뷰 실행 전 / 뷰 실행 이후
// 세 시점에 끼어들어가서 작업을 수행할 수 있음
public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

	// controller 실행 전에 수행되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		request.getse
		return false;
	}

	
}

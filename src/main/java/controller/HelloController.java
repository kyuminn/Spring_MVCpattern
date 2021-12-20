package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


public class HelloController {
	@RequestMapping("/hello") 
	public String hello() {
		return "hello";
	}
	
	// /hello = > f.c가 요청분석 후 알맞은 requestMapping을 가진 controller(이 경우에는 HelloController)를 찾아서 처리하게 함=> jsp 파일의 이름이 String type으로 반환됨 
	// => spring-mvc.xml의 view-resolver tag를 통해 알맞은 jsp 파일로 응답할 수 있게 해줌
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request, Model model) {
		int n1=Integer.parseInt(request.getParameter("n1"));
		int n2=Integer.parseInt(request.getParameter("n2"));
		int result = n1 + n2;
		model.addAttribute("result",result); // jsp 에서 request or session 에 setAttribute 한것처럼!
		return "add";
	}

// request 객체 필요 없이 바로 request parameter와 같은 이름의 변수를 매개변수로 넣어주면 스프링이 알아서 인식함
//	@RequestMapping("/add1")
//	public String add(int n1, /*@RequestParam("n3")*/int n2, Model model) { // spring이 알아서 요청 파라미터와 이름이 같은 파라미터로 값 대입해줌
//		// 만약 n3로 요청할거면 앞에 RequestParam 선언해주면 된다
//		int result = n1 + n2;
//		model.addAttribute("result",result); 
//		return "add";
//	}
	
	
	
	// 경로를 보기좋게 만드려면
	// add2/10/20 이런식으로 요청할 수 있음
	@RequestMapping("/add2/{n1}/{n2}")
	public String add(@PathVariable("n1")int n1,@PathVariable("n2")int n2, Model model) { 
		// 만약 n3로 요청할거면 앞에 RequestParam 선언해주면 된다
		int result = n1 + n2;
		model.addAttribute("result",result); 
		return "add";
	}
	
}

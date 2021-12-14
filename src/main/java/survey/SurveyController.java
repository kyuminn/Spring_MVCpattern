package survey;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/survey")
public class SurveyController {

//  SurveyForm 보여주기 방식 1
//	@RequestMapping(method=RequestMethod.GET)
//	public String form() {
//		return "survey/surveyForm";
//	}

//  SurveyForm 보여주기 방식 2
//	@RequestMapping(method=RequestMethod.GET)
//	public String form(Model model) {
//		List<Questions> questions = createQuestions();
//		model.addAttribute("questions",questions);
//		return "survey/surveyForm";
//	}
//	
	private List<Questions> createQuestions(){
		Questions q1 = new Questions("당신의 역할은?",Arrays.asList("서버","프론트","풀스택"));
		Questions q2 = new Questions("주로 사용하는 개발 도구?",Arrays.asList("이클립스","인텔리J","서브라임"));
		Questions q3 = new Questions("하고 싶은 말");
		return Arrays.asList(q1,q2,q3);
	}

//  SurveyForm 보여주기 방식 3 : ModelAndView 이용해서 한꺼번에 처리하기
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(Model model) {
		List<Questions> questions = createQuestions();
		ModelAndView mav = new ModelAndView();	
		// 모델 객체 지정 (27번째줄)
		mav.addObject("questions", questions);
		// 뷰 이름 지정 (28번째줄)
		mav.setViewName("survey/surveyForm");
		return mav;
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("ansData")AnsweredData data) {
		return "survey/submitted";
	}
}

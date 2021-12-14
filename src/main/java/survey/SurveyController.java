package survey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "survey/surveyForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("ansData")AnsweredData data) {
		return "survey/submitted";
	}
}

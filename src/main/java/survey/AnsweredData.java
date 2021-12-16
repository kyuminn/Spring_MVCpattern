package survey;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnsweredData { // 설문 항목에 대한 답변과 응답자의 정보를 담기 위한 클래스
	private List<String> responses;
	private Respondent res;
	
	
}

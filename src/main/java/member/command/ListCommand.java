package member.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListCommand {
	// 이 커맨드 클래스를 사용하는 입력 폼에서, input 에 입력한 문자열을 Date 타입으로 변환해주어야 함
	// Spring mvc는 커맨드 객체에 @DateTimeFormat 이 적용되어 있으면 지정된 형식을 이용하여 문자열을 Date 타입으로 변환해준다
	
	
	@DateTimeFormat(pattern="yyyyMMddHH")
	private Date from;
	@DateTimeFormat(pattern="yyyyMMddHH")
	private Date to;
}

package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import member.command.RegisterRequest;

//커맨드 객체 검증
public class RegisterRequestValidator implements Validator{
	
	private static final String emailRegExp= "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
	private Pattern pattern;
	
	public RegisterRequestValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	
	// 검증할 수 있는 타입인지를 검사
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	// 첫 번째 파라미터로 받은 객체를 검증하고, 검증 결과를 errors 에 담는다
	@Override
	public void validate(Object target, Errors errors) {
		// target = 검사 대상 객체
		// errors = 검사 결과 에러코드를 저장하는 객체
		RegisterRequest regReq=(RegisterRequest)target;
		if(regReq.getEmail()== null || regReq.getEmail().trim().isEmpty()){
			errors.rejectValue("email", "required");
		}else {
			Matcher matcher = pattern.matcher(regReq.getEmail());
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}
		//간결하게 ValidationUtils를 이용하여 검증 후 에러가 있다면 errors 에 저장할 수도 있음!
		// handleStep3 method에 errors 객체 추가해서 target의 name값을 인식하게 해야 함
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword","required");
		if(!regReq.getPassword().isEmpty()) {
			if(!regReq.isPasswordEqualsToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
		                                                                                                                                           
		
	}

}

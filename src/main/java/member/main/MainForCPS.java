package member.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import member.exception.IdPasswordNotMatchingException;
import member.exception.MemberNotFoundException;
import member.service.ChangePasswordService;

public class MainForCPS {
	// 특정 클래스의 로그만 찍을때 사용하는 Logger 객체
	private final static Logger logger = LogManager.getLogger(MainForCPS.class);
	public static void main(String[] args) {
		logger.info("MainForCPS");
		GenericXmlApplicationContext appctx = new GenericXmlApplicationContext("classpath:appctx.xml");
		
		ChangePasswordService cps = appctx.getBean("changePwdSvc", ChangePasswordService.class);
		//logger.info("MainForCPSS"+cps);
		try {
			cps.ChangePassword("paraday@naver.com", "1234", "1111");
			System.out.println("암호를 변경하였습니다");
		}catch(MemberNotFoundException e) {
			System.out.println("회원 정보가 존재하지 않습니다");
		}catch(IdPasswordNotMatchingException e) {
			//System.out.println("암호를 다시 확인하세요");
			logger.info("암호를 확인해주세요!");
		}
	}
}

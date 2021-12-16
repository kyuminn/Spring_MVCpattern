package member.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePwdCommand {
	private String currentPassword;
	private String newPassword;
	
	
}

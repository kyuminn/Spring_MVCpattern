package survey;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Questions {
	private String title;
	private List<String> options;
	
	public Questions(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public Questions(String title) {
		this(title, Collections.<String>emptyList()); // 주관식 항목일 경우!
	}
	
	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}
	
	

}

package m.wiaterek.Hrofile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hController {
	
	@GetMapping("/test")
	public int test() {
		return 1;
	}

}

package unndb.test2;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

	@Autowired
	private CatService catService;
	
	@GetMapping("/cats")
	public List<Cat> getAllCats() {
		return catService.getAllCats();
	}

	@GetMapping("/cats/{id}")
	public Cat getCat(@PathVariable Long id) {
		return catService.getCat(id);
	}
}

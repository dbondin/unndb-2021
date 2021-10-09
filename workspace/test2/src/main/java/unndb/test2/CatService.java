package unndb.test2;

import java.util.List;

public interface CatService {
	List<Cat> getAllCats();
	Cat getCat(Long id);
}

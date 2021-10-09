package unndb.test2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements CatService {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private CatRepository catRepository;

	@Override
	@Cacheable(cacheNames = "getAllCats")
	public List<Cat> getAllCats() {
		List<Cat> result = new ArrayList<>();
		catRepository.findAll().forEach(c -> result.add(c));
		return result;
	}
	
	@Override
	@Cacheable(cacheNames = "getCat")
	public Cat getCat(Long id) {
		return catRepository.findById(id).orElse(null);
	}
}

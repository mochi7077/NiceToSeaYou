package tw.com.ispan.eeit48.service;

import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ispan.eeit48.domain.ProductBean;
import tw.com.ispan.eeit48.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductBean> findAllByOwnerid(int OwnerId) {
		// 以Ownerid方法找尋商品
		List<ProductBean> beans = productRepository.findAllByOwnerid(OwnerId); // (1)之後要能被選擇
		if (beans != null) {
			return beans;
		}
		return null;
	}

}

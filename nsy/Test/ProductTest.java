package tw.com.ispan.eeit48.ducktest;

import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import tw.com.ispan.eeit48.domain.OrdersBean;
import tw.com.ispan.eeit48.domain.ProductBean;
import tw.com.ispan.eeit48.repository.OrdersReposirory;
import tw.com.ispan.eeit48.repository.ProductRepository;

@SpringBootTest
public class ProductTest {
	@Autowired
	ProductRepository productRepository;
	
//	@Test
//	public void findAll() {
//		//找全部商品的方法(JSON)
//		List<ProductBean> beans = productRepository.findAll();
//		if(beans!=null) {
//			
//			JSONArray list = new JSONArray();
//			for(ProductBean bean:beans) {
//		    	list.put(bean.toJsonObject());
//		    }
//			 System.out.println(list.toString());				
//	}
//}
//	@Test
//	public void findAllById() {
//		//以商品ID的方法找到那個商品(JSON)
//		List<Integer> idList = Arrays.asList(100002);//(2D202209090001)之後要能被選擇
//		List<ProductBean> beans = productRepository.findAllById(idList);
//		if(beans!=null) {
//			
//			JSONArray list = new JSONArray();
//			for(ProductBean bean:beans) {
//		    	list.put(bean.toJsonObject());
//		    }
//			 System.out.println(list.toString());				
//	}
//}  
	
//	@Test
//	public void findAllByOwnerid() {
//		//以Ownerid方法找尋商品(JSON)
//		List<ProductBean> beans = productRepository.findAllByOwnerid(1); //(1)之後要能被選擇
//		if(beans!=null) {
//			
//			JSONArray list = new JSONArray();
//			for(ProductBean bean:beans) {
//		    	list.put(bean.toJsonObject());
//		    }
//			 System.out.println(list.toString());				
//	}
//}
	
}

package tw.com.ispan.eeit48.AccountsServiceTests;

import java.util.List;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.com.ispan.eeit48.domain.AccountsBean;
import tw.com.ispan.eeit48.repository.AccountsRepository;
import tw.com.ispan.eeit48.service.AccountsService;

@SpringBootTest
public class AccountsServiceTests {
	@Autowired 
	AccountsService accountsService;
	@Autowired
	AccountsRepository accountsRepository;
	
	
	@Test
	public void findAllaccount() {
		List<AccountsBean> beans = accountsService.findAll();
		if(beans!=null) {
			JSONArray list = new JSONArray();
		    for(AccountsBean bean:beans) {
		    	list.put(bean.toJsonObject());
		    }
		    System.out.println(list.toString());
		} else {
			System.out.println("select beans not exist");
		}
		
		
	}
	
}

package tw.com.ispan.eeit48.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.ispan.eeit48.domain.AccountsBean;
import tw.com.ispan.eeit48.repository.AccountsRepository;

@Service
@Transactional
public class AccountsService {
	@Autowired
	private AccountsRepository accountsRepository;

	@Transactional(readOnly = true)
	public AccountsBean login(String account, String password) {
		System.out.println(account);
		System.out.println(password);
		Optional<AccountsBean> result = accountsRepository.findOneByaccount(account);
		System.out.println(result);
		if (result.isPresent()) {
			// System.out.println("select bean="+result.get());
			if (result.get().getPassw().equals(password)) {
				System.out.println("Enter Successfull");
				return result.get();
			} else {
				System.out.println("Wrong Password");
			}
		} else {
			System.out.println("select bean not exist");
		}
		return null;
	}

	public List<AccountsBean> findAll() {
		// Json陣列方法
		List<AccountsBean> result = accountsRepository.findAll();
		if (result != null) {
			return result;
		} else {
			System.out.println("Nothing found");
		}
		return null;
	}

}

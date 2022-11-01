package tw.com.ispan.eeit48.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.ispan.eeit48.domain.AccountsBean;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsBean, Integer> {

	Optional<AccountsBean> findOneByaccount(String string);

	AccountsBean findByaccount(String account);

}

package tw.com.ispan.eeit48.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.ispan.eeit48.domain.AccountsBean;
import tw.com.ispan.eeit48.domain.OrdersBean;
import tw.com.ispan.eeit48.domain.ProductBean;



@Repository
public interface OrdersReposirory extends JpaRepository<OrdersBean, String>{

	
	List<OrdersBean> findAllBySellerid(int sellerid);
	List<OrdersBean> findAllByBuyerid(int buyerid);
	List<OrdersBean> findAllBySelleridAndOrderstatus(int sellerid,int orderstatus);
//	List<OrdersBean> findAllByOrderstatus(int orderstatus);
}

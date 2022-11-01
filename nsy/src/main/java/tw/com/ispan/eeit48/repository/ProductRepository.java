package tw.com.ispan.eeit48.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.com.ispan.eeit48.domain.ProductBean;

@Repository
public interface ProductRepository extends JpaRepository<ProductBean, Integer>{
	List<ProductBean> findAllByOwnerid(int ownerid);
	
}

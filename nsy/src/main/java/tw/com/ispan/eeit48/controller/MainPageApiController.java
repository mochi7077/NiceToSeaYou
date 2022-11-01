package tw.com.ispan.eeit48.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ispan.eeit48.domain.AccountsBean;
import tw.com.ispan.eeit48.domain.ProductBean;
import tw.com.ispan.eeit48.service.AccountsService;
import tw.com.ispan.eeit48.service.ProductService;

// 庫存總覽頁面
@RestController
@RequestMapping(path = { "/views/orderstock" })
public class MainPageApiController {
	@Autowired
	ProductService productService;
	
	// 回傳使用者所有商品資訊, 包括已訂未出數 & 可出現貨數 & 已叫現貨數
	@PostMapping
	public String userProductInformation(HttpSession session) {
		if (session.getAttribute("user") != null) {
			AccountsBean user = (AccountsBean) session.getAttribute("user");
			int userId = user.getAccountid();
			if (userId > 0) {
				// 依照userId, 找出他所有產品資訊
				List<ProductBean> productBeans = productService.findAllByOwnerid(userId);
				JSONArray list = new JSONArray();
				for(ProductBean productBean:productBeans) {
					JSONObject jsonProductBean = productBean.toJsonObject();
					// 以下資料為假資料, 目前阿封處理方法中
					// 已訂未出數(noshipping) = 各產品訂單狀態為2~4的總數 (prodcutId -> Where SellerId = 自己 && Status = 2~4 -> 加總)   
					// 可出現貨數(stockown) = 各產品庫存數-已訂未出數   		  
					// 已叫現貨數(callshipping) = 各商品所有的的叫貨數      (productId -> orderDetailTable裡的sellerProductId找數量(同時OrderTable BuyerId=自己)
					jsonProductBean.put("noshipping", 40);
					jsonProductBean.put("stockown", 40);
					jsonProductBean.put("callshipping", 0);
					list.put(jsonProductBean);
				}
				// 回傳JSON字串給前端
				return list.toString();
			} else {
				System.out.println("no product for this User");
			}
		} else {
			System.out.println("UserId is null");
		}
		return null;
	}
}

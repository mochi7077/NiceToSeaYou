package tw.com.ispan.eeit48.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import tw.com.ispan.eeit48.domain.AccountsBean;
import tw.com.ispan.eeit48.domain.OrderDetailsBean;
import tw.com.ispan.eeit48.domain.OrdersBean;
import tw.com.ispan.eeit48.domain.ProductBean;
import tw.com.ispan.eeit48.domain.ProductClassIficationBean;
import tw.com.ispan.eeit48.domain.SortComparator;
import tw.com.ispan.eeit48.domain.View_product_order_orderdetailsBean;
import tw.com.ispan.eeit48.repository.AccountsRepository;
import tw.com.ispan.eeit48.repository.OrderDetailsRepositrory;
import tw.com.ispan.eeit48.repository.OrdersRepository;
import tw.com.ispan.eeit48.repository.ProductClassIficationRepository;
import tw.com.ispan.eeit48.repository.ProductRepository;
import tw.com.ispan.eeit48.repository.View_product_order_orderdetailsRepository;

@Service
@Transactional

public class DataAnalyzeService {
	@Autowired
	private View_product_order_orderdetailsRepository view_product_order_orderdetailsRepository;
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private OrderDetailsRepositrory orderDetailsRepositrory;
	@Autowired
	private AccountsRepository accountsRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductClassIficationRepository classIficationRepository;

	public String ShowAll(Integer accountid, String ordertime, String completeordertime) throws ParseException {
		JSONObject[] obj;
		JSONArray ListSHowAll = new JSONArray();
		ListSHowAll.clear();
		String[] orderid;
		int[] buyerid;
		int[] productid;
		int[] productclassification;
		String[] companyname;
		String[] classname;
		int[] orderqty;
		int[] unitsellprice;
		int[] cost;
		Date DateofOrdertime = new SimpleDateFormat("yyyy-MM-dd").parse(ordertime);
		Date DateofCompleteOrdertime = new SimpleDateFormat("yyyy-MM-dd").parse(completeordertime);
		List<OrdersBean> ob = ordersRepository
				.findAllBySelleridAndOrderstatusAndOrdertimeBetweenAndCompleteordertimeBetween(accountid, 6,
						DateofOrdertime, DateofCompleteOrdertime, DateofOrdertime, DateofCompleteOrdertime); // ?????????????????????????????????
//????????????????????????????????????????????????
		JSONArray LISTofFindOrderid = new JSONArray();
		if (ob != null) {
			for (OrdersBean bean : ob) {
				if (bean != null) {
					LISTofFindOrderid.put(bean.toJsonObject());
				}
			}

		}
		int length = LISTofFindOrderid.length();
		orderid = new String[length];
		for (int i = 0; i < LISTofFindOrderid.length(); i++) {
			orderid[i] = (String) LISTofFindOrderid.getJSONObject(i).get("orderid");
		}
		JSONArray ListofOrderDetail = new JSONArray();
		ListofOrderDetail.clear();
		for (int b = 0; b < LISTofFindOrderid.length(); b++) {
			List<OrderDetailsBean> od = orderDetailsRepositrory.findAllByOrderid(orderid[b]); // ???????????????????????????
			if (ob != null) {
				for (OrderDetailsBean bean : od) {
					if (bean != null) {
						ListofOrderDetail.put(bean.toJsonObject());
					}
				}

			}
		}
		int NumberofListofOrderDetail = ListofOrderDetail.length();
		productid = new int[NumberofListofOrderDetail];
		productclassification = new int[NumberofListofOrderDetail];
		buyerid = new int[NumberofListofOrderDetail];
		companyname = new String[NumberofListofOrderDetail];
		classname = new String[NumberofListofOrderDetail];
		obj = new JSONObject[NumberofListofOrderDetail];
		orderqty = new int[NumberofListofOrderDetail];
		unitsellprice = new int[NumberofListofOrderDetail];
		cost = new int[NumberofListofOrderDetail];
		;
		for (int s = 0; s < ListofOrderDetail.length(); s++) {
			productid[s] = (int) ListofOrderDetail.getJSONObject(s).get("sellerproductid");
		}

		JSONArray ListofFindProduct = new JSONArray();
		ListofFindProduct.clear();
		for (int i = 0; i < ListofOrderDetail.length(); i++) {

			List<View_product_order_orderdetailsBean> vb = view_product_order_orderdetailsRepository
					.findAllByProductid(productid[i]); // ?????????????????????
			if (vb != null) {
				for (View_product_order_orderdetailsBean bean : vb) {
					if (bean != null) {
						ListofFindProduct.put(bean.toJsonObject());
					}
				}

			}

		}

		for (int i = 0; i < ListofOrderDetail.length(); i++) {
			buyerid[i] = (int) ListofFindProduct.getJSONObject(i).get("buyerid");
			orderqty[i] = (int) ListofFindProduct.getJSONObject(i).get("orderqty");
		}

		JSONArray ListofAccount = new JSONArray();
		ListofAccount.clear();

		for (int i = 0; i < ListofOrderDetail.length(); i++) {
			List<AccountsBean> oa = accountsRepository.findAllByAccountid(buyerid[i]); // ?????????????????????
			if (ob != null) {
				for (AccountsBean bean : oa) {
					if (bean != null) {
						ListofAccount.put(bean.toJsonObject());
					}
				}
			}
		}

		for (int i = 0; i < ListofOrderDetail.length(); i++) {
			companyname[i] = (String) ListofAccount.getJSONObject(i).get("companyname");
		}

		JSONArray ListofCount = new JSONArray();
		ListofCount.clear();
		for (int v = 0; v < ListofOrderDetail.length(); v++) {
			List<ProductBean> op = productRepository.findAllByProductid(productid[v]); // ?????????????????????
			if (ob != null) {
				for (ProductBean bean : op) {
					if (bean != null) {
						ListofCount.put(bean.toJsonObject());
					}
				}

			}

		}

		for (int v = 0; v < ListofOrderDetail.length(); v++) {
			productclassification[v] = (int) ListofCount.getJSONObject(v).get("productclassification");
			unitsellprice[v] = (int) ListofCount.getJSONObject(v).get("unitsellprice");
			cost[v] = (int) ListofCount.getJSONObject(v).get("unitcost");
		}

		JSONArray ListofClass = new JSONArray();
		ListofClass.clear();
		for (int z = 0; z < ListofOrderDetail.length(); z++) {
			List<ProductClassIficationBean> oc = classIficationRepository.findAllByClassid(productclassification[z]); // ???????????????????????????
			if (oc != null) {
				for (ProductClassIficationBean bean : oc) {
					if (bean != null) {
						ListofClass.put(bean.toJsonObject());
					}
				}

			}
		}
		for (int v = 0; v < ListofOrderDetail.length(); v++) {
			classname[v] = (String) ListofClass.getJSONObject(v).get("classdesc");
		}
		for (int i = 0; i < ListofOrderDetail.length(); i++) {
			obj[i] = new JSONObject();
		}

		for (int i = 0; i < ListofOrderDetail.length(); i++) {
			int a = unitsellprice[i];
			int b1 = cost[i];
			unitsellprice[i] = a - b1;
		}

		for (int i = 0; i < ListofOrderDetail.length(); i++) {
			obj[i].put("buyerid", buyerid[i]);
			obj[i].put("classname", classname[i]);
			obj[i].put("orderqty", orderqty[i]);
			obj[i].put("unitsellprice", unitsellprice[i]);
			obj[i].put("productclassification", productclassification[i]);
			obj[i].put("companyname", companyname[i]);
			ListSHowAll.put(obj[i]);
		}
		return ListSHowAll.toString();

	}

}

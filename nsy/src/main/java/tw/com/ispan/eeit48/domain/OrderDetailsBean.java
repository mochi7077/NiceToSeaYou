package tw.com.ispan.eeit48.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name="orderdetails")
public class OrderDetailsBean {

	@Id
	@Column(columnDefinition = "char")
	private String orderid;
	private Integer sellerproductid;
	private Integer orderqty;
	private Integer dealprice;
	@Override
	public String toString() {
		return "OrderDetailsBean [orderid=" + orderid + ", sellerproductid=" + sellerproductid + ", orderqty="
				+ orderqty + ", dealprice=" + dealprice + "]";
	}
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Integer getSellerproductid() {
		return sellerproductid;
	}
	public void setSellerproductid(Integer sellerproductid) {
		this.sellerproductid = sellerproductid;
	}
	public Integer getOrderqty() {
		return orderqty;
	}
	public void setOrderqty(Integer orderqty) {
		this.orderqty = orderqty;
	}
	public Integer getDealprice() {
		return dealprice;
	}
	public void setDealprice(Integer dealprice) {
		this.dealprice = dealprice;
	}
	
	public JSONObject toJsonObject() {
		JSONObject obj = new JSONObject();
		obj.put("orderid", orderid);
		obj.put("orderqty", orderqty);
		obj.put("dealprice", dealprice);
		obj.put("sellerproductid", sellerproductid);
		
		return obj;
	}
}

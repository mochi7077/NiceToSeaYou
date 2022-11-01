package tw.com.ispan.eeit48.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name="orders")
public class OrdersBean {

	@Id
	@Column(columnDefinition = "char")
	private String 	orderid;
	private Integer buyerid;
	private Integer sellerid;
	private Integer orderstatus;
	@Column(columnDefinition = "char")
	private String 	paymentterms;
	@Column(columnDefinition = "char")
	private String 	deliveryorderid;
	@Column(columnDefinition = "char")
	private String 	deliveryorderremark;
	@Column(columnDefinition = "datetime")
	private String 	ordertime;
	@Column(columnDefinition = "datetime")
	private String 	acceptordertime;
	@Column(columnDefinition = "datetime")
	private String 	exporttime;
	@Column(columnDefinition = "datetime")
	private String 	sellerestimatedarrivetime;
	@Column(columnDefinition = "datetime")
	private String 	arriveordertime;
	@Column(columnDefinition = "datetime")
	private String 	completeordertime;
	@Column(columnDefinition = "datetime")
	private String cancelordertime;
	
	@Override
	public String toString() {
		return "OrdersBean [orderid=" + orderid + ", buyerid=" + buyerid + ", sellerid=" + sellerid + ", orderstatus="
				+ orderstatus + ", paymentterms=" + paymentterms + ", deliveryorderid=" + deliveryorderid
				+ ", deliveryorderremark=" + deliveryorderremark + ", ordertime=" + ordertime + ", acceptordertime="
				+ acceptordertime + ", exporttime=" + exporttime + ", sellerestimatedarrivetime="
				+ sellerestimatedarrivetime + ", arriveordertime=" + arriveordertime + ", completeordertime="
				+ completeordertime + ", cancelordertime=" + cancelordertime + "]";
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Integer getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(Integer buyerid) {
		this.buyerid = buyerid;
	}
	public Integer getSellerid() {
		return sellerid;
	}
	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}
	public Integer getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getPaymentterms() {
		return paymentterms;
	}
	public void setPaymentterms(String paymentterms) {
		this.paymentterms = paymentterms;
	}
	public String getDeliveryorderid() {
		return deliveryorderid;
	}
	public void setDeliveryorderid(String deliveryorderid) {
		this.deliveryorderid = deliveryorderid;
	}
	public String getDeliveryorderremark() {
		return deliveryorderremark;
	}
	public void setDeliveryorderremark(String deliveryorderremark) {
		this.deliveryorderremark = deliveryorderremark;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getAcceptordertime() {
		return acceptordertime;
	}
	public void setAcceptordertime(String acceptordertime) {
		this.acceptordertime = acceptordertime;
	}
	public String getExporttime() {
		return exporttime;
	}
	public void setExporttime(String exporttime) {
		this.exporttime = exporttime;
	}
	public String getSellerestimatedarrivetime() {
		return sellerestimatedarrivetime;
	}
	public void setSellerestimatedarrivetime(String sellerestimatedarrivetime) {
		this.sellerestimatedarrivetime = sellerestimatedarrivetime;
	}
	public String getArriveordertime() {
		return arriveordertime;
	}
	public void setArriveordertime(String arriveordertime) {
		this.arriveordertime = arriveordertime;
	}
	public String getCompleteordertime() {
		return completeordertime;
	}
	public void setCompleteordertime(String completeordertime) {
		this.completeordertime = completeordertime;
	}
	public String getCancelordertime() {
		return cancelordertime;
	}
	public void setCancelordertime(String cancelordertime) {
		this.cancelordertime = cancelordertime;
	}

	
	public JSONObject toJsonObject() {
		JSONObject obj = new JSONObject();
		obj.put("orderid", orderid);
		obj.put("buyerid", buyerid);
		obj.put("sellerid", sellerid);
		obj.put("orderstatus", orderstatus);
		obj.put("paymentterms", paymentterms);
		obj.put("deliveryorderid", deliveryorderid);
		obj.put("deliveryorderremark", deliveryorderremark);
		obj.put("ordertime", ordertime);
		obj.put("acceptordertime", acceptordertime);
		obj.put("exporttime", exporttime);
		obj.put("arriveordertime",arriveordertime);
		obj.put("sellerestimatedarrivetime", sellerestimatedarrivetime);
		obj.put("completeordertime", completeordertime);
		obj.put("cancelordertime", cancelordertime);	
		return obj;
	}
}

package tw.com.ispan.eeit48.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name=" companyfollowinglist")

public class CompanyFollowingListBean {
	
	@Id	

	private Integer buyerid;
	private Integer sellerid;
	public Integer getBuyerId() {
		return buyerid;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerid = buyerId;
	}
	public Integer getSellerId() {
		return sellerid;
	}
	@Override
	public String toString() {
		return "CompanyFollowingList [buyerId=" + buyerid + ", sellerId=" + sellerid + "]";
	}
	public void setSellerId(Integer sellerId) {
		this.sellerid = sellerId;
	}
	public JSONObject toJsonObject() {
		JSONObject obj = new JSONObject();
		obj.put("buyerid", buyerid);
		obj.put("sellerid", sellerid);
		
		return obj;
	}

}

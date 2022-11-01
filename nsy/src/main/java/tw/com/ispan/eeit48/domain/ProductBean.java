package tw.com.ispan.eeit48.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name="product")
public class ProductBean {

	@Id
	private Integer productid;
	@Column(columnDefinition = "blob")
	private Byte  productpic;
	private Integer supplierid;
	private Integer productclassification;
	private Integer unitcost;
	private Integer stockqty;
	private Integer warningqty;
	@Column(columnDefinition = "char")
	private String  autoorderfunction;
	private Integer autoordertoqty;
	private Integer orderwaitinghour;
	private Integer unitsellprice;
	private Integer minsellqty;
	@Column(columnDefinition = "char")
	private String productdesc;
	private Integer onshelf;
	private Integer autoorderconfirmfunctionstatus;
	private Integer reservedqty;
	private Integer ownerid;
	@Column(columnDefinition = "char")
	private String  productnamespec;
	@Override
	public String toString() {
		return "ProductBean [productid=" + productid + ", ownerid=" + ownerid + ", productnamespec=" + productnamespec
				+ ", productpic=" + productpic + ", supplierid=" + supplierid + ", productclassification="
				+ productclassification + ", unitcost=" + unitcost + ", stockqty=" + stockqty + ", warningqty="
				+ warningqty + ", autoorderfunction=" + autoorderfunction + ", autoordertoqty=" + autoordertoqty
				+ ", orderwaitinghour=" + orderwaitinghour + ", unitsellprice=" + unitsellprice + ", minsellqty="
				+ minsellqty + ", productdesc=" + productdesc + ", onshelf=" + onshelf
				+ ", autoorderconfirmfunctionstatus=" + autoorderconfirmfunctionstatus + ", reservedqty=" + reservedqty
				+ "]";
	}
	
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(Integer ownerid) {
		this.ownerid = ownerid;
	}
	public String getProductnamespec() {
		return productnamespec;
	}
	public void setProductnamespec(String productnamespec) {
		this.productnamespec = productnamespec;
	}
	public Byte getProductpic() {
		return productpic;
	}
	public void setProductpic(Byte productpic) {
		this.productpic = productpic;
	}
	public Integer getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(Integer supplierid) {
		this.supplierid = supplierid;
	}
	public Integer getProductclassification() {
		return productclassification;
	}
	public void setProductclassification(Integer productclassification) {
		this.productclassification = productclassification;
	}
	public Integer getUnitcost() {
		return unitcost;
	}
	public void setUnitcost(Integer unitcost) {
		this.unitcost = unitcost;
	}
	public Integer getStockqty() {
		return stockqty;
	}
	public void setStockqty(Integer stockqty) {
		this.stockqty = stockqty;
	}
	public Integer getWarningqty() {
		return warningqty;
	}
	public void setWarningqty(Integer warningqty) {
		this.warningqty = warningqty;
	}
	public String getAutoorderfunction() {
		return autoorderfunction;
	}
	public void setAutoorderfunction(String autoorderfunction) {
		this.autoorderfunction = autoorderfunction;
	}
	public Integer getAutoordertoqty() {
		return autoordertoqty;
	}
	public void setAutoordertoqty(Integer autoordertoqty) {
		this.autoordertoqty = autoordertoqty;
	}
	public Integer getOrderwaitinghour() {
		return orderwaitinghour;
	}
	public void setOrderwaitinghour(Integer orderwaitinghour) {
		this.orderwaitinghour = orderwaitinghour;
	}
	public Integer getUnitsellprice() {
		return unitsellprice;
	}
	public void setUnitsellprice(Integer unitsellprice) {
		this.unitsellprice = unitsellprice;
	}
	public Integer getMinsellqty() {
		return minsellqty;
	}
	public void setMinsellqty(Integer minsellqty) {
		this.minsellqty = minsellqty;
	}
	public String getProductdesc() {
		return productdesc;
	}
	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
	public Integer getOnshelf() {
		return onshelf;
	}
	public void setOnshelf(Integer onshelf) {
		this.onshelf = onshelf;
	}
	public Integer getAutoorderconfirmfunctionstatus() {
		return autoorderconfirmfunctionstatus;
	}
	public void setAutoorderconfirmfunctionstatus(Integer autoorderconfirmfunctionstatus) {
		this.autoorderconfirmfunctionstatus = autoorderconfirmfunctionstatus;
	}
	public Integer getReservedqty() {
		return reservedqty;
	}
	public void setReservedqty(Integer reservedqty) {
		this.reservedqty = reservedqty;
	}
	
	
	public JSONObject toJsonObject() {
		JSONObject obj = new JSONObject();
		obj.put("productid", productid);
		obj.put("productpic", productpic);
		obj.put("supplierid", supplierid);
		obj.put("productclassification", productclassification);
		obj.put("unitcost", unitcost);
		obj.put("stockqty", stockqty);
		obj.put("warningqty", warningqty);
		obj.put("autoorderfunction", autoorderfunction);
		obj.put("autoordertoqty", autoordertoqty);
		obj.put("orderwaitinghour", orderwaitinghour);
		obj.put("unitsellprice", unitsellprice);
		obj.put("minsellqty", minsellqty);
		obj.put("productdesc", productdesc);
		obj.put("onshelf", onshelf);
		obj.put("autoorderconfirmfunctionstatus", autoorderconfirmfunctionstatus);
		obj.put("reservedqty", reservedqty);
		obj.put("ownerid", ownerid);
		obj.put("productnamespec", productnamespec);
		return obj;
	}
}

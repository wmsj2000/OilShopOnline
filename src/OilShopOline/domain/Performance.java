package OilShopOline.domain;

public class Performance {
	private java.sql.Date order_date;
	private java.sql.Time order_time;
	private String seller_name;
	private int order_id;
	private int oil_id;
	private String oil_brand;
	private String oil_category;
	private String oil_craft;
	private String oil_rank;
	private double oil_capacity;
	private double oil_price;
	private int order_number;
	private String order_abnormal_info;
	public java.sql.Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(java.sql.Date order_date) {
		this.order_date = order_date;
	}
	public java.sql.Time getOrder_time() {
		return order_time;
	}
	public void setOrder_time(java.sql.Time order_time) {
		this.order_time = order_time;
	}
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getOil_id() {
		return oil_id;
	}
	public void setOil_id(int oil_id) {
		this.oil_id = oil_id;
	}
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	public String getOrder_abnormal_info() {
		return order_abnormal_info;
	}
	public void setOrder_abnormal_info(String order_abnormal_info) {
		this.order_abnormal_info = order_abnormal_info;
	}
	public double getOil_price() {
		return oil_price;
	}
	public void setOil_price(double oil_price) {
		this.oil_price = oil_price;
	}
	public double getOil_capacity() {
		return oil_capacity;
	}
	public void setOil_capacity(double oil_capacity) {
		this.oil_capacity = oil_capacity;
	}
	public String getOil_rank() {
		return oil_rank;
	}
	public void setOil_rank(String oil_rank) {
		this.oil_rank = oil_rank;
	}
	public String getOil_craft() {
		return oil_craft;
	}
	public void setOil_craft(String oil_craft) {
		this.oil_craft = oil_craft;
	}
	public String getOil_category() {
		return oil_category;
	}
	public void setOil_category(String oil_category) {
		this.oil_category = oil_category;
	}
	public String getOil_brand() {
		return oil_brand;
	}
	public void setOil_brand(String oil_brand) {
		this.oil_brand = oil_brand;
	}
}

package OilShopOline.domain;

public class Orders {
	private int order_id;
	private String customer_name;
	private int oil_id;
	private java.sql.Date order_date;
	private java.sql.Time order_time;
	private int order_number;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
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
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	public int getOil_id() {
		return oil_id;
	}
	public void setOil_id(int oil_id) {
		this.oil_id = oil_id;
	}
}

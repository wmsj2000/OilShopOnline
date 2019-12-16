package OilShopOline.domain;

public class Cart {
	private int cart_id;
	private String customer_name;
	private int computer_id;
	private java.sql.Date cart_date;
	private java.sql.Time cart_time;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getComputer_id() {
		return computer_id;
	}
	public void setComputer_id(int computer_id) {
		this.computer_id = computer_id;
	}
	public java.sql.Date getCart_date() {
		return cart_date;
	}
	public void setCart_date(java.sql.Date cart_date) {
		this.cart_date = cart_date;
	}
	public java.sql.Time getCart_time() {
		return cart_time;
	}
	public void setCart_time(java.sql.Time cart_time) {
		this.cart_time = cart_time;
	}
}

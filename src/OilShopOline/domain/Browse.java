package OilShopOline.domain;

public class Browse {
	private int browse_id;
	private String customer_name;
	private int oil_id;
	private java.sql.Date browse_start_date;
	private java.sql.Time browse_start_time;
	private java.sql.Date browse_end_date;
	private java.sql.Time browse_end_time;
	public int getBrowse_id() {
		return browse_id;
	}
	public void setBrowse_id(int browse_id) {
		this.browse_id = browse_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getOil_id() {
		return oil_id;
	}
	public void setOil_id(int oil_id) {
		this.oil_id = oil_id;
	}
	public java.sql.Date getBrowse_start_date() {
		return browse_start_date;
	}
	public void setBrowse_start_date(java.sql.Date browse_start_date) {
		this.browse_start_date = browse_start_date;
	}
	public java.sql.Time getBrowse_start_time() {
		return browse_start_time;
	}
	public void setBrowse_start_time(java.sql.Time browse_start_time) {
		this.browse_start_time = browse_start_time;
	}
	public java.sql.Date getBrowse_end_date() {
		return browse_end_date;
	}
	public void setBrowse_end_date(java.sql.Date browse_end_date) {
		this.browse_end_date = browse_end_date;
	}
	public java.sql.Time getBrowse_end_time() {
		return browse_end_time;
	}
	public void setBrowse_end_time(java.sql.Time browse_end_time) {
		this.browse_end_time = browse_end_time;
	}
	
}

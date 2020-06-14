package OilShopOline.domain;

public class Lp {
	private int lp_id;
	private String role;
	private String name;
	private String ip;
	private java.sql.Date login_date;
	private java.sql.Time login_time;
	private java.sql.Date logout_date;
	private java.sql.Time logout_time;
	public int getLp_id() {
		return lp_id;
	}
	public void setLp_id(int lp_id) {
		this.lp_id = lp_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public java.sql.Date getLogin_date() {
		return login_date;
	}
	public void setLogin_date(java.sql.Date login_date) {
		this.login_date = login_date;
	}
	public java.sql.Time getLogin_time() {
		return login_time;
	}
	public void setLogin_time(java.sql.Time login_time) {
		this.login_time = login_time;
	}
	public java.sql.Date getLogout_date() {
		return logout_date;
	}
	public void setLogout_date(java.sql.Date logout_date) {
		this.logout_date = logout_date;
	}
	public java.sql.Time getLogout_time() {
		return logout_time;
	}
	public void setLogout_time(java.sql.Time logout_time) {
		this.logout_time = logout_time;
	}
}

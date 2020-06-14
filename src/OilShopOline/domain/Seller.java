package OilShopOline.domain;

public class Seller {
	private String seller_name;
	private String seller_email;
	private String seller_password;
	private String seller_brand;
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public String getSeller_email() {
		return seller_email;
	}
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}
	public String getSeller_brand() {
		return seller_brand;
	}
	public void setSeller_brand(String seller_brand) {
		this.seller_brand = seller_brand;
	}
	public String getSeller_password() {
		return seller_password;
	}
	public void setSeller_password(String seller_password) {
		this.seller_password = seller_password;
	}
}

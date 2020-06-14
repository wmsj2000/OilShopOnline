package OilShopOline.domain;

public class Similarity {
	private double similarity;
	private String customer_name;
	private String similar_customer_name;
	public double getSimilarity() {
		return similarity;
	}
	public void setSimilarity(double similarity) {
		this.similarity = similarity;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getSimilar_customer_name() {
		return similar_customer_name;
	}
	public void setSimilar_customer_name(String similar_customer_name) {
		this.similar_customer_name = similar_customer_name;
	}

}

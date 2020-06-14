package OilShopOline;

import OilShopOline.dao.AdminDao;
import OilShopOline.domain.Portrait;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComputeSimilarity {
	private AdminDao adao = new AdminDao();
	public HashMap<String, List<Double>> getVectors() {
		List<Portrait> portraits = adao.showPortrait("");
		List<String> index = new ArrayList<String>();
		HashMap<String, List<Double>> user_vectors = new HashMap<String, List<Double>>();
		for(Portrait p:portraits) {
			if(index.contains(p.getOil_brand())==false) {
				index.add(p.getOil_brand());
			}
			if(index.contains(p.getOil_category())==false) {
				index.add(p.getOil_category());
			}
			if(index.contains(p.getOil_craft())==false) {
				index.add(p.getOil_craft());
			}
			if(index.contains(p.getOil_rank())==false) {
				index.add(p.getOil_rank());
			}
		}
		for(Portrait p:portraits) {
			List<Double> vector = new ArrayList<Double>();
			for(String in:index) {
				if(p.getOil_brand().equals(in)) vector.add((double)p.getCount_brand());
				else if(p.getOil_category().equals(in)) vector.add((double)p.getCount_category());
				else if(p.getOil_craft().equals(in)) vector.add((double)p.getCount_craft());
				else if(p.getOil_rank().equals(in)) vector.add((double)p.getCount_rank());
				else vector.add((double) 0);
			}
			double sum=0;
			for(double v:vector) {
				sum=sum+v;
			}
			for(double v:vector) {
				v=v/sum;
			}
			user_vectors.put(p.getCustomer_name(), vector);
		}
		
		return user_vectors;
	}
	public void computeSimilarity() {
		HashMap<String, List<Double>> user_vectors = getVectors();
		 System.out.println(user_vectors);
		 System.out.println(user_vectors.keySet());
		for(String cname:user_vectors.keySet()) {
			List<Double> v1 = user_vectors.get(cname);
			double similarity = 0;
			String name = new String();
			for(String cname2:user_vectors.keySet()) {
				if(!cname.equals(cname2)) { 
				List<Double> v2 = user_vectors.get(cname2);
				double n1=0,n2=0,n3=0;
				for(int i=0;i<v2.size();i++) {
					n1=n1+v1.get(i)*v2.get(i);
				}
				for(int i=0;i<v2.size();i++) {
					n2=n2+v1.get(i)*v1.get(i);
				}
				for(int i=0;i<v2.size();i++) {
					n3=n3+v2.get(i)*v2.get(i);
				}
				n2=Math.sqrt(n2);
				n3=Math.sqrt(n3);
				double cos=n1/(n2*n3);
				if(similarity<cos) {
					similarity=cos;
					name=cname2;
				}
			}
			}
			adao.setSimilarity(cname,name,similarity);
		}
	}
}

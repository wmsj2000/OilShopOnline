package OilShopOline.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import OilShopOline.domain.Oil;
import OilShopOline.domain.Orders;
import OilShopOline.utils.DataSourceUtils;




public class OilDao {

	public void AddOil(String oil_brand, String oil_category, String oil_craft, String oil_rank, String oil_capacity,
			String oil_price, String oil_number, String oil_state) {
		try{
			double capacity=Double.parseDouble(oil_capacity);
			double price=Double.parseDouble(oil_price);
			int number=Integer.parseInt(oil_number);
			boolean state=Boolean.parseBoolean(oil_state);
			String sql = "insert into oil(oil_brand,oil_category,oil_craft,oil_rank,oil_capacity, oil_price, oil_number,oil_state) "
					+ "values(?,?,?,?,?,?,?,?)";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql,oil_brand,oil_category,oil_craft,oil_rank,capacity, price, number,state);
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("AddOil dao ß∞‹");
		}
	}

	public int CheckOil(String oil_brand, String oil_category, String oil_craft, String oil_rank, String oil_capacity,
			String oil_price, String oil_state) {
		try{
			double capacity=Double.parseDouble(oil_capacity);
			double price=Double.parseDouble(oil_price);
			String sql = "select ifnull((select  1  from oil where oil_brand=? and oil_category=? and oil_craft=? and oil_rank=? and oil_capacity=? and oil_price=? limit 1), 0)";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			long t = (long) runner.query(sql, new ScalarHandler(),oil_brand,oil_category,oil_craft,oil_rank,capacity,price);
			if(t==1) {return 1;}
			return 0;
		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("AddOil dao ß∞‹");
		}
	}

	public void AddOilNumber(String oil_brand, String oil_category, String oil_craft, String oil_rank,
			String oil_capacity, String oil_price, String oil_number, String oil_state) {
		try{
			double capacity=Double.parseDouble(oil_capacity);
			double price=Double.parseDouble(oil_price);
			int number=Integer.parseInt(oil_number);
			String sql = "update oil set oil_number=oil_number+?  where oil_brand=? and oil_category=? and oil_craft=? and oil_rank=? and oil_capacity=? and oil_price=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql, number,oil_brand,oil_category,oil_craft,oil_rank,capacity,price);

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("AddOil dao ß∞‹");
		}
	}

	public List<Oil> findAllOil() {
		try{
			String sql = "select * from oil";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Oil>(Oil.class));

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("findAllOil dao ß∞‹");
		}
	}

	public List<Oil> findOilByManyCondition(String oil_id, String oil_brand, String oil_category, String oil_craft,
			String oil_rank, String oil_capacity, String oil_price1, String oil_price2, String oil_number1,
			String oil_number2, String oil_state) {
		try{List<Object> list = new ArrayList<Object>();
		String sql = "select * from oil where 1=1 ";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		if ( oil_id != null && oil_id.trim().length() > 0) {
			sql += " and oil_id=?";
			list.add(Integer.parseInt(oil_id));
		}

		if (oil_brand != null && oil_brand.trim().length() > 0) {
			sql += " and oil_brand=?";
			list.add(oil_brand);
		}
		if (oil_category != null && oil_category.trim().length() > 0) {
			sql += " and oil_category=?";
			list.add(oil_category);
		}
		if (oil_craft != null && oil_craft.trim().length() > 0) {
			sql += " and oil_craft=?";
			list.add(oil_craft);
			
		}
		if (oil_rank != null && oil_rank.trim().length() > 0) {
			sql += " and oil_rank=?";
			list.add(oil_rank);
			
		}
		if (oil_capacity != null && oil_capacity.trim().length() > 0) {
			sql += " and oil_capacity=?";
			list.add(Double.parseDouble(oil_capacity));	
		}
		if (oil_price1 != null && oil_price1.trim().length() > 0&&oil_price2 != null && oil_price2.trim().length() > 0) {
			sql += " and oil_price between ? and ?";
			list.add(Double.parseDouble(oil_price1));	
			list.add(Double.parseDouble(oil_price2));
		}
		if (oil_number1 != null && oil_number1.trim().length() > 0&&oil_number2 != null && oil_number2.trim().length() > 0) {
			sql += " and oil_number between ? and ?";
			list.add(Double.parseDouble(oil_number1));	
			list.add(Double.parseDouble(oil_number2));
		}
		if (oil_state != null && oil_state.trim().length() > 0) {
			sql += " and oil_state=?";
			list.add(Boolean.parseBoolean(oil_state));	
		}
		

		Object[] params = list.toArray();

		return runner.query(sql, new BeanListHandler<Oil>(Oil.class),
				params);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("∂‡Ãıº˛≤È—Ødao ß∞‹");
		}
	}

	public void RemoveOil(String oil_id) {
		try{
			String sql = "update oil set oil_state=0 where oil_id=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql,oil_id);

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("RemoveOil dao ß∞‹");
		}
	}

	public void updateOil(String oil_id, String oil_brand, String oil_category, String oil_craft, String oil_rank,
			String oil_capacity, String oil_price, String oil_number, String oil_state) {
		try{
			
			double capacity=Double.parseDouble(oil_capacity);
			double price=Double.parseDouble(oil_price);
			int number=Integer.parseInt(oil_number);
			int id=Integer.parseInt(oil_id);
			boolean state = Boolean.parseBoolean(oil_state);
			String sql = "update oil set oil_brand=?,oil_category=?,oil_craft=?,oil_rank=?,oil_capacity=?,oil_price=?,oil_number=?,oil_state=? where oil_id=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql, oil_brand,oil_category, oil_craft, oil_rank,
					 capacity,price,number, state,id);

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("updateOil dao ß∞‹");
		}
	}

	public List<Oil> CustomerfindAllOil() {
		try{
			String sql = "select * from oil where oil_state=1 and oil_number>0";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Oil>(Oil.class));

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("findAllOil dao ß∞‹");
		}
	}

	public List<Oil> findCartById(String customer_name) {
		try{
			String sql = "select * from oil where oil.oil_id in (select cart.oil_id from cart where cart.customer_name=?)";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Oil>(Oil.class),customer_name);

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("findAllOil dao ß∞‹");
		}
	}

	public void RemoveOilFormCart(String customer_name, String oil_id) {
		try{
			String sql = "delete from cart where oil_id=? and customer_name=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql,oil_id,customer_name);
		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("RemoveOilFormCart dao ß∞‹");
		}
	}

	public List<Oil> findOrdersByName(String customer_name) {
		try{
			String sql = "select oil.oil_id,oil.oil_brand,oil_category,oil_craft,oil_rank,oil_capacity,oil_price,oil_number,oil_state from oil,orders where oil.oil_id=orders.oil_id and orders.customer_name=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Oil>(Oil.class),customer_name);

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("findOrdersByName dao ß∞‹");
		}
	}

	public List<Orders> findNumbersByName(String customer_name) {
		try{
			String sql = "select * from orders where customer_name=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return  runner.query(sql,new BeanListHandler<Orders>(Orders.class),customer_name);

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("findNumbersByName dao ß∞‹");
		}
	}

	public List<Oil> findOils() {
		try{
			String sql = "select oil.oil_id,oil.oil_brand,oil_category,oil_craft,oil_rank,oil_capacity,oil_price,oil_number,oil_state from oil where oil.oil_id in(select orders.oil_id from orders) order by oil_id";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Oil>(Oil.class));

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("findOils dao ß∞‹");
		}
	}

	/*public List<Integer> findNumbers() {
		try{
			String sql = "select sum(orders.order_number) from orders group by oil_id order by oil_id asc";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql, new ArrayHandler<Integer>(Integer.class));

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("findNumbers dao ß∞‹");
		}
	}*/

	public int getTotalMoney() {
		try{
			String sql = "CREATE VIEW money(money) AS SELECT £®orders.order_number*oil_price£© FROM oil£¨order where orders_oil_id=oil.oil_id;"
					+ "select sum(money) from money;";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return (int) runner.query(sql, new ScalarHandler());

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("getTotalMoney dao ß∞‹");
		}
	}

	public List<Oil> findOilBySeller(String seller_name) {
		try{
			String sql = "select seller_brand from seller where seller_name=?";
			String sql2 = "select * from oil where oil.oil_brand=? order by oil.oil_id";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String brand = (String) runner.query(sql,new ScalarHandler(),seller_name);
			return runner.query(sql2, new BeanListHandler<Oil>(Oil.class),brand);

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("findOilBySeller dao ß∞‹");
		}
	}

	public List<Oil> recommend(String customer_name) {
		try{
			String sql0 = "select similar_customer_name from similarity where customer_name=?";
			String sql = "select oil.oil_id,oil.oil_brand,oil_category,oil_craft,oil_rank,oil_capacity,oil_price,oil_number,oil_state"
					+ " from oil left join orders on orders.oil_id=oil.oil_id "
					+ "where orders.customer_name=? order by orders.order_date,orders.order_date limit 10";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String name=(String) runner.query(sql0, new ScalarHandler(),customer_name);
			if(name.length()>0) {
				return runner.query(sql, new BeanListHandler<Oil>(Oil.class),name);
			}
			else return null;

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("recommend dao ß∞‹");
		}
	}

	
	

}

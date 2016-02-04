package _09_order.model;

import java.util.List;

import org.hibernate.Session;

public interface Order_InterfaceDAO {

	Session getSession();

	OrderVO findByPrimaryKey(Integer order_id);

	void insert(OrderVO orderVO);

	void update(OrderVO orderVO);

	void delete(Integer order_id);

	List<OrderVO> selectAll();

}
package _09_order.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.util.HibernateUtil;

public class OrderDAO implements Order_InterfaceDAO {
	private SessionFactory sessionFactory;
	public OrderDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public Session getSession() {
		if(sessionFactory!=null) {
			return sessionFactory.getCurrentSession();
		}
		return null;
	}
	
	@Override
	public OrderVO findByPrimaryKey(Integer order_id) {
		OrderVO orderVO = null;
		orderVO = (OrderVO) getSession().get(OrderVO.class, order_id);
		return orderVO;
	}
	
	@Override
	public void insert(OrderVO orderVO) {
			getSession().saveOrUpdate(orderVO);
	}

	@Override
	public void update(OrderVO orderVO) {
			getSession().saveOrUpdate(orderVO);;
		
	}

	@Override
	public void delete(Integer order_id) {	
			OrderVO orderVO = new OrderVO();
			orderVO.setOrder_id(order_id);
			getSession().delete(orderVO);		
	}

	private static final String GET_ALL_STMT= "from OrderVO order by order_id";
	
	@Override
	public List<OrderVO> selectAll() {
		List<OrderVO> list = null;
			Query query = getSession().createQuery(GET_ALL_STMT);
			list = query.list();
		return list;
	}


	public static void main(String[] args) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Order_InterfaceDAO dao = new OrderDAO();
			
			try {
				session.beginTransaction(); 	

//select	
//			OrderVO bean = dao.findByPrimaryKey(1);
//			System.out.println(bean);
			
//insert  
//			OrderVO orderVO = new OrderVO();
//			MemberVO memberVO = new MemberVO();
//			GuestVO guestVO = new GuestVO();
//			RoomVO roomVO = new RoomVO();
//			memberVO.setMember_account("da");
//			orderVO.setMember_account(memberVO);
//			guestVO.setGuest_id(3);
//			orderVO.setGuest_id(guestVO);
//			orderVO.setRoom_type("Double");
//			roomVO.setRoom_id(301);
//			orderVO.setRoom_id(roomVO);
//			orderVO.setCheckin_date(java.sql.Date.valueOf("2016-1-30"));
//			orderVO.setCheckout_date(java.sql.Date.valueOf("2016-2-6"));
//			orderVO.setAdults(3);
//			orderVO.setTotal_payment(6666);
//			orderVO.setNote("加一床");
//			orderVO.setBook_date(new java.util.Date());			
//			dao.insert(orderVO);
//			System.out.println(orderVO.getNote());
//			System.out.println(orderVO);	//溢位		

//update  
//			OrderVO orderVO = new OrderVO();
//			MemberVO memberVO = new MemberVO();
//			GuestVO guestVO = new GuestVO();
//			RoomVO roomVO = new RoomVO();
//			orderVO.setOrder_id(2);
//			memberVO.setMember_account("da");
//			orderVO.setMember_account(memberVO);
//			guestVO.setGuest_id(3);
//			orderVO.setGuest_id(guestVO);
//			orderVO.setRoom_type("Double");
//			roomVO.setRoom_id(301);
//			orderVO.setRoom_id(roomVO);
//			orderVO.setAdults(3);
//			orderVO.setTotal_payment(6666);
//			orderVO.setNote("加100床");
//			dao.update(orderVO);
//			System.out.println("修改的訂單編號：" + orderVO.getOrder_id());
			
//delete  //fac_detail會同時執行update，當有共同的order_id時，會變成orderid=null，失敗
//			dao.delete(6);
			
//selectAll
//			List<OrderVO> beans = dao.selectAll();
//			System.out.println(beans);
				
				
				session.getTransaction().commit();
			} catch (RuntimeException ex) {
				session.getTransaction().rollback();
				throw ex;
			}
		}

}

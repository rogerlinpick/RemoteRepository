package _08_notice.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.util.HibernateUtil;

public class NoticeDAO implements Notice_InterfaceDAO {
	private SessionFactory sessionFactory;
	public NoticeDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	public Session getSession() {
		if(sessionFactory!=null) {
			return sessionFactory.getCurrentSession();
		}
		return null;
	}
	
	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			Notice_InterfaceDAO dao = new NoticeDAO();
	//select		
			NoticeVO bean = dao.select(1);
			System.out.println(bean);
	//insert
//			NoticeVO vo = new NoticeVO();
//		    
//			vo.setTitle("皞急偌皜豢陶瘙�");
//			vo.setStartdate(new java.util.Date());
//			vo.setEnddate(null);
//			vo.setContent("閰唾��");
//			dao.insert(vo);
	//update
//			NoticeVO up = dao.update(1, "皜祈岫", new java.util.Date(), new java.util.Date(), "皜祈岫");
			
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
		

	}
	@Override
	public NoticeVO select(Integer noticeId) {
		
		return (NoticeVO) getSession().get(NoticeVO.class, noticeId);
	}
	
	
	@Override
	public void insert(NoticeVO bean) {
//		NoticeVO temp = (NoticeVO) this.getSession().get(NoticeVO.class, bean.getNoticeId());
//		if(temp==null) {
//			this.getSession().save(bean);
//		}
//		return bean;
		
		  Session session = HibernateUtil.getSessionFactory().getCurrentSession();	
		  session.save(bean); 
		  return;
		
	}	
	@Override
	public NoticeVO update(Integer noticeId, String title, Date startdate, Date enddate, String content) {
		NoticeVO bean = (NoticeVO) getSession().get(NoticeVO.class, noticeId);
		if(bean!=null){
			bean.setNoticeId(noticeId);
			bean.setTitle(title);
			bean.setStartdate(startdate);
			bean.setEnddate(enddate);
			bean.setContent(content);
		}
		return null;
	}




}

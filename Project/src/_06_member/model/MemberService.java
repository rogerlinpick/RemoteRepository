package _06_member.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.util.HibernateUtil;

public class MemberService {
	MemberDAO memberDAO = new MemberDAO();
	private SessionFactory sessionFactory ;		

	public MemberService(){
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public Session getSession(){
		if(sessionFactory != null){
			return sessionFactory.getCurrentSession();			
		}
		return null;
	}	
	
	public static void main(String []args){	
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();		
		
		MemberService service = new MemberService();
		
		MemberVO bean = new MemberVO();
		bean.setMember_account("Mary");	
		bean.setPassword("password");
		bean.setMember_last_name("last name");
		bean.setMember_first_name("first name");
		bean.setGender("male");
		bean.setId_number("idnumber");
		bean.setCredit_card("132456798");
		bean.setBirthday( new java.util.Date());
		bean.setTel("56456484684498");
		bean.setPhone_number("02-21578742");
		bean.setAddress("America");
		bean.setReg_date(new java.util.Date());
//		MemberVO bean = service.login("da", "ds");
//		System.out.println(bean);
		
//		service.update(bean);
//		service.delete("Mary");
		
		
		session.getTransaction().commit();
	}
	
	public MemberVO login(String account,String password){
		MemberVO bean = memberDAO.select(account);
		if(bean != null){
			if(password!=null && password.trim().length()!=0){
				String pass = bean.getPassword();
				String temp = password;
				if(pass.equals(temp)){
					return bean;
				}
			}
		}
		return null;
	}
	
	public boolean update(MemberVO bean){
		boolean result=false;
		if(bean != null){
			result = memberDAO.update(bean);
		}
		return result;
	}
	
	public boolean delete(String account){
		MemberVO bean = memberDAO.select(account);
		if(bean!=null){
			int i = memberDAO.delete(account);
			if(i==1){
				return true;
			}
		}		
		return false;
	}
}

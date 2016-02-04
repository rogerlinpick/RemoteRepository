package _13_roomtype.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;

public class RoomTypeDAO implements RoomTypeDAO_interface {
	private Session session;
	private String GET_ALL_STMT = "from RoomTypeVO order by roomType_id";

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		RoomTypeDAO roomTypeDAO = new RoomTypeDAO(session);
		List<RoomTypeVO> list = roomTypeDAO.getAll();
		// RoomVO packageBean=(RoomVO)session.get(RoomVO.class,101 );
		for(RoomTypeVO vo:list){
			System.out.println(vo);	
		}
		session.getTransaction().commit();
	}

	public RoomTypeDAO(Session session) {
		this.session = session;
	}

	@Override
	public void insert(RoomTypeVO roomTypeVO) {
		session.saveOrUpdate(roomTypeVO);
	}

	@Override
	public void update(RoomTypeVO roomTypeVO) {
		session.saveOrUpdate(roomTypeVO);
	}

	@Override
	public void delete(Integer roomType_id) {
		RoomTypeVO roomTypeVO = this.findByPrimaryKey(roomType_id);
		session.delete(roomTypeVO);
	}

	@Override
	public RoomTypeVO findByPrimaryKey(Integer roomType_id) {
		RoomTypeVO roomTypeVO = null;
		roomTypeVO = (RoomTypeVO) session.get(RoomTypeVO.class, roomType_id);
		return roomTypeVO;
	}

	@Override
	public List<RoomTypeVO> getAll() {
		List<RoomTypeVO> list = null;
		Query query = session.createQuery(GET_ALL_STMT);
		list = query.list();
		return list;
	}

}

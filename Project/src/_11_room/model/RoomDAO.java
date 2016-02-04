package _11_room.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;

public class RoomDAO implements RoomDAO_interface {
	private Session session = null;
	private String GET_ALL_STMT = "from RoomVO order by room_id";

	public static void main(String[] args) {
		System.out.println(123);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		RoomDAO roomDAO = new RoomDAO(session);
		List<RoomVO> list = roomDAO.getAll();
		// RoomVO packageBean=(RoomVO)session.get(RoomVO.class,101 );
		for(RoomVO vo:list){
			System.out.println(vo);	
		}
		session.getTransaction().commit();
	}

	public RoomDAO(Session session) {
		this.session = session;
	}

	@Override
	public void insert(RoomVO roomVO) {
		session.saveOrUpdate(roomVO);
	}

	@Override
	public void update(RoomVO roomVO) {
		session.saveOrUpdate(roomVO);
	}

	@Override
	public void delete(Integer room_id) {
		RoomVO roomVO = this.findByPrimaryKey(room_id);
		session.delete(roomVO);
	}

	@Override
	public RoomVO findByPrimaryKey(Integer room_id) {
		RoomVO roomVO = null;
		roomVO = (RoomVO) session.get(RoomVO.class, room_id);
		return roomVO;
	}

	@Override
	public List<RoomVO> getAll() {
		List<RoomVO> list = null;
		Query query = session.createQuery(GET_ALL_STMT);
		list = query.list();
		return list;
	}

}

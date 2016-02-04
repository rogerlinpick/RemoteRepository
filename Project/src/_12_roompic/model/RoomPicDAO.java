package _12_roompic.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class RoomPicDAO implements RoomPicDAO_interface {
	private Session session;
	private String GET_ALL_STMT="from RoomPicVO order by roomPic_id";
	
	@Override
	public void insert(RoomPicVO roomPicVO) {
		session.saveOrUpdate(roomPicVO);
	}

	@Override
	public void update(RoomPicVO roomPicVO) {
		session.saveOrUpdate(roomPicVO);
	}

	@Override
	public void delete(Integer roomPic_id) {
		RoomPicVO roomPicVO = this.findByPrimaryKey(roomPic_id);
		session.delete(roomPicVO);
	}

	@Override
	public RoomPicVO findByPrimaryKey(Integer roomPic_id) {
		RoomPicVO roomPicVO=null;
		roomPicVO=(RoomPicVO) session.get(RoomPicVO.class, roomPic_id);
		return roomPicVO;
	}

	@Override
	public List<RoomPicVO> getAll() {
		List<RoomPicVO> list = null;
		Query query = session.createQuery(GET_ALL_STMT);
		list = query.list();
		return list;
	}

}

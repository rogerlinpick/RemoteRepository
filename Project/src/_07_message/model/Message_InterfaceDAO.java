package _07_message.model;

import java.util.List;

import org.hibernate.Session;

public interface Message_InterfaceDAO {

	Session getSession();

	MessageVO findByPrimaryKey(Integer message_id);

	void insert(MessageVO messageVO);

	void update(MessageVO messageVO);

	void delete(Integer message_id);

	List<MessageVO> selectAll();

}
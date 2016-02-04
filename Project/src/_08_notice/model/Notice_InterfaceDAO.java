package _08_notice.model;

import java.util.Date;

public interface Notice_InterfaceDAO {
	public NoticeVO select(Integer noticeId);
	public void insert(NoticeVO bean);
	public NoticeVO update(Integer noticeId, String title, Date startdate, Date enddate, String content);
}

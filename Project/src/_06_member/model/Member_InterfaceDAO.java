package _06_member.model;

public interface Member_InterfaceDAO {
	MemberVO select (String mc);
	
	int delete(String mc);
	
	MemberVO insert(MemberVO bean);				
	
	boolean update (MemberVO bean);	
	
}
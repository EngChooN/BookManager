package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ManagerDAO {
	private SqlSessionFactory sqlSessionFactory = null;
	public ManagerDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	public String search(String id) {
		String idx=null;
		SqlSession session = sqlSessionFactory.openSession();
		
		if(session.selectOne("Manager.searchId",id)==null) {
			System.out.println("�ش� id�� �������� �ʽ��ϴ�.");
		}else {
			idx = session.selectOne("Manager.searchId",id);
		}
		return idx;
	}
	public String searchPass(String pass) {
		String idx=null;
		SqlSession session = sqlSessionFactory.openSession();
		
		if(session.selectOne("Manager.searchPass",pass)==null) {
			System.out.println("�ش� password�� �������� �ʽ��ϴ�.");
		}else {
			idx = session.selectOne("Manager.searchPass", pass);
		}
		return idx;
	}

}

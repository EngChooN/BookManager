package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PlayUserDAO {
	private SqlSessionFactory sqlSessionFactory = null;

	public PlayUserDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public String searchUserId(String id) {
		String idx=null;
		SqlSession session = sqlSessionFactory.openSession();
		if(session.selectOne("PlayUser.searchPUId",id)==null) {
			System.out.println("�ش� id�� �������� �ʽ��ϴ�.");
		}else {
			idx = session.selectOne("PlayUser.searchPUId",id);
		}
		return idx;
	}
	
	public String searchUserPass(String pass) {
		String idx=null;
		SqlSession session = sqlSessionFactory.openSession();
		if(session.selectOne("PlayUser.searchPUPass",pass)==null) {
			System.out.println("�ش� password�� �������� �ʽ��ϴ�.");
		}else {
			idx = session.selectOne("PlayUser.searchPUPass",pass);
		}
		return idx;
	}
	

}

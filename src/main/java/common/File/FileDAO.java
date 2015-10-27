package common.File;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAO {
	
	@Autowired
	@Qualifier("testSession")
//	@Qualifier("scottSession")
	public SqlSessionTemplate	sql		= null;

	public void insertBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertFile(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sql.insert("file.insertFile", map);
		
	}

	public void updateHitCnt(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	public void updateBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	public void deleteBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	public Map<String, Object> selectBoardDetail(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}

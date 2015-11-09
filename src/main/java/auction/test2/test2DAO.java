package auction.test2;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class test2DAO {
	
	Logger						logger	= Logger.getLogger(this.getClass());
										
	@Autowired(required = false)
	@Qualifier("testSession")	
	// @Qualifier("scottSession")
	public SqlSessionTemplate	sql		= null;
										
	public List<test2VO> select(test2VO vo) {
		// TODO Auto-generated method stub
		logger.info("getDeptList 호출 성공");
		List<test2VO> deptList = sql.selectList("test2.test2Select", vo);
		return deptList;
	}
	
	public int userCreate(testUserVO vo) throws Exception {
		// TODO Auto-generated method stub
		logger.info("userCreate 호출 성공");
		int list = sql.insert("testUser.testUserCreate", vo);
		return list;
	}
	
	public testUserVO userLogin(testUserVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("testUser.testUserSelect", vo);
	}
	
}

package auction.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


/**
 * @author holy
 * 빈즈에 자동으로 등록됨
 * @Service 에서 사용됨
 * @Repository는 일반적으로 DAO에 사용되며 DB Exception을 DataAccessException으로 변환한다.
 */
@Repository
public class testDAO {
	
	Logger						logger	= Logger.getLogger(this.getClass());
										
	@Autowired(required = false)
	@Qualifier("testSession")//빈즈에서 등록된 id중 auctionSessiontest를 찿아서 가져옴
//	@Qualifier("scottSession")
	public SqlSessionTemplate	sql		= null;
										
	public List<testVO> select(testVO vo) {
		// TODO Auto-generated method stub
		logger.info(this.toString()+" 호출 성공");
		//맵퍼중 test 라는 네임스페이스를 가진것 안의 id=testSelect를 실행함
		List<testVO> deptList = sql.selectList("test.testSelect", vo);
		return deptList;
	}
	
}

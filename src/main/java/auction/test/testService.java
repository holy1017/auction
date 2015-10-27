package auction.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author holy
 * @Service를 적용한 Class는 비지니스 로직이 들어가는 Service로 등록이 된다.
 */
@Service
public class testService {
	
	
//	@Repository으로 지정된걸 참조함
	@Autowired
	public testDAO	dao	= null;

	public List<testVO> select(testVO vo) {
		// TODO Auto-generated method stub
		List<testVO> list = dao.select(vo);
		return list;
	}

}

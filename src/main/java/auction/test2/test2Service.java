package auction.test2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class test2Service {
	
	@Autowired
	public test2DAO	dao	= null;

	public List<test2VO> select(test2VO vo) {
		// TODO Auto-generated method stub
		List<test2VO> list = dao.select(vo);
		return list;
	}
	
	public int userCreate(testUserVO vo) throws Exception{
		// TODO Auto-generated method stub
		int list = dao.userCreate(vo);
		return list;
	}

	public testUserVO userLogin(testUserVO vo) throws Exception{
		// TODO Auto-generated method stub
		return dao.userLogin(vo);
	}

}

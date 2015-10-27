package auction.UserCreate;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
 
@Repository
public class CreateUserDAO {
	Logger						logger	= Logger.getLogger(this.getClass());
	
	@Autowired
	//@Qualifier("auctionSession")//빈즈에서 등록된 id중 auctionSessiontest를 찿아서 가져옴
	@Qualifier("auctionSession")//빈즈에서 등록된 id중 auctionSessiontest를 찿아서 가져옴
	public SqlSessionTemplate	sql		= null;
	
	public int userCreate(CreateUserVO vo) {
		// TODO Auto-generated method stub
		logger.info("userCreate 호출 성공");
		
		int list = sql.insert("createUser.UserCreate",vo);
		logger.info("userCreate 호출 성공"+list);
		
		return list;
	}

	public String UserSelect(String u_id) {
		// TODO Auto-generated method stub
		logger.info("userSelect 호출 성공"+u_id);
		String list = sql.selectOne("createUser.UserSelect",u_id);
		
		return list;
	}

	public String NickSelet(String u_nick) {
		// TODO Auto-generated method stub
		logger.info("nickSelect 호출 성공" +u_nick);
		String list = sql.selectOne("createUser.NickSelect", u_nick);
		return list;
	}
}

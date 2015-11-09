package auction.login;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import auction.vo.UserVO;
@Repository
public class LoginDAO {
	@Autowired
	@Qualifier("auctionSession")
//	@Qualifier("scottSession")
	public SqlSessionTemplate	sql		= null;
	public UserVO userLogin(UserVO vo) {
		// TODO Auto-generated method stub
		return sql.selectOne("User.SelectOne", vo);
	}

}

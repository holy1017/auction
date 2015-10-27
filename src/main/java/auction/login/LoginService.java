package auction.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auction.test2.test2DAO;
import auction.vo.UserVO;
@Service
public class LoginService {
	@Autowired
	public LoginDAO	dao	= null;
	public UserVO userLogin(UserVO vo)  throws Exception{
		// TODO Auto-generated method stub
		return dao.userLogin(vo);
	}

}

package auction.UserCreate;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateUserService {
	Logger logger = Logger.getLogger(CreateUserService.class);
	
	@Autowired
	private CreateUserDAO createUserDAO = null;
	public String UserSelect(String u_id){
		String list = createUserDAO.UserSelect(u_id);
		
		return list;
	}
	
	public int createUser(CreateUserVO vo){
		int list = createUserDAO.userCreate(vo);
		return list;
	}

	public String NickSelect(String u_nick) {
		// TODO Auto-generated method stub
		String list = createUserDAO.NickSelet(u_nick);
		return list;
	}
}

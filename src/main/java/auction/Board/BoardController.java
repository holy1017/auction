package auction.Board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import auction.vo.BoardVO;
import auction.vo.UserVO;
import common.Paging;

/**
 * Handles requests for the application home page.
 * 테스트용.
 * 빈즈에 자동으로 등록됨.
 * spring MVC의 Controller 클래스 선언을 단순화시켜준다. 스프링 컨트롤러,
 * 서블릿을 상속할 필요가 없으며, @Controller로 등록된 클래스 파일에 대한 bean을 자동으로 생성해준다.
 * Controller로 사용하고자 하는 클래스에 @Controller 지정해 주면 component-scan으로 자동 등록된다.
 */
@Controller
public class BoardController {
	
	private static final Logger	log	= LoggerFactory.getLogger(BoardController.class);
									
	/*
	 * @Controller 안에 있는 @Autowired는
	 * 
	 * @Service로 지정된걸 참조함
	 */
	@Autowired
	public BoardService			svc	= null;
									
	/* 다중지정 가능 */
	// @RequestMapping(value={"/addMovie.do", "/updateMovie.do" })
	/* 메소드 종류 */
	// @RequestMapping(method = RequestMethod.GET)
	/* 파라메터값 */
	// @RequestMapping(params = {"param1=a", "param2", "!myParam"})
	/* <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"> 의 테그값을 참조하는 예제 */
	// @RequestMapping(value="/movie.do", headers="content-type=text/*")
	@RequestMapping(value = "/BoardForm.ac", method = RequestMethod.POST)
	public String BoardForm(@ModelAttribute("Paging") Paging paging, Model model, HttpServletRequest req,
	        HttpServletResponse res) {
		log.debug("BoardForm ok");
		
		int totalCount = svc.selectTotalCount();
		
		int PageNo = 1;
		int PageSize = 10;
		
		try {
			PageNo = Integer.parseInt(req.getParameter("PageNo"));
		} catch (Exception e) {
			// TODO: handle exception
			log.debug(e.getMessage());
		}
		try {
			PageSize = Integer.parseInt(req.getParameter("PageSize"));
		} catch (Exception e) {
			// TODO: handle exception
			log.debug(e.getMessage());
		}
		if (paging == null) {
			paging = new Paging();
		}
		log.debug("paging:" + paging);
		log.debug("PageNo:" + PageNo);
		log.debug("PageSize:" + PageSize);
		paging.setPageNo(PageNo);
		paging.setPageSize(PageSize);
		paging.setTotalCount(totalCount);
		
		List<BoardVO> list = svc.selectLast(paging);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		// model.addAttribute("PageNo", paging.getPageNo());
		// model.addAttribute("PageSize", paging.getPageSize());
		// model.addAttribute("totalCount", totalCount);
		
		log.debug("BoardForm return ok");
		return "BoardForm";
	}
	
	@RequestMapping(value = "/boardInsert.ac", method = RequestMethod.POST)
	public String boardInsert(HttpServletRequest req, HttpServletResponse res, @ModelAttribute("Paging") Paging paging,
	        HttpSession session, Model model,@ModelAttribute("id") String id ,@ModelAttribute("BoardVO") BoardVO vo, RedirectAttributes redirectAttr) {
		log.info("boardInsert 호출 성공 :" + vo);
		
		UserVO userInfo = (UserVO) session.getAttribute("userInfo");
		
		vo.setU_no(userInfo.getU_no());
		
		int result = svc.boardInsert(vo);
		
		redirectAttr.addFlashAttribute("result", result);
		
		model.addAttribute("result", result);
		
		log.info("boardInsert 호출 성공 :" + vo);
		
		return BoardForm(paging, model, req, res);
	}
	
	
}

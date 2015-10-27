package common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import auction.test.testVO;

/**
 * Handles requests for the application home page.
 * 모든 주소 반응용
 */
@Controller
public class HomeController {
	
	private static final Logger log = Logger.getLogger("auction");
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * 기본으로 설정된 index.jsp와 컨트롤의 매핑을 제외한 모든 주소에 반응
	 */
	@RequestMapping(value = "/{value}.ac")
	public String home(Locale locale, Model model, HttpServletRequest req, @PathVariable String value) {
		log.info("HomeController " + locale + "."+value);

		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
		String strDate = dateFormat1.format(Calendar.getInstance().getTime());
		log.info("strDate:" + strDate);
//		 INSERT INTO tableName
//		 column Name
//		 VALUES
//		  ( TO_DATE(#strDate# , 'yyyy/mm/dd hh24:mi:ss') )
		
		//SELECT TO_CHAR(SYSDATE, 'YYYYMMDDHHmmss') as curDate FROM dual
		//SELECT TO_CHAR(TO_DATE('201111031452','YYYYMMDDHH24MISS'),'YYYY.MM.DD') FROM DUAL
		
		//String to Date
		String from = "2013-04-08 10:10:10";
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date to = transFormat.parse(from);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("msg", "POST 방식이 아니고 /*.ac 가 아닐경우 이 메소드 작동:"+value+":"+locale);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("url", req.getRequestURL());
		model.addAttribute("classnm", this.toString());
		model.addAttribute("method", req.getMethod());
		return "home";
	}
	
	/** 에러 페이지용
	 * @param model
	 * @param vo
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/errer.ac")
	public String errer(ModelMap model, @ModelAttribute("testVO") testVO vo, HttpServletRequest req, HttpServletResponse res) {
		
		//고민중..
		String test1 = req.getParameter("test");
		log.info("errer! " + test1 + "");
		req.setAttribute("test2", test1);
		
		return "errer";
	}
}

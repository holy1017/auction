package common;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import auction.InsertItem.UtilsFile;

/**
 * Handles requests for the application home page.
 * @author holy
 * 기본 컨트롤러
 * 이 컨트로러를 복사해서 쓰기.
 * 이름바꾸기로 사용하면 안됨!!
 * 꼭 복사로!
 */
@Controller
public class commonController {
	
	private static final Logger log = Logger.getLogger("auction");
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * POST 방식이고 /*.ac 일경우 이 메소드 작동
	 * @param locale
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/*.ac", method = RequestMethod.POST)
	public String home(Locale locale, Model model, HttpServletRequest req) {
		log.debug("commonController "+locale+".");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("msg", "POST 방식이고 /*.ac 일경우 이 메소드 작동");
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("url", req.getRequestURL());
		model.addAttribute("classnm", this.toString());
		model.addAttribute("method", req.getMethod());
		return "home";
	}
	
	//@Resource(name = "commonService")
	//private CommonService commonService;

	@Resource(name = "UtilsFile")
	private UtilsFile fileUtils;
	
	@RequestMapping(value = "upload/{file:.+}")
	public void downloadFile(CommandMap commandMap, HttpServletResponse response,@PathVariable String file) throws Exception {
		//Map<String, Object> map = commonService.selectFileInfo(commandMap.getMap());
		//String storedFileName = (String) map.get("STORED_FILE_NAME");
		//String originalFileName = (String) map.get("ORIGINAL_FILE_NAME");

		fileUtils.readFile(response, file, file);
	}
}

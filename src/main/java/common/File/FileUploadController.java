package common.File;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import common.CommandMap;

/**
 * Handles requests for the application home page.
 * 테스트용
 */
@Controller
public class FileUploadController {
	
	private static final Logger	log	= LoggerFactory.getLogger(FileUploadController.class);
									
	@Autowired
	public FileUploadService	svc	= null;
									
	FileVO						file;
								
	public FileUploadController() {
		// TODO Auto-generated constructor stub
		log.debug("FileUploadController");
		file = new FileVO();
	}
	
	@RequestMapping(value = { "/testFileUploadForm.ac" })
	public String testFileUploadForm() {
		log.debug("/testFileUploadForm.ac");
		return "test/testFileUploadForm";
	}
	
	@RequestMapping(value = "/testFileUpload3.ac")
	public ModelAndView insertBoard(CommandMap commandMap, HttpServletRequest request) throws Exception {
		log.debug("/testFileUpload3.ac start");
		ModelAndView mv = new ModelAndView("testFileUploadResult");
		
		svc.insertFile(commandMap.getMap(), request);
		
		log.debug("/testFileUpload3.ac end");
		return mv;
	}
	
	@RequestMapping(value = { "/testFileUpload2.ac" })
	// public String testFileUpload2(@RequestParam("imgFile") MultipartFile imgFile, Model model) {
	public String testFileUpload2(Model model) {
		log.debug("/testFileUpload2.ac");
		model.addAttribute("resultmsg", "현재 작동 안하는 메소드");
		// String savePath = "D:\\test";
		// String orFileName = imgFile.getOriginalFilename();
		// String name = orFileName.substring(0, orFileName.lastIndexOf("."));
		// String ex = orFileName.substring(orFileName.lastIndexOf("."));
		// log.debug(name);
		// log.debug(ex);
		// String rename = name + "_" + UUID.randomUUID();
		// String full = savePath + "\\" + rename;
		// File file = new File(full);
		// if (!imgFile.isEmpty()) {
		//
		// }
		
		return "test/testFileUploadResult";
	}
	
	@RequestMapping(value = { "/testFileUpload1.ac" })
	public String testFileUpload1(Model model, MultipartHttpServletRequest req, HttpServletResponse res) {
		log.debug("/testFileUpload1.ac");
		
		Iterator<String> itr = req.getFileNames();
		List<String> files = new ArrayList<String>();
		while (itr.hasNext()) {
			MultipartFile mpf = req.getFile(itr.next());
			String originFileName = mpf.getOriginalFilename();
			log.debug("originFileName:" + originFileName);
			files.add(originFileName);
		}
		model.addAttribute("filenames", files);
		
		return "test/testFileUploadResult";
	}
	
	@RequestMapping(value = "/testFileUpload0.ac", method = RequestMethod.POST)
	public String upload(Model model, MultipartHttpServletRequest mrequest, HttpServletResponse response) {
		
		List<FileVO> files = svc.fileUpload(mrequest);
		
		model.addAttribute("filevos", files);
		try {
			model.addAttribute("fileone", files.get(0));
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("resultmsg", e.getMessage());
		}
		log.debug("test/testFileUploadResult.jsp" + files);
		return "test/testFileUploadResult";
		
		// return "<img src='testFile/get/" + Calendar.getInstance().getTimeInMillis() + ".ac' />";
	}
	
	@RequestMapping(value = "/testFile/get/{value}.ac", method = RequestMethod.GET)
	public void get(HttpServletResponse response, @PathVariable String value) {
		log.debug("/get/" + value + ".ac");
		try {
			response.setContentType(file.type);
			response.setContentLength(file.length);
			FileCopyUtils.copy(file.bytes, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

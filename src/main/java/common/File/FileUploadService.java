package common.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * @author holy
 * @Service를 적용한 Class는 비지니스 로직이 들어가는 Service로 등록이 된다.
 */
@Service
public class FileUploadService {
	
	// @Repository으로 지정된걸 참조함
	// @Autowired
	// public testDAO dao = null;
	
	@Resource(name = "fileUtils")
	private FileUtils		fileUtils;
							
	@Autowired
	private FileDAO			filedao;
							
	private final Logger	log	= LoggerFactory.getLogger(this.getClass());
								
	public List<FileVO> fileUpload(MultipartHttpServletRequest mrequest) {
		// 0. notice, we have used MultipartHttpServletRequest
		
		// 1. get the files from the request object
		Iterator<String> itr = mrequest.getFileNames();
		StringBuilder str = new StringBuilder();
		List<FileVO> files = new ArrayList<FileVO>();
		while (itr.hasNext()) {
			// String string = (String) itr.next();
			
			MultipartFile mpf = mrequest.getFile(itr.next());
			log.debug("/testFileupload.ac:" + mpf.getOriginalFilename() + " uploaded!");
			
			try {
				// just temporary save file info into ufile
				FileVO file = new FileVO();
				file.length = mpf.getBytes().length;
				file.bytes = mpf.getBytes();
				file.type = mpf.getContentType();
				file.name = mpf.getOriginalFilename();
				log.debug(file.length + "");
				log.debug(file.bytes + "");
				log.debug(file.type);
				log.debug(file.name);
				files.add(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// makeFile(request);
		}
		// 2. send it back to the client as <img> that calls get method
		// we are using getTimeInMillis to avoid server cached image
		
		return files;
	}
	
	private void makeFile(MultipartHttpServletRequest request) {
		// 10Mbyte 제한
		int maxSize = 1024 * 1024 * 10;
		
		// 웹서버 컨테이너 경로
		String root = request.getSession().getServletContext().getRealPath("/");
		log.debug("root:" + root);
		
		// 파일 저장 경로(ex : /home/tour/web/ROOT/upload)
		String savePath = root + "upload";
		
		// 업로드 파일명
		String uploadFile = "";
		
		// 실제 저장할 파일명
		String newFileName = "";
		
		int read = 0;
		byte[] buf = new byte[1024];
		FileInputStream fin = null;
		FileOutputStream fout = null;
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		try {
			
			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8",
			        new DefaultFileRenamePolicy());
					
			// 전송받은 parameter의 한글깨짐 방지
			String title = multi.getParameter("title");
			title = new String(title.getBytes("8859_1"), "UTF-8");
			
			// 파일업로드
			uploadFile = multi.getFilesystemName("uploadFile");
			
			// 실제 저장할 파일명(ex : 20140819151221.zip)
			newFileName = simDf.format(new Date(currentTime)) + "." + uploadFile.substring(uploadFile.lastIndexOf(".")
			        + 1);
					
			// 업로드된 파일 객체 생성
			File oldFile = new File(savePath + uploadFile);
			
			// 실제 저장될 파일 객체 생성
			File newFile = new File(savePath + newFileName);
			
			// 파일명 rename
			if (!oldFile.renameTo(newFile)) {
				
				// rename이 되지 않을경우 강제로 파일을 복사하고 기존파일은 삭제
				
				buf = new byte[1024];
				fin = new FileInputStream(oldFile);
				fout = new FileOutputStream(newFile);
				read = 0;
				while ((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}
				
				fin.close();
				fout.close();
				oldFile.delete();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertFile(Map<String, Object> map, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		//filedao.insertBoard(map);
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if (multipartFile.isEmpty() == false) {
				log.debug("------------- file start -------------");
				log.debug("name : " + multipartFile.getName());
				log.debug("filename : " + multipartFile.getOriginalFilename());
				log.debug("size : " + multipartFile.getSize());
				log.debug("-------------- file end --------------\n");
			}
		}
		
		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(map, request);
		for (int i = 0, size = list.size(); i < size; i++) {
			filedao.insertFile(list.get(i));
		}
	}
	
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return filedao.selectBoardList(map);
		
	}
	
	public void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
		filedao.insertBoard(map);
		
		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(map, request);
		for (int i = 0, size = list.size(); i < size; i++) {
			filedao.insertFile(list.get(i));
		}
	}
	
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		filedao.updateHitCnt(map);
		Map<String, Object> resultMap = filedao.selectBoardDetail(map);
		return resultMap;
	}
	
	public void updateBoard(Map<String, Object> map) throws Exception {
		filedao.updateBoard(map);
	}
	
	public void deleteBoard(Map<String, Object> map) throws Exception {
		filedao.deleteBoard(map);
	}
}

package auction.InsertItem;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class fileUploadUtil {
	public static String fileUpload(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		Logger logger = Logger.getLogger(fileUploadUtil.class);
		String real_name = null;
		String org_name = file.getOriginalFilename();
		 
		if (org_name != null && (!org_name.equals(""))) {
			real_name = "board_" + System.currentTimeMillis() + "_" + org_name;
			String docRoot = request.getSession().getServletContext().getRealPath("/uploadStorage");

			File fileDir = new File(docRoot);
			if (!fileDir.exists()) {
				fileDir.mkdir();
			}
			File fileAdd = new File(docRoot + "/" + real_name);
			logger.info("---------------------***docRoot : "+docRoot);
			file.transferTo(fileAdd);
		}
		return real_name;
	}
}

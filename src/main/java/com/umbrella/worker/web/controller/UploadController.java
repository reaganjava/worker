package com.umbrella.worker.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.umbrella.worker.dto.AttachmentDO;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.service.IAttachmentService;

@Controller
@RequestMapping(value = "/file")
public class UploadController {

	private static final String UPLOAD_DIR = "e:/temp/images/";

	private static final String URI_PATH = "";

	@Autowired
	private IAttachmentService attachmentService;

	@RequestMapping(value ="/upload.html", method = RequestMethod.POST)
	public String upload(@RequestParam("file") CommonsMultipartFile[] files,
			HttpServletRequest request) {
		boolean isUp = true;
		System.out.println("upload");
		File uploadDir = new File(UPLOAD_DIR);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		for (int i = 0; i < files.length; i++) {
			
			AttachmentDO attachmentDO = null;
			if (!files[i].isEmpty()) {
				int beginIndex = files[i].getOriginalFilename()
						.lastIndexOf(".");
				String suffix = files[i].getOriginalFilename().substring(
						beginIndex);
				FileOutputStream os = null;
				FileInputStream in = null;

				try {
					String filename = System.currentTimeMillis()
							+ UUID.randomUUID().hashCode() + "." + suffix;
					// 拿到输出流，同时重命名上传的文件
					os = new FileOutputStream(UPLOAD_DIR + "/" + filename);
					// 拿到上传文件的输入流
					in = (FileInputStream) files[i].getInputStream();
					attachmentDO = new AttachmentDO();
					attachmentDO.setwAttachName(filename);
					attachmentDO.setwAttachPath(UPLOAD_DIR);
					attachmentDO.setwAttachUri(URI_PATH + "/" + filename);
					attachmentDO.setCreateAuthor((String) request.getSession()
							.getAttribute("MANAGER_NAME"));
					// 以写字节的方式写文件
					int b = 0;
					while ((b = in.read()) != -1) {
						os.write(b);
					}

				} catch (Exception e) {
					e.printStackTrace();
					isUp = false;
					break;
				} finally {
					try {
						os.flush();
						os.close();
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				
				ResultDO result = attachmentService.create(attachmentDO);
				if (!result.isSuccess()) {
					isUp = false;
					break;
				}
			}
		}
		if(isUp) {
			return "success";
		} else {
			return "fail";
		}
	}

}

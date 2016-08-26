package com.umbrella.worker.web.controller.manager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.AttachmentDO;

@Controller
@RequestMapping(value = "/attachment")
public class AttachmentController {

	@RequestMapping(value = "/upload")
	public ModelAndView upload(
			ModelAndView mav,
			@RequestParam("file") CommonsMultipartFile[] files,
			HttpServletRequest request) {
		
		String username = (String) request.getSession().getAttribute("MANAGER_NAME");
		for(CommonsMultipartFile file : files) {
			AttachmentDO attachmentDO = new AttachmentDO();
			String filename = java.util.UUID.randomUUID().toString();
			attachmentDO.setwAttachName(file.getOriginalFilename());
			attachmentDO.setCreateAuthor(username);
		}
		return mav;
	}
}

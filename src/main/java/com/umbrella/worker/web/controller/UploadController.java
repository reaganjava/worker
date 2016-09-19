package com.umbrella.worker.web.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class UploadController {
	
	public static final String UPLOAD_DIR = "";

	@RequestMapping("/upload")  
    public String upload(@RequestParam("file") CommonsMultipartFile[] files,HttpServletRequest request){  
          
        for(int i = 0;i<files.length;i++){  
            if(!files[i].isEmpty()){
            	int beginIndex = files[i].getOriginalFilename().lastIndexOf(".");
                String suffix = files[i].getOriginalFilename().substring(beginIndex);
                try {  
                	String filename = System.currentTimeMillis() + UUID.randomUUID().hashCode() + "." + suffix;
                    //拿到输出流，同时重命名上传的文件  
                    FileOutputStream os = new FileOutputStream(UPLOAD_DIR + "/" + filename);  
                    //拿到上传文件的输入流  
                    FileInputStream in = (FileInputStream) files[i].getInputStream();  
                      
                    //以写字节的方式写文件  
                    int b = 0;  
                    while((b=in.read()) != -1){  
                        os.write(b);  
                    }  
                    os.flush();  
                    os.close();  
                    in.close();  
                    
                      
                } catch (Exception e) {  
                    e.printStackTrace();  
                    System.out.println("上传出错");  
                }  
        }  
        }  
        return "/success";  
    }  
	
}

package com.ibm.db2.rca.bluemix;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping(value = "/uploadMultipleFile.json")
public class FileUploadController {


	/**
     * Upload multiple file using Spring Controller
     */
    @RequestMapping(method = RequestMethod.POST, produces={"application/json"})
    public @ResponseBody
    JavaBean uploadMultipleFileHandler(@RequestParam("uploadedfiles[]") MultipartFile[] files) {
 
    	System.err.println("I am inside the code ***********");
    	
    	List<String> list = new ArrayList<String>();
        String message = "";
        
        // Creating the directory to store file
        String rootPath = System.getProperty("java.io.tmpdir");
        File dir = new File(rootPath + File.separator + "tmpFiles");
        if (!dir.exists())
            dir.mkdirs();
        
        System.err.println("Temp dir : " + dir.getPath());
        
        
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            try {
                byte[] bytes = file.getBytes();
 

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()+ File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                System.out.println("Filename : " + file.getOriginalFilename());

                message = "You successfully uploaded file=" + file.getOriginalFilename();
                
                list.add(message);
                
            } catch (Exception e) {
            	System.err.println("error************");
                list.add("You failed to upload " + file.getName() + " => " + e.getMessage());
            }
        }

    	JavaBean jb = new JavaBean();
    	
    	jb.setP1("P1");
    	jb.setP2("P2---ndflksdf dsf");
    	
    	System.out.println("I am in side the code...");
    	
        return jb;	
    }

}
package com.ibm.db2.rca.bluemix;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/getmeJson.json")
public class TestJsonC {

    @RequestMapping(method = RequestMethod.GET, produces={"application/json"})
    public @ResponseBody JavaBean getmeJson() {
    	
    	JavaBean jb = new JavaBean();
    	
    	jb.setP1("P1");
    	jb.setP2("P2---ndflksdf dsf");
    	
    	System.out.println("I am in side the code...");
    	
    	
    	
    	
    	
        return jb;	
    }
}

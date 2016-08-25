package com.andrews.resources;

import com.andrews.dataobjects.*;
import com.andrews.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;

/**
 * Created by andrewssamuel on 8/24/16.
 */
@Controller
public class ShortURLCreatorController {

    @Autowired
    private ShortURLCreatorService shortURLCreatorService;



     @RequestMapping(value = "/create", method=RequestMethod.POST)
     public String getShortURL(URLMapper urlMapper, ModelMap map, HttpServletRequest request){
         String contextPath =  request.getScheme() + "://" + request.getServerName();
         map.addAttribute("urlmapper",shortURLCreatorService.createShortURL(urlMapper.getLongURL(), contextPath));
         map.addAttribute("urlList", shortURLCreatorService.findAll());
         return "urlmapper";
     }


     @RequestMapping(value = "/{short}")
     public String loadURL(@PathVariable("short") String encodedID, Model model){
         URLMapper urlMapper = shortURLCreatorService.retrieveLongURL(encodedID);
         model.addAttribute("urlmapper",urlMapper);
         return "redirect:"+urlMapper.getLongURL();
     }

    @RequestMapping("/")
    public String loadUrlForm(ModelMap map){
        map.addAttribute("urlmapper",new URLMapper());
        map.addAttribute("urlList", shortURLCreatorService.findAll());
        return "urlmapper";
    }


}

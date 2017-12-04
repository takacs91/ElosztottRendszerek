package hu.uni.miskolc.controller;

import hu.uni.miskolc.model.Brand;
import hu.uni.miskolc.model.Mobile;
import hu.uni.miskolc.service.MobileManagerService;
import hu.uni.miskolc.service.MobileSearchService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Collection;

@Controller
public class MobileManagerController {

    private MobileManagerService mobileManager;
    private MobileSearchService mobileSearch;

    public MobileManagerController(MobileManagerService mobileManager, MobileSearchService mobileSearch) {
        this.mobileManager = mobileManager;
        this.mobileSearch = mobileSearch;

    }

    @RequestMapping(value = "/mobile/list")
    @ResponseBody
    public Collection<Mobile> listAllMobile(){
        return mobileSearch.listAllMobile();
    }

    @RequestMapping(value = "/mobile/register")
    @ResponseBody
    public void registrar(@RequestParam("mod") String model, @RequestParam(value = "rd") String releaseDate, @RequestParam("br") Brand brand){
        Mobile mobile = new Mobile(model, releaseDate, brand);
        mobileManager.register(mobile);
        System.out.println("new mobile added");
    }
    
    @RequestMapping(value = "/one")
    @ResponseBody
    public void addsome(@RequestParam("mod") String model){
        Mobile mobile = new Mobile(model, " ",null);
        mobileManager.register(mobile);
    }
    
    @RequestMapping(value = "/find")
    @ResponseBody
    public Mobile findMobile(@RequestParam("model") String model){
        return mobileSearch.findMobile(model);
    }
    
    @RequestMapping(value = "/delete")
    //@ResponseBody
    public String deleteMobile(@RequestParam("model") String model){
    	mobileManager.deleteMobile(model);
        return "redirect:/mobile/list";
    }
    
    @RequestMapping(value = "/info")
    @ResponseBody
    public String information(){
        return "Type in the URL: web/find?name=G4!";
    }
    
    @RequestMapping(value = "/view")
    public String main(){
        return "view";
    }
    
    @RequestMapping(value = "/angular")
    public String mainAngular(){
        return "angularpage";
    }
    
}

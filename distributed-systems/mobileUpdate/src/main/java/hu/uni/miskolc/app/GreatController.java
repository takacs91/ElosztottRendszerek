package hu.uni.miskolc.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hu.uni.miskolc.struct.Mobile;

@Controller
public class GreatController {
	
	private Mobile newmobile=new Mobile();
	
	@Value("${welcome.message:test}")
	private String message = "Hello World";
    
	@RequestMapping(value={"/","/page"})
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "homepage";
	}
	
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="Web") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @RequestMapping("/getmobiles")
    //@ResponseBody
    public String getMobiles(@RequestParam(value="model", required=false, defaultValue="G4") String name, Model model) {
        model.addAttribute("mod", Application.gateway.getMobile(name).getModel());
        model.addAttribute("rel", Application.gateway.getMobile(name).getReleaseDate());
        model.addAttribute("bra", Application.gateway.getMobile(name).getBrand());
    	return "mobiles";
    }
    
    @RequestMapping("/finder")
    public String getMobiles() {
    	return "finder";
    }
    
    @GetMapping(value={"/form","/form_expand"})
    public String searchForm(Model model) {
        model.addAttribute("mobile", new Mobile());
        return "form";
    }

    @PostMapping("/form") //params={"submit"}
    public String searchSubmit(@ModelAttribute Mobile content,Model model ) {
    	try{
    		newmobile=Application.gateway.getMobile(content.getModel());
    		model.addAttribute("newmobile", newmobile);
    		return "form_expand";
    	}catch(org.springframework.core.convert.ConverterNotFoundException e){}
    	return "form";
    }
    
    @RequestMapping("/lista")
    public String getAllMobiles(String name,Model model) {
        model.addAttribute("mobiles", Application.gateway.listAllMobiles());
    	return "lista";
    }
    
    @GetMapping("/update")
    public String addForm(Model model) {
        model.addAttribute("mobile", new Mobile());
        return "update";
    }
    
    @PostMapping("/update") //params={"submit"}
    public String addSubmit(@ModelAttribute Mobile content, Model model) {
    	Mobile mobile = new Mobile(content.getModel(), content.getReleaseDate(), null);
        Application.gateway.addMobile(mobile);
    	return "redirect:/lista";
    }
      
    @RequestMapping("/red")
    public String getDirect() {
    	return "redirect:/form";
    }  
}

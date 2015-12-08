/**
 *		                     /$$        /$$$$$$  /$$
 *		  /$$$$$$$  /$$$$$$ | $$$$$$$ |__/  \ $$ /$$
 *		 /$$_____/ |____  $$| $$__  $$  /$$$$$$/| $$
 *		|  $$$$$$   /$$$$$$$| $$  \ $$ /$$____/ | $$
 *		 \____  $$ /$$__  $$| $$  | $$| $$      | $$
 *		 /$$$$$$$/|  $$$$$$$| $$$$$$$/| $$$$$$$$| $$
 *		|_______/  \_______/|_______/ |________/|__/                         
 *                          ~ Departement - SSI
 *                           ~ @author ${user} 
 * 
 */
package com.sab2i.demo.camel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * <h1>Login Controller</h1><br/>
 *
 * This class is responsible to expose HTTP methodes like a classic servlet
 * does, but using spring mvc. the @RequestMapping on the controller specifies
 * the url context of this controller, inside this controller every
 *
 * @RequestMapping will be mapped inside /authentication so you dont need to
 * specify /authentication/yourmethod every time.
 *
 * @author martinsa
 * @see org.springframework.web.bind.annotation.RequestMapping
 */
@Controller
@RequestMapping(value = "/authentication")
public class AuthenticationController {
    
    private static final Logger logger = 
            Logger.getLogger(AuthenticationController.class.getName());

    
    public AuthenticationController() {
        //Configuration du proxy sur la jvm - A ACTIVER SI BESOIN
        /*System.setProperty("http.proxyHost", "10.5.8.10");
        System.setProperty("http.proxyPort", "8080");*/
    }
    
    @RequestMapping(value = "/login.do")
    public ModelAndView login(@RequestParam(value = "error", required = false) 
                                String error,
                                @RequestParam(value = "logout", required = false) 
                                String logout) {

        ModelAndView model = new ModelAndView("login");
        
        logger.info("[i] Authentication Controller Started");
        
        if (error != null) {
            model.addObject("error", "Invalid username or password");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        /*
         * IMPORTANT: spring mvc tries to find the view under /classname.jsp 
         * inside the specified views directory (in the xml configuration of 
         * spring) if it's not there, you need to specify where it is relative
         * to the location specified on the xml file.
         */
        model.setViewName("authentication/login");
        return model;
    }

    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/authentication/login.do?logout";
    }
}

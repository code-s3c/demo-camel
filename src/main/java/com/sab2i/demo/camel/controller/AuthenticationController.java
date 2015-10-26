/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sab2i.demo.camel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author martinsa
 */
@Controller
@RequestMapping(value="/authentication")
public class AuthenticationController {
    
    @RequestMapping(value="/login.do")
    public ModelAndView login(@RequestParam(value="error", required = false) 
                              String error,
                              @RequestParam(value="logout", required = false)
                              String logout) {
        
        ModelAndView model = new ModelAndView("login");
        System.out.println("Auth controller started...");
        if(error != null) {
            model.addObject("error","Invalid username and password!");
        }
        
        if(logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");
        return model;
    }
}

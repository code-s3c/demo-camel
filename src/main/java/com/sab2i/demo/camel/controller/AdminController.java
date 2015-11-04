/**
 *		                     /$$        /$$$$$$  /$$
 *		  /$$$$$$$  /$$$$$$ | $$$$$$$ |__/  \ $$ /$$
 *		 /$$_____/ |____  $$| $$__  $$  /$$$$$$/| $$
 *		|  $$$$$$   /$$$$$$$| $$  \ $$ /$$____/ | $$
 *		 \____  $$ /$$__  $$| $$  | $$| $$      | $$
 *		 /$$$$$$$/|  $$$$$$$| $$$$$$$/| $$$$$$$$| $$
 *		|_______/  \_______/|_______/ |________/|__/                         
 *                          ~ Departement - SSI
 *                           ~ @author martinsa 
 * 
 */
package com.sab2i.demo.camel.controller;

import com.sab2i.demo.camel.entity.Quote;
import com.sab2i.demo.camel.interfaces.IQuoteDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    
    @Autowired
    IQuoteDao dao;

    @RequestMapping(value = "/managequotes.do")
    public ModelAndView viewQuotes() {
        ModelAndView model = new ModelAndView();
        List<Quote> quotes = dao.listAll();
        model.addObject("quotes", quotes);
        return model;
    }
    
    @RequestMapping(value = "/addquotesymbol.do", method = RequestMethod.POST)
    public String addQuoteSymbol(@RequestParam("symbol") String symbol) {
        System.out.println("received Symbol: "+symbol);
        dao.addQuote(symbol);
        return "redirect:/admin/managequotes.do";
    }
}

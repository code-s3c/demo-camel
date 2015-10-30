/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

import net.webservicex.StockQuote;
import net.webservicex.StockQuoteSoap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/quotes")
public class MainController {
    
    @RequestMapping(value = "/getquotes.do")
    public ModelAndView getQuotes() {
        ModelAndView model = new ModelAndView();
        model.addObject("quoteValue", getQuoteValue("MTSI"));
        return model;
    }
    
    private String getQuoteValue(String symbol) {
        StockQuote service = new net.webservicex.StockQuote();
        StockQuoteSoap port = service.getStockQuoteSoap();
        // TODO initialize WS operation arguments here
        // TODO process result here
        java.lang.String result = port.getQuote(symbol);
        System.out.println("Result = "+result);
        return result;
    }
}

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

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sab2i.demo.camel.entity.Quote;
import com.sab2i.demo.camel.interfaces.IQuoteDao;
import com.sab2i.demo.camel.vo.Stock;
import com.sab2i.demo.camel.vo.StockCollection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.webservicex.StockQuote;
import net.webservicex.StockQuoteSoap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/quote")
public class QuoteController {
    
    @Autowired
    IQuoteDao dao;
    
    private static final Logger logger = 
            Logger.getLogger(QuoteController.class.getName());
    
    
    @RequestMapping(value = "/getquote.do")
    public ModelAndView getQuotes() {
        ModelAndView model = new ModelAndView();
        List<Quote> quoteList = dao.listAll();
        List<Stock> stockList = new ArrayList<>();
        
        for(Quote quote:quoteList) {
            StockCollection collection = getQuoteValue(quote.getName());
            stockList.add(collection.getStock());
        }
        
        model.addObject("quotes", stockList);
        return model;
    }
    
    private StockCollection getQuoteValue(String symbol) {
        try {
            StockQuote service = new StockQuote();
            StockQuoteSoap port = service.getStockQuoteSoap();
            
            String result = port.getQuote(symbol);
            XmlMapper mapper = new XmlMapper();
            StockCollection collection = mapper.readValue(result,
                    StockCollection.class);
            
            System.out.println("Result = "+result);
            System.out.println(collection.getStock().getLast());
            return collection;
        } catch (IOException ex) {
            logger.error("[e] Application error: "+ex.getMessage());
            return null;
        }
    }
}

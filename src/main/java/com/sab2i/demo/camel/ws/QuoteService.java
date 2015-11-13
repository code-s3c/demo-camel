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
package com.sab2i.demo.camel.ws;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sab2i.demo.camel.vo.StockCollection;
import java.io.IOException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import net.webservicex.StockQuote;
import net.webservicex.StockQuoteSoap;

@WebService(serviceName = "QuoteService", name="QuotePortType")
public class QuoteService {

    @WebMethod(operationName = "getQuoteValue")
    public String getQuoteValue(@WebParam(name = "symbol") String symbol) {
        try {
            StockQuote service = new StockQuote();
            StockQuoteSoap port = service.getStockQuoteSoap();
            
            String result = port.getQuote(symbol);
            XmlMapper mapper = new XmlMapper();
            StockCollection collection = mapper.readValue(result,
                    StockCollection.class);
            
            System.out.println("Result = "+result);
            System.out.println(collection.getStock().getLast());
            return collection.getStock().getLast();
        } catch (IOException ex) {
            return null;
        }
    }
}

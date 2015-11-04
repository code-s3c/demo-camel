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
 *      This class represents a wrapper of Stock items from the web service
 */
package com.sab2i.demo.camel.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName = "StockQuotes")
public class StockCollection {
    
    @JacksonXmlProperty(localName = "Stock")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Stock stock;

    /**
     * @return the stocklist
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * @param stock the stocklist to set
     */
    public void setStock(Stock stock) {
        this.stock = stock;
    }
}

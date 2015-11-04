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
 *  This class is a Value Object representing an Stock item from WebServices
 *  and will be automatically converted from xml
 */
package com.sab2i.demo.camel.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Stock {
    @JacksonXmlProperty(localName = "Symbol")
    private String symbol;
    @JacksonXmlProperty(localName = "Last")
    private String last;
    @JacksonXmlProperty(localName = "Date")
    private String date;
    @JacksonXmlProperty(localName = "Time")
    private String time;
    @JacksonXmlProperty(localName = "Change")
    private String change;
    @JacksonXmlProperty(localName = "Open")
    private String open;
    @JacksonXmlProperty(localName = "High")
    private String high;
    @JacksonXmlProperty(localName = "Low")
    private String low;
    @JacksonXmlProperty(localName = "Volume")
    private String volume;
    @JacksonXmlProperty(localName = "MktCap")
    private String mktCap;
    @JacksonXmlProperty(localName = "PreviousClose")
    private String previousClose;
    @JacksonXmlProperty(localName = "PercentageChange")
    private String percentageChange;
    @JacksonXmlProperty(localName = "AnnRange")
    private String annRange;
    @JacksonXmlProperty(localName = "Earns")
    private String earns;
    @JacksonXmlProperty(localName = "P-E")
    private String pe;
    @JacksonXmlProperty(localName = "Name")
    private String name;
    
    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the last
     */
    public String getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(String last) {
        this.last = last;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the change
     */
    public String getChange() {
        return change;
    }

    /**
     * @param change the change to set
     */
    public void setChange(String change) {
        this.change = change;
    }

    /**
     * @return the open
     */
    public String getOpen() {
        return open;
    }

    /**
     * @param open the open to set
     */
    public void setOpen(String open) {
        this.open = open;
    }

    /**
     * @return the high
     */
    public String getHigh() {
        return high;
    }

    /**
     * @param high the high to set
     */
    public void setHigh(String high) {
        this.high = high;
    }

    /**
     * @return the low
     */
    public String getLow() {
        return low;
    }

    /**
     * @param low the low to set
     */
    public void setLow(String low) {
        this.low = low;
    }

    /**
     * @return the volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * @return the mktCap
     */
    public String getMktCap() {
        return mktCap;
    }

    /**
     * @param mktCap the mktCap to set
     */
    public void setMktCap(String mktCap) {
        this.mktCap = mktCap;
    }

    /**
     * @return the previousClose
     */
    public String getPreviousClose() {
        return previousClose;
    }

    /**
     * @param previousClose the previousClose to set
     */
    public void setPreviousClose(String previousClose) {
        this.previousClose = previousClose;
    }

    /**
     * @return the percentageChange
     */
    public String getPercentageChange() {
        return percentageChange;
    }

    /**
     * @param percentageChange the percentageChange to set
     */
    public void setPercentageChange(String percentageChange) {
        this.percentageChange = percentageChange;
    }

    /**
     * @return the annRange
     */
    public String getAnnRange() {
        return annRange;
    }

    /**
     * @param annRange the annRange to set
     */
    public void setAnnRange(String annRange) {
        this.annRange = annRange;
    }

    /**
     * @return the earns
     */
    public String getEarns() {
        return earns;
    }

    /**
     * @param earns the earns to set
     */
    public void setEarns(String earns) {
        this.earns = earns;
    }

    /**
     * @return the pe
     */
    public String getPe() {
        return pe;
    }

    /**
     * @param pe the pe to set
     */
    public void setPe(String pe) {
        this.pe = pe;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}

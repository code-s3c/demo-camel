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
package com.sab2i.demo.camel.dao;

import com.sab2i.demo.camel.entity.Quote;
import com.sab2i.demo.camel.entity.Role;
import com.sab2i.demo.camel.interfaces.IQuoteDao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("QuoteDaoJPA")
public class QuoteDaoJPA implements IQuoteDao {
    
    private final Logger logger = 
            Logger.getLogger(UserDaoJPA.class.getName());
    
    private final EntityManagerFactory factory;
    
    QuoteDaoJPA() {
        factory = Persistence.createEntityManagerFactory("demo-camel-mysql");
    }
    
    @Override
    public void addQuote(String symbol) {
        System.out.println("Creating symbol: "+symbol);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Quote quote = new Quote();
        quote.setName(symbol);
        quote.setAuthorizedRoles(new ArrayList<Role>());
        em.persist(quote);
        em.getTransaction().commit();
        em.close();
    }
    
    @Override
    public List<Quote> listAll() {
        try {
            EntityManager em = factory.createEntityManager();
            Query query = em.createNamedQuery("quote.listAll");
            List<Quote> quoteList = query.getResultList();
            return quoteList;
        } catch(Exception ex) {
            logger.error("[e] Unable to retrieve quote list");
            return null;
        }
    }

    @Override
    public Quote findById(long id) {
        try {
            EntityManager em = factory.createEntityManager();
            TypedQuery<Quote> query = em.createNamedQuery("quote.findById", Quote.class);
            query.setParameter("id", id);
            Quote quote = query.getSingleResult();
            return quote;
        }catch(Exception ex) {
            logger.error("[e] Unable to retrieve quote by id");
            return null;
        }
    }

    @Override
    public void removeBySymbol(String symbol) {
        try {
            EntityManager em = factory.createEntityManager();
            TypedQuery<Quote> query = em.createNamedQuery("quote.findBySymbol", Quote.class);
            query.setParameter("symbol", symbol);
            Quote quote = query.getSingleResult();
            em.getTransaction().begin();
            em.remove(quote);
            em.getTransaction().commit();
        }catch(Exception ex) {
            ex.printStackTrace();
            logger.error("[e] Unable to remove symbol :"+ex.getCause());
        }
    }
}

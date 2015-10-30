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
package com.sab2i.demo.camel.test.auth;

import com.sab2i.demo.camel.entity.Role;
import com.sab2i.demo.camel.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserPersistenceTest {
    private static final String UNIT_NAME = "demo-camel-mysql";
    private EntityManagerFactory factory;
    private static final Logger logger = 
            Logger.getLogger(UserPersistenceTest.class.getName());
    
    @Before
    public void setUp() {
        factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        Role r1 = new Role("TEST");
        Role r2 = new Role("USER");
        
        User user = new User("André", "MARTINS", "martinsa", "martinsa");
        user.addRole(r1);
        user.addRole(r2);
        
        logger.info("[i] Starting Transaction...");
        em.getTransaction().begin();
        logger.info("Persisting role: "+r1.getName());
        em.persist(r1);
        logger.info("Persisting role: "+r2.getName());
        em.persist(r2);
        
        logger.info("Persisting user: "+user.getFirstName());
        em.persist(user);
        
        logger.info("Commiting Transaction....");
        em.getTransaction().commit();
        em.close();
    }
    
    @After
    public void clearDatabase() {
        factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        logger.info("[i] Starting Transaction...");
        em.getTransaction().begin();
        
        Query getUserQuery = em.createNamedQuery("user.findByUsername");
        getUserQuery.setParameter("username", "martinsa");
        List<User> userList = getUserQuery.getResultList();
        
        for(User user : userList) {
            List<Role> roles = user.getRoles();
            for(Role role : roles) {
                logger.info("Removing role: "+role.getName());
                em.remove(role);
            }
            em.remove(user);
        }
        
        logger.info("Commiting Transaction....");
        em.getTransaction().commit();
        em.close();
    }
    
    @Test
    public void testUserExists() {
        EntityManager em = factory.createEntityManager();
        
        Query query = em.createNamedQuery("user.findByUsername");
        query.setParameter("username", "martinsa");
        
        List<User> userList = query.getResultList();
        em.close();
        Assert.assertTrue(userList.size() >= 1);
    }
}

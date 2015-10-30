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

import com.sab2i.demo.camel.interfaces.IUserDao;
import com.sab2i.demo.camel.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("UserDaoJPA")
public class UserDaoJPA implements IUserDao{

    private final Logger logger = 
            Logger.getLogger(UserDaoJPA.class.getName());
    
    private final EntityManagerFactory factory;
    
    UserDaoJPA() {
        factory = Persistence.createEntityManagerFactory("demo-camel-mysql");
    }
    
    @Override
    public User loadByUsername(String username) {
        try {
            EntityManager em = factory.createEntityManager();
            Query query = em.createNamedQuery("user.findByUsername");
            query.setParameter("username", username);
            List<User> userList = query.getResultList();
            return userList.get(0);
        } catch(Exception ex) {
            logger.error("username "+username+" not found!");
            ex.printStackTrace();
            return null;
        }
    }
}

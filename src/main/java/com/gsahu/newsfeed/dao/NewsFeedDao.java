package com.gsahu.newsfeed.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gsahu.newsfeed.model.Article;

@Repository
public class NewsFeedDao {
	@Autowired
    private SessionFactory sessionFactory;
	
	public void saveArticles(List<Article> articles) {
		Iterator<Article> articleIterator = articles.iterator();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			while(articleIterator.hasNext()) {
				session.save(articleIterator.next());
			}
			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}
}

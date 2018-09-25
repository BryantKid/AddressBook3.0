package service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.jdbc.spi.ResultSetReturn;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import db.MyHibernateSessionFactory;
import entity.Contacts;
import service.ContactsDAO;
import sun.security.timestamp.TSRequest;

public class ContactsDAOimpl implements ContactsDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Contacts> queryAllContacts() {

		Transaction tx=null;
		List<Contacts> list=null;
		String hql="";
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Contacts";   //注意大小写  ，，hql语句大小写敏感
			Query query=session.createQuery(hql);
			list=query.list();
			tx.commit();
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i).toString());
			}
			return list;
			
		} catch(Exception e)
		{
			e.printStackTrace();
			tx.commit();
			return list;
		}
		finally {
			if(tx!=null)
			{
				tx=null;
			}
			
		}
		
	}

	@Override
	public List<Contacts> searchByKey(String key) {
		// TODO Auto-generated method stub

		Transaction tx=null;
		
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			
			Criteria crit = session.createCriteria(entity.Contacts.class).add( Restrictions.like("name", "%"+key+"%") );
			crit.setMaxResults(50);
			@SuppressWarnings("unchecked")
			List<Contacts> person = crit.list();
			for(int i=0;i<person.size();i++) {
				System.out.println(person.get(i).toString());
			}
			tx.commit();
					
			return person;	
	}

	@Override
	public void addContacts(Contacts contacts) {

		Transaction tx=null;
		
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(contacts);
			
		} catch (Exception e) {
             e.printStackTrace();
         
		}finally {
			tx.commit();
			if(tx!=null)
				tx=null;	
		}
		
	}


	@Override
	public boolean deleteContacts(int id) {
		Transaction tx=null;
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Contacts contacts=(Contacts)session.get(Contacts.class,id);
			session.delete(contacts);
			tx.commit();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			tx.commit();
			return false;
		}
		finally {
			if(tx!=null)
			{
				tx=null;
			}
		}
	}
	
	
}

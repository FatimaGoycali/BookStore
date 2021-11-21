package com.example.about.bookstore.dao.dao;

import com.example.about.bookstore.dao.entity.Role;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Role findRoleByName(String theRoleName) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using name
		Query<Role> theQuery = currentSession.createQuery("from Role where name=:roleName");
		theQuery.setParameter("roleName", theRoleName);
		
		Role theRole = null;
		
		try {
			theRole = theQuery.getSingleResult();
		} catch (Exception e) {
			theRole = null;
		}
		
		return theRole;
	}
}

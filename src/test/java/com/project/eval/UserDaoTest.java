package com.project.eval;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.dao.UserDao;
import com.project.model.User;
import com.project.model.UserRole;
import com.project.util.HibernateUtil;

public class UserDaoTest {

	@Mock
	private HibernateUtil hUtil;
	
	@Mock
	private User testUser;
	
	@Mock
	private UserRole testRole;
	
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		testRole = new UserRole("Employee");
		testUser = new User("test account", "1234", "McLovin", "(not applicable)", "iliveinhawaii@yahoo.com", testRole);
		
	}
	
	@Test
	public void testSelectByUsername() {
		assertEquals(new UserDao(hUtil).selectByUsername("test account").getUsername(), testUser.getUsername());
	}
	
}

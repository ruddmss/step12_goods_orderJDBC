package kosta.mvc.model.service;

import java.sql.SQLException;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dao.CustomerDAO;
import kosta.mvc.model.dao.CustomerDAOImpl;
import kosta.mvc.model.dto.Customer;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;

public class CustomerService {
	CustomerDAO customerDao = new CustomerDAOImpl();
	
	
  /**
   * 로그인
   * */
	public Customer login(String userId, String userPwd)throws NotFoundException , SQLException{
		Customer customer=customerDao.login(userId, userPwd);
		if(customer==null) {
			throw new NotFoundException("정보를 다시 확인해주세요.");
		}
		
		//로그인 된 정보 저장하기
		Session session = new Session(userId);
		SessionSet sessionSet = SessionSet.getInstance(); //sessionSet 객체 가져오기 
		sessionSet.add(session); // 생성한 set 객체를 sessionSet 객체에 추가하기 
		
		return customer;
	}
}

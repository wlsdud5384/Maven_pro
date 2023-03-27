package com.myspring.proTest.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.proTest.member.dao.TestDAO;
import com.myspring.proTest.member.vo.TestVO;

	@Service("memberService")
	@Transactional(propagation = Propagation.REQUIRED)
	public class TestServiceImpl implements TestService {
		@Autowired
		private TestDAO testDAO;
		
		@Override
		public List listMembers() throws DataAccessException {
			List membersList = null;
			membersList = testDAO.selectAllMemberList();
			return membersList;
		}
		
		@Override
		public int addMember(TestVO member) throws DataAccessException {
			return testDAO.insertMember(member);
		}
		
		@Override
		public int removeMember(String id) throws DataAccessException {
			return testDAO.deleteMember(id);
		}
		
		@Override
		public TestVO login(TestVO testVO) throws Exception {
			return testDAO.loginById(testVO);
		}
		
		@Override
		public int updateMember(TestVO member) throws DataAccessException {
			return testDAO.updateMember(member);
		}
		
		@Override
		public TestVO modMember(String id) throws DataAccessException {
			return testDAO.modMember(id);
		}
	
	
	
}

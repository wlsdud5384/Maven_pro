package com.myspring.proTest.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.proTest.member.vo.TestVO;

public interface TestService {
	public List listMembers() throws DataAccessException;
	public int addMember(TestVO testVO) throws DataAccessException;
	public int removeMember(String id) throws DataAccessException;
	public TestVO login(TestVO testVO) throws Exception;
	public int updateMember(TestVO member) throws DataAccessException;
	public TestVO modMember(String id) throws DataAccessException;
}

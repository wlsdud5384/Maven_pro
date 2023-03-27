package com.myspring.proTest.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.proTest.member.vo.TestVO;

public interface TestDAO {
	public List selectAllMemberList() throws DataAccessException;
	public int insertMember(TestVO testVO) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;
	public TestVO loginById(TestVO testVO) throws DataAccessException;
	public int updateMember(TestVO member) throws DataAccessException;
	public TestVO modMember(String id) throws DataAccessException;
	
}

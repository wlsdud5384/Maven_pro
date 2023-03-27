package com.myspring.proTest.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.proTest.member.vo.TestVO;

@Repository("memberDAO")
public class TestDAOImpl implements TestDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllMemberList() throws DataAccessException {
		List<TestVO> membersList = null;
		membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}
	
	@Override
	public int insertMember(TestVO testVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", testVO);
		return result;
	}
	
	@Override
	public int deleteMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}
	
	@Override
	public TestVO loginById(TestVO testVO) throws DataAccessException {
		TestVO vo = sqlSession.selectOne("mapper.member.loginById", testVO);
		return vo;
	}
	
	@Override
	public TestVO modMember(String id) throws DataAccessException {
		TestVO testVO = sqlSession.selectOne("mapper.member.selectById", id);
		return testVO;
	}
	
	@Override
	public int updateMember(TestVO member) throws DataAccessException {
		int result = sqlSession.update("mapper.member.updateMember",member);
		return result;
	}
	
	
}
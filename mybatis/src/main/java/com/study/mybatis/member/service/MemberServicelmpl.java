package com.study.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import com.study.mybatis.common.template.Template;
import com.study.mybatis.member.dao.MemberDao;

public class MemberServicelmpl implements MemberService {
	
	private MemberDao mDao = new MemberDao();
	
	@Override
	public int checkId(String userId) {
		SqlSession sqlSession = Template.getSqlSession();
		int checkid = mDao.checkId(sqlSession, userId);
		sqlSession.close();
		return checkid;
	}
	
}

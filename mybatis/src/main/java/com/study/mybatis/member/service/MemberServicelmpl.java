package com.study.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import com.study.mybatis.common.template.Template;
import com.study.mybatis.member.dao.MemberDao;
import com.study.mybatis.member.vo.Member;

public class MemberServicelmpl implements MemberService {
   private MemberDao mDao = new MemberDao(); // 메서드를 실행하기 위해서 객체를 선언함
   
   @Override
   public int checkId(String userId) {
      SqlSession sqlSession = Template.getSqlSession();
      int checkid = mDao.checkId(sqlSession, userId); // checkId는 해당메서드를 갈때 ~~~한 것이 필요한것을 말해줌
      sqlSession.close();
      return checkid;
   }

   public int insertMember(Member m) {
      SqlSession sqlSession = Template.getSqlSession();
      int result = mDao.insertMember(sqlSession, m);
      
      if(result>0) {
         sqlSession.commit();
      }
      sqlSession.close();
      return result;
   }

@Override
public Member loginMember(Member m) {
    SqlSession sqlSession = Template.getSqlSession();
    Member loginUser = mDao.loginMember(sqlSession, m);
    sqlSession.close();
	return loginUser;
}

}

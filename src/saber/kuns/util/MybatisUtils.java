package saber.kuns.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {

	private static SqlSessionFactory sqlSessionFactory;

	private static SqlSession sqlSession;

	static {
		InputStream inputStream = MybatisUtils.class.getResourceAsStream("");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	public static SqlSession getSqlSession() {

		if (sqlSession == null) {
			sqlSession = sqlSessionFactory.openSession();
		}
		return sqlSession;
	}

}

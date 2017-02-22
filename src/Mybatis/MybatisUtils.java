package Mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Created by lenovo on 2017/2/9.
 */
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;
   private static SqlSession session = null;

    /**
     * 通过懒汉式单例设计模式获取sqlSession实例
     * @return
     * @throws IOException
     */
    public static synchronized SqlSession  newSqlSessionInstance() throws  IOException{
            if (session == null) {
                session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Mybatis/Mybatis.xml")).openSession(true);
            }
        return session;
    }
}

package com.zw.simplify;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.FileReader;
import java.io.IOException;

/**
 * <p>Title: JavaBasic-${PACKAGE_NAME}</p>
 * <p>Description: ${Description}</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/26/2020
 */
@WebFilter(filterName = "OpenSessionInView",urlPatterns = "/*")
public class SessionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        SqlSession session = MyBatisUtils.getSession();
        try {
            chain.doFilter(req, resp);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            MyBatisUtils.closeSession();
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

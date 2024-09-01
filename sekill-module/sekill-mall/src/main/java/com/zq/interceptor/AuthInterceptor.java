package com.zq.interceptor;

import com.zq.vo.MemberVo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {
    public static ThreadLocal threadLocal=new ThreadLocal();
    public static final String AUTH_SESSION_REDIS = "loginUser";

    public static final String AUTH_SESSION_MSG = "msg";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object attribute = session.getAttribute(AUTH_SESSION_REDIS);
        if(attribute != null){
            MemberVo memberVO = (MemberVo) attribute;
            threadLocal.set(memberVO);
            return true;
        }
        // 如果 attribute == null 说明没有登录，那么我们就需要重定向到登录页面
        session.setAttribute(AUTH_SESSION_MSG,"请先登录");
        response.sendRedirect("http://127.0.0.1:8081/login.html");
        return false;
    }
}

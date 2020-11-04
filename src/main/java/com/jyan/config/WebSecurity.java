//package com.jyan.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.HandlerAdapter;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//@Configuration
//public class WebSecurity implements HandlerInterceptor   {
//    public final static String SESSION_KEY="user";
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        System.out.println("拦截到");
//        Cookie[] cookies=request.getCookies();
//        String path=request.getServletPath();
//        if(path.contains("article")||path.contains("login")){
//            return true;
//        }
//        for (Cookie cookie:cookies){
//            System.out.println(cookie.getName()+"拦截器中的cookie");
//            if(cookie.getName().equals(SESSION_KEY)){
//                return true;
//
//            }
//        }
//        response.sendRedirect("/admin/login");
//        return false;
//    }
//
//
//    //    @Override
////    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////        //登录成功之后，有用户的sessoin
////        Object loginUser=request.getSession().getAttribute("user");
////        if (loginUser==null){
////            request.setAttribute("msg","没有权限，请先登录");
////            request.getRequestDispatcher("/admin/login.html").forward(request,response);
////            return false;
////        }else {
////            return true;
////        }
////
////    }
//
//
//}

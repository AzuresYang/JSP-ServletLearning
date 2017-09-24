package utils;

import cn.itcast.servlet.GetRequest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by 28029 on 2017/9/18.
 * @Description:作为Serlvet类的父类，能够从Get或者Post的提交中，找到method的属性，并调用相应的方法。
 */
public class BaseServlet extends HttpServlet{
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if( request.getMethod().equalsIgnoreCase("get"))//get的传输方式
        {
            if(!(request instanceof GetRequest))
                request = new GetRequest(request); //处理get请求编码
        }else{
            request.setCharacterEncoding("utf-8");//处理post请求编码
        }

        response.setContentType("text/html;charset=UTF-8");

        //从请求中获取需要调用的方法
        String methodName = request.getParameter("method");
        Method method = null;

        //获取方法
        try {
            method = this.getClass().getMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //调用该方法
        try{
            String result = (String)method.invoke(this, request, response);

            if(result != null && !result.trim().isEmpty()){ //请求处理的返回方法不为空
                int index = result.indexOf(":");
                //如果没有冒号，直接转向返回的页面
                //如果有冒号，“：”前，f为转发，否则为重定向
                if(-1 == index){
                    request.getRequestDispatcher(result).forward(request,response);
                }
                else{
                    String start = result.substring(0, index); //分割出前辍
                    String path = result.substring(index + 1); //分割出路径

                    //转发或者是重定向
                    if( "f".equals(start))
                        request.getRequestDispatcher(path).forward(request, response);
                    else
                        response.sendRedirect(request.getContextPath()+path);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

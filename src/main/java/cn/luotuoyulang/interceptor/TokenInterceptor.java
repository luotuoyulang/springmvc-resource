package cn.luotuoyulang.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class TokenInterceptor implements HandlerInterceptor {

    /**
     * @Description 请求方法前置拦截,如果返回true 表示会执行到目标方法(请求方法) 如果返回 false 的情况下 则不会执行目标方法
     * @param request
     * @param response
     * @param handler
     * @return {@link {@link boolean}}
     * @throws
     * @author liuyuhu
     * @date 2020/2/21 0:18
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        String token = request.getParameter("token");
//        if(StringUtils.isEmpty(token)){
//            response.getWriter().write("token is null");
//            return false;
//        }
        return true;
    }

    /**
     * @Description 请求方法之后，没有渲染页面
     *              区别：在定义渲染页面之前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @return {@link }
     * @throws
     * @author liuyuhu
     * @date 2020/2/21 11:25
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    /**
     * @Description 区别：在定义渲染页面之后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return {@link }
     * @throws
     * @author liuyuhu
     * @date 2020/2/21 11:26
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}

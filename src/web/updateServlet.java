package web;

import bean.User;
import service.IserviceUser;
import service.serviceuserImpl;
import util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class updateServlet extends HttpServlet {
    IserviceUser service = new serviceuserImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //修改
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String[]> map = request.getParameterMap();

        User user = JdbcUtil.tobean(User.class, map);

        int i = service.updateAll(user);

        if (i == 1) {
            response.getWriter().write("<script>alert('修改成功！');location.href='/show'</script>");

        } else {
            response.getWriter().write("<script>alert('修改失败！');location.href='/show'</script>");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        查询单条数据
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("update");

        User user = service.selectId(id);
        request.getSession().setAttribute("user", user);//单行

        response.sendRedirect("/update.jsp");

    }
}

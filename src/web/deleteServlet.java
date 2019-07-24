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

public class deleteServlet extends HttpServlet {
    IserviceUser service = new serviceuserImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       新增
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String[]> map = request.getParameterMap();

        User user = JdbcUtil.tobean(User.class, map);

        int i = service.addAll(user);
        //          response.sendRedirect("/show");
        if (i == 1) {
            response.getWriter().write("<script>alert('新增成功！');location.href='/show'</script>");

        } else {
            response.getWriter().write("<script>alert('新增失败！');location.href='/show'</script>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       删除
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("deleteId");
        int i = service.deleteId(id);
        if (i == 1) {
            response.getWriter().write("<script>alert('删除成功！');location.href='/show'</script>");

        } else {
            response.getWriter().write("<script>alert('删除失败！');location.href='/show'</script>");

        }
    }
}

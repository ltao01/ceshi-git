package web;

import bean.Card;
import bean.User;
import service.IserviceUser;
import service.serviceuserImpl;
import util.JdbcUtil;
import util.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class showServlet extends HttpServlet {
    IserviceUser service = new serviceuserImpl();
    Page page = new Page();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //      模糊条件查询
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String[]> map = request.getParameterMap();
        page = JdbcUtil.tobean(Page.class, map);
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       执行分页查询
        String currpage = request.getParameter("currpage");
        if (currpage != null) {
            int i = Integer.parseInt(currpage);
            page.setStartpage(i);
        }
        HttpSession session = request.getSession();
        List<Card> list2 = service.selectCard();
        session.setAttribute("card", list2);//副表
        List<User> list = service.selectAll(page);

        session.setAttribute("list", list);//所有
        session.setAttribute("page", page);//分页
        response.sendRedirect("/show.jsp");

    }
}


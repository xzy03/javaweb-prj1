package cn.edu.zjut;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import cn.edu.zjut.model.UserBean;
import cn.edu.zjut.dao.UserDAO;
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("usertype");
        String source = request.getParameter("source");
        UserBean user=new UserBean();
        user.setUsername(username);
        user.setPassword(password);
        user.setType(type);
        if("login".equals(source)){
            if(checkUser(user)){
                request.setAttribute("USER", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/loginSuccess.jsp");
                dispatcher.forward(request, response);
            }else{
                response.sendRedirect("/javaweb_prj1_war_exploded/loginFailed.jsp");
            }
        }
        else if("register".equals(source)){
            UserDAO ud=new UserDAO();
            if(ud.addUser(user)){
                response.sendRedirect("/javaweb_prj1_war_exploded/login.jsp");
            }
        }

//        if("zjut".equals(username) && "zjut".equals(password)){
//            out.println("登录成功，欢迎您！");
//        }else{
//            out.println("用户名或密码错误！");
//        }
    }
//    boolean checkUser(UserBean user){
//        if ("zjut".equals(user.getUsername()) &&
//                "zjut".equals(user.getPassword())) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//    boolean checkUser(UserBean user){
//        if ("zjut".equals(user.getUsername()) &&
//                "zjut".equals(user.getPassword()) && "管理员".equals(user.getType())) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    boolean checkUser(UserBean user){
        UserDAO ud=new UserDAO();
        if( ud.searchUser(user) ) {
            return true;
        }
        return false;
    }
}

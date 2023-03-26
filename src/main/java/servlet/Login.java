package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.PW;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mail = request.getParameter("mail");
		String pw = request.getParameter("pw");
		
		// 入力されたIDをもとにソルトを取得する。
		String salt = kadaiDAO.getSalt(mail);
		
		// 取得したソルトがnullの場合は対象のユーザがいないので、Errorでログイン画面に戻す
		if(salt == null) {
			String view = "./?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		
		// 取得したソルトを使って入力したPWをハッシュ
		String hashedPw = PW.getSafetyPassword(pw, salt);
		
		// 入力されたID、ハッシュしたPWに一致するユーザを検索する
		kadai account = kadaiDAO.login(mail, hashedPw);
		
		// 一致するユーザがいなければ、ログイン失敗
		if(account == null) {
			String view = "./?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}else if(account.getMail().equals("root@morijyobi.ac.jp")) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", account);
			String view = "WEB-INF/view/Adminmenu.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response); 
		}else {
			// ログイン情報をセッションに登録
			HttpSession session = request.getSession();
			session.setAttribute("user", account);
			
			String view = "WEB-INF/view/Menu.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

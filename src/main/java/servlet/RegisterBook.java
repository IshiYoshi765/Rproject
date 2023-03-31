package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bookDAO;
import dto.bookDTO;

/**
 * Servlet implementation class RegisterStudentServlet
 */
@WebServlet("/RegisterBook")
public class RegisterBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		
		// フォーム入力内容の取得
		String isbn = request.getParameter("isbn");
		String bookname = request.getParameter("bookname");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		String illustrator = request.getParameter("illustrator");
		String booktype = request.getParameter("booktype");

		// 入力された情報を元にインスタンスを生成
		bookDTO book = new bookDTO(-1,isbn, bookname, publisher, author, illustrator, booktype);
		
		// SQL実行
		int result = bookDAO.registerbookDTO(book);
		
		if(result == 1) {
			String view = "WEB-INF/view/success.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else {
			String view = "WEB-INF/view/register.jsp";
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

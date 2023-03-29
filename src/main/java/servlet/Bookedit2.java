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
 * Servlet implementation class Bookedit2
 */
@WebServlet("/Bookedit2")
public class Bookedit2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bookedit2() {
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
		int bookid = Integer.parseInt(request.getParameter("ID"));
		String ISBN = request.getParameter("ISBN");
		String bookname = request.getParameter("bookname");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		String illustrator = request.getParameter("illustrator");
		int category_id = Integer.parseInt(request.getParameter("category_id"));
		String booktype = request.getParameter("booktype");
		String imagepass = request.getParameter("imagepass");

		// 入力された情報を元にインスタンスを生成
		bookDTO book = new bookDTO(bookid, ISBN, bookname, publisher,author,illustrator, category_id, booktype, imagepass);
		
		// SQL実行
		int result = bookDAO.updateBook(book);
		
		if(result == 1) {
			String view = "WEB-INF/view/Bookedit2.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else {
			String view = "WEB-INF/view/Bookedit2fail.jsp";
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

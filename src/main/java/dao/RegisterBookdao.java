package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.bookDTO;

public class RegisterBookdao {
	private	static Connection getConnection() throws URISyntaxException, SQLException{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	//INSERTプログラム
	public static int registerBook(bookDTO book) {
		String sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?)";
		int result =0;

		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book.getBookid());
			pstmt.setString(2, book.getIsbn());
			pstmt.setString(3, book.getBookname());
			pstmt.setString(4, book.getPublisher());
			pstmt.setString(5, book.getAuthor());
			pstmt.setString(6, book.getIllustrator());
			pstmt.setInt(7, book.getCategory_id());
			pstmt.setString(8, book.getBooktype());
			pstmt.setString(9, book.getImagepass());


			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	private int getId() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}
	public static List<bookDTO> selectListbook(){
		String sql = "SELECT * FROM book";
		List<bookDTO> list = new ArrayList<>();
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int bookid = rs.getInt("bookid");
					String isbn = rs.getString("isbn");
					String bookname = rs.getString("bookname");
					String publisher = rs.getString("publisher");
					String author = rs.getString("author");
					String illustrator = rs.getString("illustrator");
					int category_id = rs.getInt("category_id");
					String booktype = rs.getString("booktype");
					String imagepass = rs.getString("imagepass");
					
					
					bookDTO book = new bookDTO(bookid, isbn, bookname, publisher, author, illustrator, category_id, booktype, imagepass);
					list.add(book);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int DeleteBook(int bookid) {
		
		String sql = "DELETE FROM book WHERE bookid = ?";
		int result = 0;

		try (
				Connection con = getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
			
			pstmt.setInt(1, bookid);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件削除しました。");
		}
		return  result;
	}
	
}

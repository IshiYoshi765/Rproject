
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
import dto.user;
import util.PW;
import util.SALT;

public class bookDAO {

	private static Connection getConnection() throws URISyntaxException, SQLException {
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
	
	public static int registerAccount(user account) {
		String sql = "INSERT INTO users VALUES(default, ?, ?, ?, ?, ?)";
		int result = 0;
		
		// ランダムなソルトの取得(今回は32桁で実装)
		String salt = SALT.getSalt(32);
		
		// 取得したソルトを使って平文PWをハッシュ
		String hashedPw = PW.getSafetyPassword(account.getPassword(), salt);
		
		System.out.println("ハッシュに使うソルトは"+salt);
		System.out.println("登録されるハッシュ済みのPWは"+hashedPw);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, account.getName());
			pstmt.setString(2, account.getMail());
			pstmt.setString(3, account.getTel());
			pstmt.setString(4, salt);
			pstmt.setString(5, hashedPw);


			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	
	// メールアドレスを元にソルトを取得
	public static String getSalt(String mail) {
		String sql = "SELECT salt FROM users WHERE mail = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	// ログイン処理
	public static user login(String mail, String hashedPw) {
		String sql = "SELECT * FROM users WHERE mail = ? AND password = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			pstmt.setString(2, hashedPw);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String salt = rs.getString("salt");
					String tel = rs.getString("tel");
					
					return new user(id, name, mail, tel, salt, null, null);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int updateBook(bookDTO B) {
		
		String sql = "UPDATE book SET bookname = ? ,publisher = ?,author = ?,illustrator = ?,booktype = ?  where isbn = ? ";
		// return用の変数
		int result = 0;
		
		try (
				Connection con = getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
		

			pstmt.setString(1, B.getBookname());
			pstmt.setString(2, B.getPublisher());
			pstmt.setString(3, B.getAuthor());
			pstmt.setString(4, B.getIllustrator());
			pstmt.setString(5, B.getBooktype());
			pstmt.setString(6, "%"+B.getIsbn()+"%");
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件編集しました。");
		}
		return result;
	}
	

	// LIKEを使ったキーワード検索(部分一致)
	public static List<bookDTO> searchbookByName(String keyword){
		
		// 実行するSQL
		String sql = "SELECT * FROM book WHERE bookname  LIKE ?";
		
		// 返却用のLt istインスタンス
		List<bookDTO> result = new ArrayList<>();
				
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			// %や_はここで文字列結合する。そうすると'%keyword%'となる。
			pstmt.setString(1, "%" + keyword + "%");
			
			// SQL実行！
			// ResultSetもcloseする必要があるのでtry-with-resources文を使う
			try (ResultSet rs = pstmt.executeQuery()){
				
				// next()がfalseを返すまでループ
				while(rs.next()) {

					// n行目のデータを取得
					int bookid = rs.getInt("bookid");
					String isbn = rs.getString("isbn");
					String bookname = rs.getString("bookname");
					String publisher = rs.getString("publisher");
					String author = rs.getString("author");
					String illustrator = rs.getString("illustrator");
					int category_id = rs.getInt("category_id");
					String booktype = rs.getString("booktype");
					String imagepass = rs.getString("imagepass");

					// n件目のインスタンスを作成
					bookDTO book = new bookDTO(bookid, isbn, bookname, publisher, author, illustrator, category_id, booktype, imagepass);
					
					// インスタンスをListに追加
					result.add(book);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
		

	}
}

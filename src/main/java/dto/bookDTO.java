package dto;

public class bookDTO {
	private int bookid;
	private int isbn;
	private String bookname;
	private String publisher;
	private String author;
	private String illustrator ;
	private String category_id ;
	private String booktype ;
	private String imagepass ;
	
	public bookDTO(int bookid, int isbn, String bookname, String publisher, String author, String illustrator,
			String category_id, String booktype, String imagepass) {
		
		super();
		this.bookid = bookid;
		this.isbn = isbn;
		this.bookname = bookname;
		this.publisher = publisher;
		this.author = author;
		this.illustrator = illustrator;
		this.category_id = category_id;
		this.booktype = booktype;
		this.imagepass = imagepass;
	}


	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIllustrator() {
		return illustrator;
	}
	public void setIllustrator(String illustrator) {
		this.illustrator = illustrator;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	public String getImagepass() {
		return imagepass;
	}
	public void setImagepass(String imagepass) {
		this.imagepass = imagepass;
	}
	
	
}
package dto;

public class book {
	private int bookid;
	private String isbn;
	private String bookname;
	private String publisher;
	private String author;
	private String illustrator;
	private int category_id;
	private int booktype;
	private String imagepass;
	
	public book(int bookid, String isbn, String bookname, String publisher, String author, String illustrator,
			int category_id, int booktype, String imagepass) {
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
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

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getBooktype() {
		return booktype;
	}

	public void setBooktype(int booktype) {
		this.booktype = booktype;
	}

	public String getImagepass() {
		return imagepass;
	}

	public void setImagepass(String imagepass) {
		this.imagepass = imagepass;
	}
}
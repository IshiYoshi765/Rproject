package dto;

public class bookDTO {
	private int bookid;
	private String isbn;
	private String bookname;
	private String publisher;
	private String author;
	private String illustrator ;
	private String booktype ;
	
	public bookDTO(int bookid, String isbn, String bookname, String publisher, String author, String illustrator,
				String booktype) {

		
		super();
		this.bookid = bookid;
		this.isbn = isbn;
		this.bookname = bookname;
		this.publisher = publisher;
		this.author = author;
		this.illustrator = illustrator;
		this.booktype = booktype;
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
	public String getBooktype() {
		return booktype;
	}

	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
}
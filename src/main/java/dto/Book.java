package dto;

public class Book {
	private int isbn;
	private String bookname;
	private String publisher;
	private String author;
	private String illustrator;
	private int category_id;
	
	public Book(int isbn, String bookname, String publisher, String author, String illustrator, int category_id) {
		super();
		this.isbn = isbn;
		this.bookname = bookname;
		this.publisher = publisher;
		this.author = author;
		this.illustrator = illustrator;
		this.category_id = category_id;
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

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
}
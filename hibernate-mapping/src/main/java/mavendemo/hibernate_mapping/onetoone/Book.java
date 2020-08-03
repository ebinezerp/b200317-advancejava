package mavendemo.hibernate_mapping.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true, nullable = false)
	private String title;
	@Column(unique = false, nullable = false)
	private String tagLine;
	@Column(nullable = false)
	private Float price;

	@OneToOne
	private Author author;

	public Book() {
		super();
	}

	public Book(Integer id, String title, String tagLine, Float price, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.tagLine = tagLine;
		this.price = price;
		this.author = author;
	}

	public Book(String title, String tagLine, Float price, Author author) {
		super();
		this.title = title;
		this.tagLine = tagLine;
		this.price = price;
		this.author = author;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}

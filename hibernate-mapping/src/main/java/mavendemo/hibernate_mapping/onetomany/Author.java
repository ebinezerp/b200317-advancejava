package mavendemo.hibernate_mapping.onetomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer noOfBooks;

	@OneToMany(mappedBy = "author")
	private List<Book> books;

	public Author() {
		super();
	}

	public Author(Integer id, String name, Integer noOfBooks, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.noOfBooks = noOfBooks;
		this.books = books;
	}

	public Author(String name, Integer noOfBooks) {
		super();
		this.name = name;
		this.noOfBooks = noOfBooks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks(Integer noOfBooks) {
		this.noOfBooks = noOfBooks;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}

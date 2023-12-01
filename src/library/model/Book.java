package library.model;
// создаем класс Book c полями ISBN, автор, название книги, год издания;
// создаем интерфейс Library с методами:
// добавить книгу;
// удалить книгу;
// найти книгу;
// кол-во книг;
// напечатать список книг.
// создаем класс LibraryImpl, который implements Library;
// создаем класс LibraryImplTest, в котором создаем тесты для вышеперечисленных методов.

public class Book implements Comparable<Book>{

    //fields
    protected long isbn;
    protected String author;
    protected String title;
    protected int yearPublication;

    // constructor
    public Book(long isbn, String author, String title, int yearPublication) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.yearPublication = yearPublication;
    }

    // getter and setter
    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    // method toSting
    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yearPublication=" + yearPublication +
                '}';
    }

    // method equals and hashCode
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Book book = (Book) object;

        return isbn == book.isbn;
    }

    @Override
    public int hashCode() {
        return (int) (isbn ^ (isbn >>> 32));
    }

    @Override
    public int compareTo(Book o) {
        int res = this.author.compareTo(o.author);
        return res != 0 ? res : this.title.compareTo(o.title);
    }
}
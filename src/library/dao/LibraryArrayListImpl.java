package library.dao;

import library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryArrayListImpl implements Library{

    // fields
    private List<Book> bookList; // список книг

    // constructor
    public LibraryArrayListImpl() {
        this.bookList = new ArrayList<>(); // список книг при создании объекта
    }

    @Override
    public boolean addBook(Book book) {
        if(book != null && !bookList.contains(book)) {
            bookList.add(book);
            return true;
        }
        return false;
    }

    @Override
    public Book removeBook(long isbn) {
        Book victim = findBook(isbn);
        if(victim != null) {
            bookList.remove(victim);
        }
        return victim;
    }

    @Override
    public Book findBook(long isbn) {
        return bookList.stream()
                .filter(book -> book.getIsbn() == isbn)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int quantity() {
        return bookList.size();
    }

    @Override
    public void printBook() {
        bookList.forEach(System.out::println);
    }

    @Override
    public Book[] findBookByAuthor(String author) {
        return bookList.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .toArray(Book[]::new);
    }
}

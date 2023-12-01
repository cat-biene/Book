package library.dao;

import library.model.Book;

import java.util.HashSet;

public class LibraryHashSetImpl implements Library{

    private HashSet<Book> books;

    public LibraryHashSetImpl() {
        this.books = new HashSet<>();
    }

    @Override
    public boolean addBook(Book book) {
        if(book != null && !books.contains(book)) {
            books.add(book);
            return true;
        }
        return false;
    }

    @Override
    public Book removeBook(long isbn) {
        Book victim = findBook(isbn);
        if(victim != null) {
            books.remove(victim);
        }
        return victim;
    }

    @Override
    public Book findBook(long isbn) {
        return books.stream()
                .filter(book -> book.getIsbn() == isbn)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int quantity() {
        return books.size();
    }

    @Override
    public void printBook() {
        books.forEach(System.out::println);
    }

    @Override
    public Book[] findBookByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .toArray(Book[]::new);
    }
}

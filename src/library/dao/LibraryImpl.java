package library.dao;
// создаем класс Book c полями ISBN, автор, название книги, год издания;
// создаем интерфейс Library с методами:
// добавить книгу;
// удалить книгу;
// найти книгу;
// кол-во книг;
// напечатать список книг.
// создаем класс LibraryImpl, который implements Library;
// создаем класс LibraryImplTest, в котором создаем тесты для вышеперечисленных методов.

import library.dao.Library;
import library.model.Book;

public class LibraryImpl implements Library {

    //fields
    private Book[] books; //создаем массив для хранения книг
    private int size; // текущее количество книг

    public LibraryImpl(int capacity) { // создаем место для хранения книг в библиотеке
        books = new Book[capacity];
    }

    @Override
    public boolean addBook(Book book) {
        if (size == books.length || book == null || findBook(book.getIsbn()) != null) {
            return false;
        }
        books[size] = book;
        size++;
        return true;
    }

    @Override
    public Book removeBook(long isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn) {
                Book removeBook = books[i];
                books[i] = books[size - 1];
                books[size - 1] = null;
                size--;
                return removeBook;
            }
        }
        return null;
    }


    @Override
    public Book findBook(long isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn) {
                return books[i];
            }
        }
        return null;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public void printBook() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    @Override
    public Book[] findBookByAuthor(String author) {
        int count = 0;
        // считаем сколько будет элементов массива, удовлитворяющих условию
        for (int i = 0; i < size; i++) {
            if(books[i].getAuthor().equals(author)) {
                count++;
            }
        }
        Book[] res = new Book[count]; // создаем массив размером count
        // заполняем массив res
        for (int i = 0, j = 0; j < res.length; i++) {
            if(books[i].getAuthor().equals(author)) {
                res[j++] = books[i];
            }
        }
        return res; // это возвращаемый массив
    }
}

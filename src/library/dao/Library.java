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


import library.model.Book;

public interface Library {

    boolean addBook(Book book);
    Book removeBook(long isbn);
    Book findBook(long isbn);
    int quantity();
    void printBook();
    Book[] findBookByAuthor(String author);
}

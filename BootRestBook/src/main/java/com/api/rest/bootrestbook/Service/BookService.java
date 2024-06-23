package com.api.rest.bootrestbook.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.stereotype.Component;

import com.api.rest.bootrestbook.Model.Book;

@Component
public class BookService {

    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book(1234, "JavaCore", "ABC"));
        books.add(new Book(345, "Hibernate", "XYZ"));
        books.add(new Book(876, "Spring", "NMUSD"));
        books.add(new Book(675, "SpringBoot", "HPM"));
    }

    // Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Get Single Book by ID
    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null; // Return null if the book is not found
    }

    // Add new book
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    // Delete book by ID
    public boolean deleteBook(int id) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
                return true; // Book deleted successfully
            }
        }
        return false; // Book with given id not found
    }

     // Update book by ID
     public Book updateBook(int id, Book updatedBook) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setName(updatedBook.getName());
                book.setAuthor(updatedBook.getAuthor());
            
                return book;
            }
        }
        return null; // Return null if the book with given id is not found
    }
}

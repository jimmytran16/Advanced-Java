package api;

import java.util.ArrayList;


import domain.Book;

public interface LibraryInterface {
		public ArrayList <Book> getBooks();
		public void removeBook(int book);
		public Book getBook(int index2);
		
		public void loadLibraryFromCSV(String x);
		void addBook(Book newNumBook);

}

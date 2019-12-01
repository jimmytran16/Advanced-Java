package domain;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import api.LibraryInterface;
import domain.Book;

/**
 * 
 *
 *
 * The Library class represents a collection of books and provides certain
 * methods for managing the code. This includes creating Attributes, a
 * Constructor, and Methods.
 * 
 *
 *
 */

public class Library implements LibraryInterface {
	private ArrayList <Book> bookList;
	public Library() {
			
		this.bookList = new ArrayList <Book>();
	}

/*returns list of books*/
	@Override
	public ArrayList<Book> getBooks() {
		ArrayList <Book> booksCopy = new ArrayList <Book> ();
		
			for (Book book : bookList) {
				booksCopy.add (book);
		
			}
			return booksCopy;
	}

	
	@Override
	public void addBook (Book newNumBook) {
		
		bookList.add (newNumBook);
	}

/*removes the book from the list*/
	@Override
	public void removeBook (int indexValue) {
		
		if (bookList.size() > indexValue) {
				bookList.remove (indexValue);
		
			} else {
				System.out.println("Index is unvalid...");
		}
	}
/*gets the book object from the list based on the index*/
	@Override
	public Book getBook(int index2) {
		
		if (index2 < bookList.size()) {
			
			Book thisBookValue = bookList.get (index2);
			return thisBookValue;
		}
		return null;
	}

	public String toString() {
		String string = "";

		for (Book book : bookList) {
			string += "Index: " + bookList.indexOf(book) + " " + book.toString() + "\n";
		}
		return string;
	}


/*Loads all of the books information from csv file and loads into the book objects and put into an array list
 * Book title, author , genre , and the path of the book
 *  */
	@Override
	public void loadLibraryFromCSV(String csvFilename) {
		
		String bookTitle = "";
		String bookAuthor = "";
		String bookGenre = "";
		String bookFilepath = "";
		
		try {
			@SuppressWarnings("resource")
			Scanner myScanner = new Scanner (new File(csvFilename));
			while (myScanner.hasNextLine()) {
			
				final String DELIMETERS = ",";
				String line = myScanner.nextLine();
				@SuppressWarnings("resource")
				Scanner lineScan = new Scanner (line);
				lineScan.useDelimiter(DELIMETERS);
				
				bookTitle = lineScan.next();
				bookAuthor = lineScan.next();
				bookGenre = lineScan.next();
				bookFilepath = lineScan.next();
			
			Book bookInfo = new Book(bookTitle, bookAuthor);
				bookInfo.setGenre(bookGenre);
				bookInfo.setFilename(bookFilepath);
				bookList.add(bookInfo);
			}
							
		} catch (FileNotFoundException e) {
			System.out.println("Invalid selection!");
		
		}
	}
}

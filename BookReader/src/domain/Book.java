package domain;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import api.BookInterface;

/**
 *
 *
 * In the Book class, I created four attributes that were all String Objects. I
 * also created a Constructor and a Method using setters and getters,
 * toString(), isValid(), and getText() with with the attributes I created.
 *
 *
 */

public class Book implements BookInterface {

	/* Instance Variables */
	private String title;
	private String author;
	private String genre;
	private String fileName;

	/* Construcor */
	public Book(String titleT, String author) {
		this.title = titleT;
		this.author = author;
		this.genre = null;
		this.fileName = null;

	}

	/* Setters and Getters */
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setFilename(String fileName) {
		this.fileName = fileName;
	}

	public String getFilename() {
		return fileName;
	}

	/* isValid Method */
	public boolean isValid() {
		if (fileName != null) {
			File file = new File(fileName);

			if (title != null && author != null && genre != null && file.exists()) {
				return true;

			} else {
				return false;

			}
		}
		return false;
	}

	/* getText Method - returns the the book content */
	public String getText() {
		String fileList = "";
		fileName = this.getFilename();

		try {
			@SuppressWarnings("resource")
			Scanner fileScanner = new Scanner(new File(fileName));

			while (fileScanner.hasNextLine()) {
				fileList += "                      			"+ fileScanner.nextLine() + "\n";
			}

		} catch (FileNotFoundException e) {
			System.out.println("File was unable to open");
		}
		return fileList;
	}

	/* toString Methods */
	public String toString() {

		String stringList = "Title: " + title + " 		Author: " + author + " 		Genre: " 
				+ genre;

		return stringList;
	}

}

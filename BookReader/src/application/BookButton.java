package application;
import javax.swing.JButton;

import domain.Book;

/**
 * 
 *
 */

public class BookButton extends JButton{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Book books;
	private String colon = ":";
	
	public BookButton (Book  title_book_list) {
		
		this.books=title_book_list;
	
		if (title_book_list.getTitle().length() > 20) {
			setText (title_book_list.getTitle().substring(0 , 19) + colon);
		} else {
			setText (title_book_list.getTitle() );
		}
			setToolTipText (title_book_list.toString());
	
	}
	public Book getBook() {
		return books;		
	}
}


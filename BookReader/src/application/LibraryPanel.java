package application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import domain.Book;
import domain.Library;

/** JPanel responsible for Items and associated GUI components. 
 * 
 */
public class LibraryPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//instance variables
	// ONLY those values that we need to access
	// in the listeners defined within this class
	private ActionListener itemButtonListener;
	private JTextField loadBookTextField;
	private JPanel buttonListPanel;
	private ArrayList<Book> books;
	

	/**Configure panel components and layout.
	 * @param itemButtonListener to register with all ItemButtons
	 */
	public LibraryPanel(ActionListener itemButtonListener) {
		//remember this so we can register it with any future ItemButtons
		this.itemButtonListener = itemButtonListener;

		//configure the button list panel and the scroll pane that holds it
		buttonListPanel = new JPanel();
		buttonListPanel.setLayout(new BoxLayout(buttonListPanel, BoxLayout.Y_AXIS));
		buttonListPanel.setBorder(BorderFactory.createTitledBorder("ButtonListPanel"));
		JScrollPane buttonListScroll = new JScrollPane(buttonListPanel);
		buttonListScroll.setPreferredSize(new Dimension(128,256));
		buttonListScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		buttonListScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		buttonListScroll.setBorder(BorderFactory.createTitledBorder("ButtonListScroll"));

		//configure the text field and button for determining how many ItemButtons to create
		CreateItemsListener createItemsListener = new CreateItemsListener();
		loadBookTextField = new JTextField(10);
		loadBookTextField.setToolTipText("Number of Items to create.\nMust be a positive integer.");
		loadBookTextField.addActionListener(createItemsListener);
		JButton createItemsButton = new JButton("Load Books");
		createItemsButton.addActionListener(createItemsListener);
		//configure the panel to organize the text field and button
		JPanel createItemsPanel = new JPanel();
		createItemsPanel.setLayout(new BoxLayout(createItemsPanel, BoxLayout.X_AXIS));
		createItemsPanel.add(Box.createHorizontalGlue());
		createItemsPanel.add(loadBookTextField);
		createItemsPanel.add(createItemsButton);
		createItemsPanel.add(Box.createHorizontalGlue());
		createItemsPanel.setBorder(BorderFactory.createTitledBorder("Load Book List"));

		//configure this panel to organize the button list and configuration panes/panels
		this.setLayout(new BorderLayout());
		this.add(buttonListScroll, BorderLayout.CENTER);
		this.add(createItemsPanel, BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createTitledBorder("CollectionMgmtPanel"));
	}

	
	private class CreateItemsListener implements ActionListener {
		@Override
		/*Event handler for when the 'LOAD BOOKS' buttons is clicked on*/
		public void actionPerformed(ActionEvent event) {
			String filename = loadBookTextField.getText().trim();
			Library lib = new Library();
			lib.loadLibraryFromCSV(filename);
			books = new ArrayList<Book>(lib.getBooks());
				
				
				/*Displays all of the books and its names*/
				for (int i = 0; i < books.size(); i++) {
					BookButton button = new BookButton(books.get(i));
					button.addActionListener(itemButtonListener);
					buttonListPanel.add(button);
				}
				buttonListPanel.revalidate();
		}
	}
}

package application;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

import domain.Book;
/**JPanel that displays info related to an Item.
 * 
 */
public class ReadersPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//instance variables
	// ONLY those values that we need to access
	// in the listeners defined within this class
	private JLabel itemLabel;
	private JTextArea itemTextArea;
	private JLabel itemLabelLabel;
	private JScrollPane itemTextScroll;
	private JPanel navigationPanel;
	/** Initialize and layout components to display information about an Book */
	public ReadersPanel() {
		//instantiate and initialize labels to include in infoPanel
		itemLabelLabel = new JLabel("Book: ");
		itemLabel = new JLabel("");
		//configure infoPanel and add components
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		infoPanel.setBorder(BorderFactory.createTitledBorder("InfoPanel"));
		infoPanel.add(Box.createHorizontalGlue());
		infoPanel.add(itemLabelLabel);
		infoPanel.add(itemLabel);
		infoPanel.add(Box.createHorizontalGlue());
		//instantiate and configure the text area
		itemTextArea = new JTextArea();
		itemTextArea.setLineWrap(true);
		itemTextArea.setWrapStyleWord(true);
		itemTextArea.setEditable(false);
		itemTextArea.setBorder(BorderFactory.createTitledBorder("BookTextArea"));
		//set up the scroll pane to hold the text area
		itemTextScroll = new JScrollPane(itemTextArea);
		itemTextScroll.setPreferredSize(new Dimension(200,200));
		itemTextScroll.setBorder(BorderFactory.createTitledBorder("BookTextScrollePane"));
		
		navigationPanel = new JPanel() ;
		navigationPanel.setBorder(BorderFactory.createTitledBorder("NavigationPanel"));




		//set up this DisplayPanel's layout and add sub-panels/panes
		this.setLayout(new BorderLayout());
		this.add(infoPanel, BorderLayout.NORTH);
		this.add(itemTextScroll, BorderLayout.CENTER);
		this.add(navigationPanel , BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createTitledBorder("ReaderPanel"));
		
		/*Set buttons for navagation panel*/
		JButton page_up = new JButton("PageUp");
		JButton page_down = new JButton("PageDown");
		/*Adds buttons to the navigation panel*/
		navigationPanel.add(page_up);
		navigationPanel.add(page_down);
		
		
	
	}

	/** Update components to report on the given book
	 * @param item the Item being reported
	 */
	public void loadItem(Book book) {
		String content = book.getText();
		itemLabelLabel.setText("Book: " +book.toString());
		itemTextScroll.getViewport().setViewPosition(new Point(0,0));
		itemTextArea.setText(content);
		this.revalidate();

		
	}
}

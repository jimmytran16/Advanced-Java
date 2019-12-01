package application;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/** Top-level JPanel for BigLayoutDemo - coordinates between two sub-panels.
 * 
 */
@SuppressWarnings("serial")
public class ReaderOfBooksPanel extends JPanel {
	private LibraryPanel collectionPanel;
	private ReadersPanel displayPanel;
	
	/**Constructor */
	public ReaderOfBooksPanel() {
		collectionPanel = new LibraryPanel(new ItemButtonListener());				
		displayPanel = new ReadersPanel();
		
		this.setLayout(new BorderLayout());
		this.add(collectionPanel, BorderLayout.WEST);
		this.add(displayPanel, BorderLayout.CENTER);
		
		this.setBorder(BorderFactory.createTitledBorder("TopCoordinatorPanel"));
	}
	
	/** Load selected Item into DisplayPanel */
	private class ItemButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			BookButton bookButton = (BookButton)(e.getSource());
			displayPanel.loadItem(bookButton.getBook());
		}
	}
}

package api;

public interface BookInterface {
	/*Declares all of the function in the BookInterface*/
	public String getText();

	public String getAuthor();

	public void setAuthor(String newAuthor);

	public void setTitle(String newTitle);

	public String getTitle();

	public void setGenre(String genre);

	public String getGenre();

	public void setFilename(String filename);

	public String getFilename();

	public boolean isValid();
}

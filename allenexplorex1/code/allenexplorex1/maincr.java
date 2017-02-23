package allenexplorex1;

public class maincr {

	public static void main(String[] args){
		texture.frame.setSize(1000,600); //base container size
		texture.frame.setResizable(false); //game window cannot change size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// get resolution
		texture.frame.setLocation(screenSize.width/2-500,screenSize.height/2-300);// determine the base container's position on the screen
		texture.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		texture.frame.setVisible(true);
		texture.menu.mainmenu();
	}
}

package formend;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserInfoPage extends JPanel{
    /**
	 * this is used to return the page of user information
	 */
	private static final long serialVersionUID = -2101785257067122943L;

	public UserInfoPage(){
        JLabel label = new JLabel("The UserInfoPage");
        this.add(label);
    }
}

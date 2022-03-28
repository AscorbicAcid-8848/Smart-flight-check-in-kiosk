import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitPage extends JFrame implements ActionListener {
    //最高级panel：所有页面的容器
    private JPanel framePanel;

    //与InitPage 有关的组件以及容器
    private JButton button_bookNum;// = new JButton("Booking Number");
    private JButton button_UserInfo; //= new JButton("User info");
    private JButton button_Scan; //= new JButton("Scan ID document");
    private JPanel panel_InitPage;// = new JPanel();

    //UserInfoPage
    private UserInfoPage panel_UserInfoPage;
    private JButton button_userinfo_backToInit;

    public InitPage(){//此方法作用：初始化Frame 及framePanel，不作对于panel的修改

        framePanel = new JPanel();
        setPanelInitPage();
        setOtherPages();
        showInitPage();//第一次进入，展示initpage内容
        setBounds(300,300,500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void setPanelInitPage(){

        JLabel label_Login = new JLabel("Welcome, Choose a way to login!");
        button_bookNum = new JButton("Booking Number");
        button_UserInfo = new JButton("User info");
        button_Scan = new JButton("Scan ID document");
        panel_InitPage = new JPanel();

        button_bookNum.addActionListener(this);
        button_UserInfo.addActionListener(this);
        button_Scan.addActionListener(this);

        panel_InitPage.setLayout(new GridLayout(4,1));
        panel_InitPage.add(label_Login);
        panel_InitPage.add(button_bookNum);
        panel_InitPage.add(button_UserInfo);
        panel_InitPage.add(button_Scan);

    }
    public void showInitPage(){
        add(framePanel);
        framePanel.add(panel_InitPage);
    }
    public void setOtherPages(){
        panel_UserInfoPage = new UserInfoPage();
        button_userinfo_backToInit = panel_UserInfoPage.getButton_backToInit();
        button_userinfo_backToInit.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button_bookNum){
            //测试：点击此按钮进入userinfo界面
            framePanel.removeAll();
            framePanel.repaint();
            framePanel.add(panel_UserInfoPage);
            framePanel.validate();
        }
        if(e.getSource() == button_userinfo_backToInit){
            framePanel.removeAll();
            framePanel.repaint();
            framePanel.add(panel_InitPage);
            framePanel.validate();
        }
    }
}

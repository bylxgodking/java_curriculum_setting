package cn.edu.ccst.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/09/15:32
 * @Description:
 */
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * 界面工具类.
 *
 * @author
 */
public class FrmUtil {
    public static final String title = "XXX图书馆管理系统";//系统标题
    public static final int fontSize = 24;//控件字体大小
    public static final String MANAGER_USER = "1";//管理员
    public static final String OPRATOR_USER = "2";//操作员
    public static final String READER_USER = "3";//读者

    /**
     * 居中显示指定框架.
     *
     * @param f 框架
     */
    public static void centerFrm(JFrame f) {

        Dimension dsSize = Toolkit.getDefaultToolkit().getScreenSize();

        f.setLocation(dsSize.width / 2 - f.getWidth() / 2, dsSize.height / 2 - f.getHeight() / 2);
        f.setTitle(title);
        f.setResizable(false);
    }

    /**
     * 退出系统.
     *
     */
    public static void exitSystem() {
        System.exit(0);
    }

    /**
     * 统一设置swing组件的字体.
     *
     * @param fontSize 字体大小
     */
    public static void setMyLookAndFeel(int fontSize) {
        try {
            //设置windows风格的look and feel
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

            Font font = new Font("宋体", Font.PLAIN, fontSize);//字体为宋体，样式为常规，字号12
            UIManager.put("MenuBar.font", font);
            UIManager.put("MenuItem.font", font);
            UIManager.put("Menu.font", font);
            UIManager.put("PopupMenu.font", font);
            UIManager.put("ToolBar.font", font);
            UIManager.put("ToolTip.font", font);
            UIManager.put("TabbedPane.font", font);
            UIManager.put("Label.font", font);
            UIManager.put("JLabel.font", font);
            UIManager.put("List.font", font);
            UIManager.put("ComboBox.font", font);
            UIManager.put("Button.font", font);
            //UIManager.put("Table.font", font);
            UIManager.put("TableHeader.font", font);
            UIManager.put("Tree.font", font);
            UIManager.put("TextField.font", font);
            UIManager.put("JTextField.font", font);
            UIManager.put("PasswordField.font", font);
            UIManager.put("TextArea.font", font);
            UIManager.put("TitledBorder.font", font);
            //UIManager.put("OptionPane.font", font);
            UIManager.put("RadioButton.font", font);
            UIManager.put("CheckBox.font", font);
            UIManager.put("ToggleButton.font", font);
            UIManager.put("Dialog.font", font);
            UIManager.put("Panel.font", font);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


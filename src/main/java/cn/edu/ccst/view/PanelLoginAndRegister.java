package cn.edu.ccst.view;

import cn.edu.ccst.model.User;
import cn.edu.ccst.util.FrmUtil;
import cn.edu.ccst.util.StringUtil;
import cn.edu.ccst.swing.Button;
import cn.edu.ccst.swing.MyPasswordField;
import cn.edu.ccst.swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import cn.edu.ccst.service.impl.UserServiceImpl;

import net.miginfocom.swing.MigLayout;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    public User getUser() {
        return user;
    }

    private User user;

    public PanelLoginAndRegister(ActionListener eventRegister) {
        initComponents();
        initRegister(eventRegister);
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
    }

    private void initRegister(ActionListener eventRegister) {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        register.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtUser.setHint("Name");
        register.add(txtUser, "w 60%");
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/mail.png")));
        txtEmail.setHint("Type");
        register.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Password");
        register.add(txtPass, "w 60%");
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventRegister);
        cmd.setText("SIGN UP");
        register.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String userName = txtUser.getText().trim();
                String type = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                user = new User("0", userName, type, password);

                //UserMapper userServiceImpl = null;
                if (new UserServiceImpl().queryUserByName(userName) != null) {
                    new Message().showMessage(Message.MessageType.ERROR,"用户已经存在！");
                    txtUser.requestFocus();
                    txtUser.setHint("请输入账户");

                }
                if (!StringUtil.hasLength(userName)) {
                    new Message().showMessage(Message.MessageType.ERROR,"用户姓名不能为空！");
                    txtUser.requestFocus();
                    return;
                }

                if (type.equals("1")) {
                    type = FrmUtil.OPRATOR_USER;
                } else {
                    type = FrmUtil.READER_USER;
                }
                if (new UserServiceImpl().addUser(new User(String.valueOf(Integer.valueOf(new UserServiceImpl().getAllIdCount())+1),userName,"123456",type))) {
                    //JOptionPane.showMessageDialog(this, "用户添加成功！");
                    new Message().showMessage(Message.MessageType.SUCCESS,"用户添加成功！");
                    new Main().setVisible(true);

                } else {
                    new Message().showMessage(Message.MessageType.ERROR,"用户添加失败！");
                }
            }
        });
    }

    private void initLogin() {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/mail.png")));
        txtEmail.setHint("Username");
        login.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");
        JButton cmdForget = new JButton("Forgot your password ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN IN");
        login.add(cmd, "w 40%, h 40%");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 登陆系统
                if (!StringUtil.hasLength(txtEmail.getText().trim())) {
                    //JOptionPane.showMessageDialog(this, "用户id不能为空！");
                    txtEmail.requestFocus();
                    return;
                }
                if (!StringUtil.hasLength(txtPass.getText().trim())) {
                    //JOptionPane.showMessageDialog(this, "用户密码不能为空！");
                    txtPass.requestFocus();
                    return;
                }

                User user = new UserServiceImpl().queryUserById(txtEmail.getText().trim());
                if(user == null || !user.getPassword().equals(txtPass.getText().trim())){
                    //JOptionPane.showMessageDialog(this, "用户id或密码错！");
                    txtEmail.requestFocus();
                    return;
                }

                new MainFrm(user).setVisible(true);


            }
        });
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}

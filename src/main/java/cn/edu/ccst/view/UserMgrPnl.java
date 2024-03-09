package cn.edu.ccst.view;

import cn.edu.ccst.mapper.UserMapper;
import cn.edu.ccst.model.User;
import cn.edu.ccst.service.impl.UserServiceImpl;
import cn.edu.ccst.util.FrmUtil;
import cn.edu.ccst.util.MybatisUtil;
import cn.edu.ccst.util.StringUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import javax.swing.JOptionPane;


/**
 * 用户管理主界面.
 *
 * @author
 */
public class UserMgrPnl extends javax.swing.JPanel {

    private User userLogin;
    private UserServiceImpl userServiceImpl;

    /**
     * Creates new form UserMgrPnl
     */
    public UserMgrPnl(User user) {
        this.userLogin = user;
        userServiceImpl = new UserServiceImpl();
        initComponents();

        resetFrmOfUp();
        resetFrmOfDown();
        //根据用户角色 控制 界面访问权限
        if (!userLogin.getType().equals(FrmUtil.MANAGER_USER)) {
            pnlUserUpdate.setVisible(false);
        }
    }


    /**
     * 重置界面上部组件.
     */
    public void resetFrmOfUp() {

        txtOldPassword.setText("");
        txtNewPassword.setText("");
        txtNewPassword2.setText("");
    }

    /**
     * 重置界面下部组件.
     */
    public void resetFrmOfDown() {
        txtUserId.setText("");
        txtUserName.setText("");
        cmbType.setSelectedItem("读者");
    }

    /**
     * 用户编号文本框回车或丢失焦点后的执行的操作.
     *
     * 查询用户是否存在，如果存在显示用户姓名<br>
     */
    public void opAfterEnterOrLost() {
        String strUserId = txtUserId.getText().trim();
        if (!StringUtil.hasLength(strUserId)) {;
            return;
        }
        User user = userServiceImpl.queryUserById(strUserId);
        if (user != null) {
            txtUserName.setText(user.getName());
            String item = user.getType().equals(FrmUtil.OPRATOR_USER) ? "操作员" : "读者";
            cmbType.setSelectedItem(item);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlModPassword = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtOldPassword = new javax.swing.JPasswordField();
        txtNewPassword = new javax.swing.JPasswordField();
        txtNewPassword2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnModPassword = new javax.swing.JButton();
        pnlUserUpdate = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox();
        btnUserAdd = new javax.swing.JButton();
        btnUserDel = new javax.swing.JButton();
        btnResetPassword = new javax.swing.JButton();

        pnlModPassword.setBorder(javax.swing.BorderFactory.createTitledBorder("修改密码"));

        jLabel1.setText("请输入原密码：");

        jLabel2.setText("请输入新密码：");

        jLabel3.setText("请再次输入密码：");

        btnModPassword.setText("修  改");
        btnModPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlModPasswordLayout = new javax.swing.GroupLayout(pnlModPassword);
        pnlModPassword.setLayout(pnlModPasswordLayout);
        pnlModPasswordLayout.setHorizontalGroup(
            pnlModPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModPasswordLayout.createSequentialGroup()
                .addGroup(pnlModPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlModPasswordLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(pnlModPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlModPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel2))
                        .addGap(49, 49, 49)
                        .addGroup(pnlModPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtOldPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNewPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(txtNewPassword)))
                    .addGroup(pnlModPasswordLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btnModPassword)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlModPasswordLayout.setVerticalGroup(
            pnlModPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModPasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlModPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlModPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlModPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNewPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModPassword)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlUserUpdate.setBorder(javax.swing.BorderFactory.createTitledBorder("更新用户信息"));

        jLabel4.setText("用户编号：");

        txtUserId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIdActionPerformed(evt);
            }
        });
        txtUserId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserIdFocusLost(evt);
            }
        });

        jLabel5.setText("用 户 名：");

        jLabel6.setText("用户角色：");

        cmbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "操作员", "读者" }));

        btnUserAdd.setText("添加用户");
        btnUserAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserAddActionPerformed(evt);
            }
        });

        btnUserDel.setText("删除用户");
        btnUserDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserDelActionPerformed(evt);
            }
        });

        btnResetPassword.setText("重置密码");
        btnResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUserUpdateLayout = new javax.swing.GroupLayout(pnlUserUpdate);
        pnlUserUpdate.setLayout(pnlUserUpdateLayout);
        pnlUserUpdateLayout.setHorizontalGroup(
            pnlUserUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserUpdateLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(pnlUserUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUserUpdateLayout.createSequentialGroup()
                        .addComponent(btnUserAdd)
                        .addGap(48, 48, 48)
                        .addComponent(btnUserDel)
                        .addGap(42, 42, 42)
                        .addComponent(btnResetPassword))
                    .addGroup(pnlUserUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlUserUpdateLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(53, 53, 53)
                            .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlUserUpdateLayout.createSequentialGroup()
                            .addGroup(pnlUserUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(53, 53, 53)
                            .addGroup(pnlUserUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(286, Short.MAX_VALUE))
        );
        pnlUserUpdateLayout.setVerticalGroup(
            pnlUserUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlUserUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlUserUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(pnlUserUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUserAdd)
                    .addComponent(btnUserDel)
                    .addComponent(btnResetPassword))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlModPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlUserUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlModPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlUserUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /*
    **
    * @Description: 修改密码逻辑修复完毕
    * @Param: [evt]
    * @return: void
    * @Author: LuoXinYu
    * @Date: 2024/3/10
    */
    private void btnModPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModPasswordActionPerformed
        // 修改密码
        String passNew = txtNewPassword.getText().trim();
        String passNew2 = txtNewPassword2.getText().trim();
        if (!passNew.equals(passNew2)) {
            JOptionPane.showMessageDialog(this, "两次输入的密码不一致，请重新输入！");
            txtNewPassword.requestFocus();
            return;
        }
        String passOld = txtOldPassword.getText().trim();
        if (!passOld.equals(userLogin.getPassword())) {
            //System.out.println("原密码是="+userLogin.getPassword());
            JOptionPane.showMessageDialog(this, "原密码不正确，请重新输入！");
            resetFrmOfUp();//重置界面上半部分
            txtOldPassword.requestFocus();
            return;
        }
             userLogin.setPassword(passNew);
        if (!userServiceImpl.modUserPassword(userLogin)) {
            JOptionPane.showMessageDialog(this, "修改密码失败，请联系管理员！");

        } else {
            JOptionPane.showMessageDialog(this, "密码修改成功！");
            resetFrmOfUp();
        }
    }//GEN-LAST:event_btnModPasswordActionPerformed

    private void btnUserAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAddActionPerformed
        // 添加用户 用户编号不能重复
        String strUserId = txtUserId.getText().trim();
        if (!StringUtil.hasLength(strUserId)) {
            JOptionPane.showMessageDialog(this, "用户编号不能为空！");
            txtUserId.requestFocus();
            return;
        }
        if (userServiceImpl.queryUserById(strUserId) != null) {
            JOptionPane.showMessageDialog(this, "用户已经存在，请重新输入！");
            txtUserId.requestFocus();
            return;
        }

        String strUserName = txtUserName.getText().trim();
        if (!StringUtil.hasLength(strUserName)) {
            JOptionPane.showMessageDialog(this, "用户姓名不能为空！");
            txtUserName.requestFocus();
            return;
        }
        String strUserType = ((String) cmbType.getSelectedItem()).trim();
        if (strUserType.equals("操作员")) {
            strUserType = FrmUtil.OPRATOR_USER;
        } else {
            strUserType = FrmUtil.READER_USER;
        }
        if (userServiceImpl.addUser(new User(strUserId, strUserName, null, strUserType))) {
            JOptionPane.showMessageDialog(this, "用户添加成功！");
            resetFrmOfDown();
        } else {
            JOptionPane.showMessageDialog(this, "用户添加失败，请联系管理员！");
        }

    }//GEN-LAST:event_btnUserAddActionPerformed

    private void btnUserDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserDelActionPerformed
        // 删除用户
        String strUserId = txtUserId.getText().trim();
        if (!StringUtil.hasLength(strUserId)) {
            JOptionPane.showMessageDialog(this, "用户编号不能为空！");
            txtUserId.requestFocus();
            return;
        }
        String strUserName = txtUserName.getText().trim();
        if (!StringUtil.hasLength(strUserName)) {
            JOptionPane.showMessageDialog(this, "用户姓名不能为空！");
            txtUserName.requestFocus();
            return;
        }

        User user = userServiceImpl.queryUserById(strUserId);
        if (!user.getName().equals(strUserName)) {
            JOptionPane.showMessageDialog(this, "用户姓名不正确，无法删除！");
            txtUserId.requestFocus();
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "确认删除？") == JOptionPane.OK_OPTION) {
            if (userServiceImpl.delUser(user)) {
                JOptionPane.showMessageDialog(this, "删除成功！");
                resetFrmOfDown();
            } else {
                JOptionPane.showMessageDialog(this, "删除失败，请联系管理员！");
            }
        }
    }//GEN-LAST:event_btnUserDelActionPerformed

    private void btnResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPasswordActionPerformed
        // 重置密码
        String strUserId = txtUserId.getText().trim();
        if (!StringUtil.hasLength(strUserId)) {
            JOptionPane.showMessageDialog(this, "用户编号不能为空！");
            txtUserId.requestFocus();
            return;
        }
        String strUserName = txtUserName.getText().trim();
        if (!StringUtil.hasLength(strUserName)) {
            JOptionPane.showMessageDialog(this, "用户姓名不能为空！");
            txtUserName.requestFocus();
            return;
        }

        User user = userServiceImpl.queryUserById(strUserId);
        if (!user.getName().equals(strUserName)) {
            JOptionPane.showMessageDialog(this, "用户姓名不正确，无法重置！");
            txtUserId.requestFocus();
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "确认重置？") == JOptionPane.OK_OPTION) {

            if (userServiceImpl.resetUserPass(user)) {
                JOptionPane.showMessageDialog(this, "重置成功！");
                resetFrmOfDown();
            } else {
                JOptionPane.showMessageDialog(this, "重置失败，请联系管理员！");
            }
        }
    }//GEN-LAST:event_btnResetPasswordActionPerformed

    private void txtUserIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIdActionPerformed
        // 动作事件
        opAfterEnterOrLost();
    }//GEN-LAST:event_txtUserIdActionPerformed

    private void txtUserIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserIdFocusLost
        // 丢失焦点
        opAfterEnterOrLost();
    }//GEN-LAST:event_txtUserIdFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModPassword;
    private javax.swing.JButton btnResetPassword;
    private javax.swing.JButton btnUserAdd;
    private javax.swing.JButton btnUserDel;
    private javax.swing.JComboBox cmbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pnlModPassword;
    private javax.swing.JPanel pnlUserUpdate;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtNewPassword2;
    private javax.swing.JPasswordField txtOldPassword;
    private javax.swing.JTextField txtUserId;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}

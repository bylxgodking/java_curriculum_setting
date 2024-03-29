package cn.edu.ccst.view;

import cn.edu.ccst.model.User;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import cn.edu.ccst.service.impl.UserServiceImpl;
import  cn.edu.ccst.util.FrmUtil;
import  cn.edu.ccst.util.StringUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 系统主界面.
 * 
 * @author
 */
public class MainFrm extends javax.swing.JFrame {

    private UserMgrPnl pnlUserMgr;//用户管理界面
    private BookMgrPnl pnlBookMgr;//图书管理界面
    private BorrMgrPnl pnlBorrMgr;//借阅管理界面
    private User userLogin;//登陆用户
    /**
     * 根据用户类型设置菜单变亮变灰.
     *
     * @param
     */
    public void setUserMenu(String type) {
        if (!StringUtil.hasLength(type)) {
            type = FrmUtil.READER_USER;
        }
        if (type.equals(FrmUtil.MANAGER_USER)) {//管理员
            mnuiBorrBook.setEnabled(false);
            mnuiBorrAgain.setEnabled(false);
            mnuiBorrReturn.setEnabled(false);
            this.chgUserPnl();//切换到用户管理界面
        } else if (type.equals(FrmUtil.OPRATOR_USER)) {//操作员
            mnuiUserUpdate.setEnabled(false);
            mnuiResetPassword.setEnabled(false);
            mnuiBookUpdate.setEnabled(false);
            this.chgBorrPnl();//切换到借阅管理界面
        } else {//读者
            mnuiBorrBook.setEnabled(false);
            mnuiBorrAgain.setEnabled(false);
            mnuiBorrReturn.setEnabled(false);
            mnuiUserUpdate.setEnabled(false);
            mnuiResetPassword.setEnabled(false);
            mnuiBookUpdate.setEnabled(false);
            this.chgBookPnl();//切换图书管理界面
        }
    }

    /**
     * 切换到用户管理界面
     */
    public void chgUserPnl() {
        pnlMain.removeAll();//pnlMain为面板控件对象
        pnlMain.setLayout(new BorderLayout());//设置边界布局
        pnlMain.add(jToolBar1, BorderLayout.NORTH);//工具栏放上面，jToolBar1为工具栏对象
        pnlMain.add(pnlUserMgr, BorderLayout.CENTER);//用户管理子界面放中间
        this.setContentPane(pnlMain);//设置pnlMain面板为内容面板
        this.setVisible(true);
    }
    /**
     * 切换到借阅管理界面
     */
    public void chgBookPnl() {
        pnlMain.removeAll();
        pnlMain.setLayout(new BorderLayout());
        pnlMain.add(jToolBar1, BorderLayout.NORTH);
        pnlMain.add(pnlBookMgr, BorderLayout.CENTER);
        this.setContentPane(pnlMain);
        this.setVisible(true);
    }
    /**
     * 切换图书管理界面
     */
    public void chgBorrPnl() {
        pnlMain.removeAll();
        pnlMain.setLayout(new BorderLayout());
        pnlMain.add(jToolBar1, BorderLayout.NORTH);
        pnlMain.add(pnlBorrMgr, BorderLayout.CENTER);
        this.setContentPane(pnlMain);
        this.setVisible(true);
    }

    public void init() {
        String path = "applicationContext.xml";

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
        UserServiceImpl userService = context.getBean("userServiceImpl", UserServiceImpl.class);
        pnlUserMgr = new UserMgrPnl(userLogin);//创建用户管理子界面对象
        pnlBookMgr = new BookMgrPnl(userLogin);
        pnlBorrMgr = new BorrMgrPnl(userLogin);

        FrmUtil.centerFrm(this);//界面居中
        //设置logo
        setIconImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icon/logo.jpg")));
        //界面关闭时的操作
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                FrmUtil.exitSystem();
            }
        });
        jToolBar1.setFloatable(false);//工具栏不可浮动
        setUserMenu(userLogin.getType());//根据用户类型设置菜单显示
        this.setResizable(true);
    }

    public MainFrm(User user) {
        FrmUtil.setMyLookAndFeel(FrmUtil.fontSize);//设置组件字体
        userLogin = user;

        initComponents();
        init();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnBorrBook = new javax.swing.JButton();
        btnBorrAgain = new javax.swing.JButton();
        btnBorrReturn = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        pnlMain = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuBorrMgr = new javax.swing.JMenu();
        mnuiBorrQuery = new javax.swing.JMenuItem();
        mnuiBorrBook = new javax.swing.JMenuItem();
        mnuiBorrAgain = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuiBorrReturn = new javax.swing.JMenuItem();
        mnuBookMgr = new javax.swing.JMenu();
        mnuiBookQuery = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuiBookUpdate = new javax.swing.JMenuItem();
        mnuUserMgr = new javax.swing.JMenu();
        mnuiModPassword = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuiUserUpdate = new javax.swing.JMenuItem();
        mnuiResetPassword = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuiExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("XXX图书馆管理系统");

        jToolBar1.setRollover(true);

        btnBorrBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/jieshu.jpg"))); // NOI18N
        btnBorrBook.setFocusable(false);
        btnBorrBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBorrBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBorrBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrBookActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBorrBook);

        btnBorrAgain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xujie.jpg"))); // NOI18N
        btnBorrAgain.setFocusable(false);
        btnBorrAgain.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBorrAgain.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBorrAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrAgainActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBorrAgain);

        btnBorrReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/huanshu.jpg"))); // NOI18N
        btnBorrReturn.setFocusable(false);
        btnBorrReturn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBorrReturn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBorrReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrReturnActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBorrReturn);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit.jpg"))); // NOI18N
        btnExit.setFocusable(false);
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExit);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        mnuBorrMgr.setMnemonic('R');
        mnuBorrMgr.setText("借阅管理(R)");

        mnuiBorrQuery.setMnemonic('Q');
        mnuiBorrQuery.setText("借阅查询(Q)");
        mnuiBorrQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiBorrQueryActionPerformed(evt);
            }
        });
        mnuBorrMgr.add(mnuiBorrQuery);

        mnuiBorrBook.setMnemonic('B');
        mnuiBorrBook.setText("图书借阅(B)");
        mnuBorrMgr.add(mnuiBorrBook);

        mnuiBorrAgain.setMnemonic('A');
        mnuiBorrAgain.setText("图书续借(A)");
        mnuBorrMgr.add(mnuiBorrAgain);
        mnuBorrMgr.add(jSeparator3);

        mnuiBorrReturn.setMnemonic('R');
        mnuiBorrReturn.setText("图书归还(R)");
        mnuBorrMgr.add(mnuiBorrReturn);

        jMenuBar1.add(mnuBorrMgr);

        mnuBookMgr.setMnemonic('B');
        mnuBookMgr.setText("图书管理(B)");

        mnuiBookQuery.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mnuiBookQuery.setMnemonic('Q');
        mnuiBookQuery.setText("图书查询(Q)");
        mnuiBookQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiBookQueryActionPerformed(evt);
            }
        });
        mnuBookMgr.add(mnuiBookQuery);
        mnuBookMgr.add(jSeparator4);

        mnuiBookUpdate.setMnemonic('U');
        mnuiBookUpdate.setText("添加修改删除图书(U)");
        mnuiBookUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiBookUpdateActionPerformed(evt);
            }
        });
        mnuBookMgr.add(mnuiBookUpdate);

        jMenuBar1.add(mnuBookMgr);

        mnuUserMgr.setMnemonic('U');
        mnuUserMgr.setText("用户管理(U)");

        mnuiModPassword.setMnemonic('P');
        mnuiModPassword.setText("修改密码(P)");
        mnuiModPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiModPasswordActionPerformed(evt);
            }
        });
        mnuUserMgr.add(mnuiModPassword);
        mnuUserMgr.add(jSeparator1);

        mnuiUserUpdate.setMnemonic('U');
        mnuiUserUpdate.setText("添加删除读者(U)");
        mnuiUserUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiUserUpdateActionPerformed(evt);
            }
        });
        mnuUserMgr.add(mnuiUserUpdate);

        mnuiResetPassword.setMnemonic('A');
        mnuiResetPassword.setText("重置密码(A)");
        mnuiResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiResetPasswordActionPerformed(evt);
            }
        });
        mnuUserMgr.add(mnuiResetPassword);
        mnuUserMgr.add(jSeparator2);

        mnuiExit.setMnemonic('X');
        mnuiExit.setText("退出系统(X)");
        mnuiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiExitActionPerformed(evt);
            }
        });
        mnuUserMgr.add(mnuiExit);

        jMenuBar1.add(mnuUserMgr);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
            .addComponent(pnlMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuiModPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiModPasswordActionPerformed
        // TODO add your handling code here:
        this.chgUserPnl();

    }//GEN-LAST:event_mnuiModPasswordActionPerformed

    private void mnuiBookQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiBookQueryActionPerformed
        // TODO add your handling code here:
        this.chgBookPnl();
    }//GEN-LAST:event_mnuiBookQueryActionPerformed

    private void mnuiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiExitActionPerformed
        // TODO add your handling code here:
        FrmUtil.exitSystem();
    }//GEN-LAST:event_mnuiExitActionPerformed

    private void mnuiUserUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiUserUpdateActionPerformed
     
        //添加删除用户
        this.chgUserPnl();
    }//GEN-LAST:event_mnuiUserUpdateActionPerformed

    private void mnuiResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiResetPasswordActionPerformed
        
        //重置密码
        this.chgUserPnl();
    }//GEN-LAST:event_mnuiResetPasswordActionPerformed

    private void mnuiBookUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiBookUpdateActionPerformed
        
        //添加删除修改图书
        this.chgBookPnl();
    }//GEN-LAST:event_mnuiBookUpdateActionPerformed

    private void mnuiBorrQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiBorrQueryActionPerformed
       
        //借阅查询
        this.chgBorrPnl();
    }//GEN-LAST:event_mnuiBorrQueryActionPerformed

    private void btnBorrBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrBookActionPerformed
       
        this.chgBorrPnl();
    }//GEN-LAST:event_btnBorrBookActionPerformed

    private void btnBorrAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrAgainActionPerformed
        // 切换界面
        this.chgBorrPnl();
    }//GEN-LAST:event_btnBorrAgainActionPerformed

    private void btnBorrReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrReturnActionPerformed
        // 切换界面
        this.chgBorrPnl();
    }//GEN-LAST:event_btnBorrReturnActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // 退出系统
        FrmUtil.exitSystem();
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
        **
        * @Description: 线程开始执行，窗口显现
        * @Param: [args]
        * @return: void
        * @Author: LuoXinYu
        * @Date: 2024/3/10
        */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                User user = new User("", "", "", "3");
                new MainFrm(user).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrAgain;
    private javax.swing.JButton btnBorrBook;
    private javax.swing.JButton btnBorrReturn;
    private javax.swing.JButton btnExit;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu mnuBookMgr;
    private javax.swing.JMenu mnuBorrMgr;
    private javax.swing.JMenu mnuUserMgr;
    private javax.swing.JMenuItem mnuiBookQuery;
    private javax.swing.JMenuItem mnuiBookUpdate;
    private javax.swing.JMenuItem mnuiBorrAgain;
    private javax.swing.JMenuItem mnuiBorrBook;
    private javax.swing.JMenuItem mnuiBorrQuery;
    private javax.swing.JMenuItem mnuiBorrReturn;
    private javax.swing.JMenuItem mnuiExit;
    private javax.swing.JMenuItem mnuiModPassword;
    private javax.swing.JMenuItem mnuiResetPassword;
    private javax.swing.JMenuItem mnuiUserUpdate;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}

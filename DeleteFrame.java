import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


class DeleteFrame extends JFrame
{
Container c;
JLabel lblId;
JTextField txtId;
JButton btnSave;
JButton btnBack;

DeleteFrame(){
c=getContentPane();
FlowLayout fl= new FlowLayout();
c.setLayout(fl);

lblId= new JLabel("ID");
txtId = new JTextField(20);
btnSave = new JButton("save");
btnBack = new JButton("Back"); 

c.add(lblId);
c.add(txtId);
c.add(btnSave);
c.add(btnBack);

btnSave.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
Console c1=System.console();
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact= cfg.buildSessionFactory();
Session session= sfact.openSession();
Transaction t= null;

try{
t = session.beginTransaction();
int Id=Integer.parseInt(txtId.getText());
Employee e = (Employee)session.get(Employee.class,Id);


if (e!= null)
{
session.delete(e);
t.commit();

JOptionPane.showMessageDialog(c,"record ddeleted");
}

else{
JOptionPane.showMessageDialog(c,"record doesnot exists");
}
}


catch(Exception e)
{
t.rollback();
JOptionPane.showMessageDialog(c,"some issues");
}

finally{
session.close();

}
dispose();

}});

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
MainFrame a= new MainFrame();
dispose();
}
});








setTitle("delete ");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(300,300);
setLocationRelativeTo(null);
setVisible(true);
}
}


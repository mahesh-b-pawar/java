import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import org.hibernate.cfg.*;
import org.hibernate.*;



class UpdateFrame extends JFrame
{
Container c;
JLabel lblId, lblName, lblSalary;
JTextField  txtId, txtName, txtSalary;
JButton btnSave, btnBack;


UpdateFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
lblId = new JLabel(" ID  ");
txtId = new JTextField(20);
lblName = new JLabel(" New NAME  ");
txtName = new JTextField(20);
lblSalary = new JLabel("SALARY  ");
txtSalary = new JTextField(20);
btnSave = new JButton("SAVE");
btnBack = new JButton("BACK");

c.add(lblId);
c.add(txtId);
c.add(lblName);
c.add(txtName);
c.add(lblSalary);
c.add(txtSalary);
c.add(btnSave);
c.add(btnBack);

btnSave.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
Console c1 = System.console();
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();
Session session = sfact.openSession();
Transaction t = null;

try
{
t = session.beginTransaction();
int Id = Integer.parseInt(txtId.getText());
String Name = txtName.getText();
Double Salary = Double.parseDouble(txtSalary.getText());

if(Salary <8000){
JOptionPane.showMessageDialog(c,"salary should be greater than 8000 ");
}

Employee e = (Employee)session.get(Employee.class,Id);

if( e != null )
{
e.setName(Name);
e.setSalary(Salary);
session.save(e);
t.commit();
JOptionPane.showMessageDialog(c, "Record updated");
}
else
{
JOptionPane.showMessageDialog(c, "Record does not exist");
}
}

/*catch(UserException ue)
{
JOptionPane.showMessageDialog(c,"salary should be greater than 8000 ");
}*/

catch (NumberFormatException ne)
{
t.rollback();
JOptionPane.showMessageDialog(c,"Wrong Data" );
txtId.requestFocus();
}

catch(Exception e)
{
t.rollback();
JOptionPane.showMessageDialog(c, "Some Issue" + e);
}

finally
{
session.close();
}

}
});

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
MainFrame a= new MainFrame();
dispose();
}
});


setTitle("Update Emplyee ");
setSize(300,500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);
}

}







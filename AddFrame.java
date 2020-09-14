import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AddFrame extends JFrame 
{
Container c;
JLabel lblId, lblName, lblSalary;
JTextField  txtId, txtName, txtSalary;
JButton btnSave, btnBack;
int Id;
String Name;
Double Salary;


AddFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
lblId = new JLabel(" ID  ");
txtId = new JTextField(20);
lblName = new JLabel(" NAME  ");
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
t = session.beginTransaction();
Employee e = new Employee();

try
{

//ID 

try
{
Id = Integer.parseInt(txtId.getText());
if (Id <= 0 || Id == 0) 
{
JOptionPane.showMessageDialog(c, "please enter id and it should b Integer");
t.rollback();
txtId.setText(" ");
txtId.requestFocus();
return;
}
e.setId(Id);
}

catch(NullPointerException | NumberFormatException a)
{
JOptionPane.showMessageDialog(c, "please enter id and it should b Integer");
t.rollback();
txtId.setText(" ");
txtId.requestFocus();
return;
}

catch(Exception k)
{
JOptionPane.showMessageDialog(c, "Duplicate Id");
t.rollback();
txtId.setText(" ");
txtId.requestFocus();
return;
}

//NAME

try
{
Name = txtName.getText();

if (Name.length() <= 2 || Name == null) 
{
JOptionPane.showMessageDialog(c, " please enter name and name should contain atleast 2 character/alphabet");
t.rollback();
txtName.setText(" ");
txtName.requestFocus();
return;
}

Pattern pattern = Pattern.compile("[a-zA-Z]+");
Matcher matcher = pattern.matcher(Name);

if(!matcher.matches())
{
JOptionPane.showMessageDialog(c, " name should contain atleast 2 alphabet");
t.rollback();
txtName.setText(" ");
txtName.requestFocus();
return;
}
e.setName(Name);
}

catch(NullPointerException | org.hibernate.exception.ConstraintViolationException | NumberFormatException b)
{
JOptionPane.showMessageDialog(c, " please enter name and name hould contain atleast 2 character");
t.rollback();
txtName.setText(" ");
txtName.requestFocus();
return;
}

//SALARY

try
{
Salary= Double.parseDouble(txtSalary.getText());
if(Salary < 8000 || Salary == null)
{
JOptionPane.showMessageDialog(c, " Please Enter salary and salary should be greater than 8000");
t.rollback();
txtSalary.setText(" ");
txtSalary.requestFocus();
return;
}
e.setSalary(Salary);
}

catch(NullPointerException | NumberFormatException d)
{
JOptionPane.showMessageDialog(c, " Please Enter salary and salary should be greater than 8000");
t.rollback();
txtSalary.setText(" ");
txtSalary.requestFocus();
return;

}

session.save(e);
t.commit();

JOptionPane.showMessageDialog(c,"Record Inserted");
txtId.setText("");
txtName.setText("");
txtSalary.setText("");
}

catch(Exception f)
{
JOptionPane.showMessageDialog(c,"Duplicate ID");
t.rollback();
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

setTitle("Add Emplyee ");
setSize(300,500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);
}

}



































/*


}
catch(NumberFormatException b)
{
t.rollback();
JOptionPane.showMessageDialog(c,"Enters integer only" );
txtId.setText(" ");
txtId.requestFocus();
return;
}
catch (org.hibernate.exception.ConstraintViolationException he)
{
t.rollback();
JOptionPane.showMessageDialog(c,"Duplicate ID" );
txtId.setText(" ");
txtId.requestFocus();
}

try
{
Name = txtName.getText();
if (Name.length() <= 2) 
{
JOptionPane.showMessageDialog(c, " name hould contain atleast 2 character");
txtName.setText(" ");
txtName.requestFocus();
return;
}

if(Name.isEmpty())
{
JOptionPane.showMessageDialog(c, " Enter name please");
txtName.setText(" ");
txtName.requestFocus();
return;
}
e.setName(Name);
}

catch(Exception d)
{
t.rollback();
JOptionPane.showMessageDialog(c,"name should contain 2 letters" );
txtName.setText(" ");
txtName.requestFocus();
}

try
{
Salary= Double.parseDouble(txtSalary.getText());
if(Salary < 8000)
{
JOptionPane.showMessageDialog(c, " salary should be greater than 8000");
txtSalary.setText(" ");
txtSalary.requestFocus();
return;
}
e.setSalary(Salary);





session.save(e);
t.commit();

JOptionPane.showMessageDialog(c,"record inserted");
txtId.setText("");
txtName.setText("");
txtSalary.setText("");
}

catch(NumberFormatException ne)
{
JOptionPane.showMessageDialog(c,"Enter integer only for salary");
txtSalary.setText("");
txtSalary.requestFocus();
return;
}


catch (Exception Ee)
{
t.rollback();
JOptionPane.showMessageDialog(c,"some issue");
txtId.setText(" ");
txtName.setText(" ");
txtSalary.setText("");
txtId.requestFocus();
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
EMS e1 = new EMS();
dispose();
}
});



setTitle("Add Emplyee ");
setSize(300,500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);
}

}




*/































 
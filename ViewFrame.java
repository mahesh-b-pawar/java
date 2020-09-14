//19 dec


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.List;


class ViewFrame extends JFrame
{
Container c;
TextArea ta;
JButton btnBack;


ViewFrame()
{
c= getContentPane();
c.setLayout(new FlowLayout());
ta = new TextArea(5,30);
btnBack = new JButton("BAck");
c.add(ta);
c.add(btnBack);

Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact=cfg.buildSessionFactory();
Session session=sfact.openSession();

try
{
List<Employee>emp= new ArrayList<>();
emp = session.createQuery("from Employee").list();

for(Employee e1:emp)
	ta.append(e1.getId()+ " "+e1.getName()+ " " + e1.getSalary()+"\n");

}

catch(Exception e)
{
JOptionPane.showMessageDialog(c,"some issue");
}

finally
{
session.close();
}



btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
MainFrame a= new MainFrame();
dispose();
}
});


setTitle("view stu");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
 
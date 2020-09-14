//19 dec


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;


class MainFrame extends JFrame
{
Container c;
JButton btnAdd,btnUpdate,btnView,btnDelete;

MainFrame()
{
c= getContentPane();
c.setLayout(new FlowLayout());
btnAdd = new JButton("ADd");
btnUpdate= new JButton("Update");  
btnView = new JButton("view");
btnDelete= new JButton("Delete");

c.add(btnAdd);
c.add(btnUpdate);
c.add(btnView);
c.add(btnDelete);

btnAdd.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
AddFrame a= new AddFrame();
dispose();
}
});

btnView.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
ViewFrame a = new ViewFrame();
dispose();
}
});

btnUpdate.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
UpdateFrame a = new UpdateFrame();
dispose();
}
});

btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
DeleteFrame a = new DeleteFrame();
dispose();
}
});

setTitle("s.M.S");
setSize(200,200);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

public static void main(String args[] )
{
MainFrame mf = new MainFrame();
}
}

 
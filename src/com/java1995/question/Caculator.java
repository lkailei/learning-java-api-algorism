package src.com.java1995.question;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Caculator {
	public static void main(String[] args) {
		new CaculatorFrame();
	}
}
class CaculatorFrame extends JFrame{
	public CaculatorFrame(){
		this.setTitle("������");
		CaculatorPanel cp=new CaculatorPanel();
		this.add(cp);
		this.setLocation(300,400);
		this.setSize(300, 400);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
}
class CaculatorPanel extends JPanel{
	JTextArea display=null;
	JPanel panel=null;
	double result;
	String command;
	boolean start;
	public CaculatorPanel(){
		this.setLayout(new BorderLayout());
		result=0;
		command="=";
		start=true;
		display=new JTextArea(5,5);
		display.setText("0");
		this.add(BorderLayout.NORTH,display);
		
		panel =new JPanel();
		panel.setLayout(new GridLayout(5,4));
	
		CaculatorAction1 c1=new CaculatorAction1();
		CaculatorAction2 c2=new CaculatorAction2();
		addButton("7",c1);
		addButton("8",c1);
		addButton("9",c1);
		addButton("+",c2);
		addButton("4",c1);
		addButton("5",c1);
		addButton("6",c1);
		addButton("-",c2);
		addButton("1",c1);
		addButton("2",c1);
		addButton("3",c1);
		addButton("*",c1);
		addButton("0",c1);
		addButton(".",c1);
		addButton("/",c2);
		addButton("c",c1);addButton("=",c2);
		this.add(BorderLayout.CENTER, panel);
	}
	private void addButton(String s,ActionListener al){
		 JButton button =new JButton(s);
		 button.addActionListener(al);
		 panel.add(button); 
	}
	//����������
	String input ;
	class CaculatorAction1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			input =e.getActionCommand();
			if(start){
				display.setText("");
				start=false;
			}
				display.setText(display.getText()+input);
				if(e.getActionCommand().equals("c")){
					display.setText("");
				}
		}
		
	}
	//�����ַ�
	class CaculatorAction2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String c=e.getActionCommand();
			if(start){
				command=c;
			}else{
					if(command.equals("+")){			
					 result+=Double.parseDouble(display.getText());
				}else if(command.equals("-")){
					result-=Double.parseDouble(display.getText());
				}else if(command.equals("*")){
				    result*=Double.parseDouble(display.getText());
				}else if(command.equals("/")){
				    result/=Double.parseDouble(display.getText());
				}else if(command.equals("=")){
					result=Double.parseDouble(display.getText());
				}
				//display.setText(""+result);
				command=c;
				start=true;//
			}		
			
		}
		
	}
}
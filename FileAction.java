


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import sun.audio.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.awt.event.ActionEvent;

//static file actions
public class FileAction {
	//return is the file exists
	public static boolean isFileExist(String path)
	{
		File file = new File(path);
		if(file.exists())
			return true;
		return false;
	}
	//create a file
	public static void createFile(String path)
	{
		File file=new File(path);
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//write the message to the file
	public static void writeFile(String path,String str)
	{
		try {
			FileOutputStream fos =  new FileOutputStream(path);
			fos.write(str.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//read a file,return the file's content String
	public static String readFile(String path)
	{
		// read file content from file

		String res="";
        try {
    		
            FileReader reader = new FileReader(path);
            BufferedReader br = new BufferedReader(reader);
           
            String str = null;
            //read by line
            while((str = br.readLine()) != null) {
                  res+=str+"\n";
            }
			br.close();
	        reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return res;
	}
	//delete a file
	public static void deleteFile(String path)
	{
		File file = new File(path);
		file.delete();
	}
}

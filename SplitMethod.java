import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SplitMethod {
	
	
	
	public SplitMethod(String fromFile,String toPath) {
		// TODO Auto-generated constructor stub
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(fromFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String totStr="";
		String str="";
		int count=0;
		int ln=0;
		while(scanner.hasNextLine())
		{
			str=scanner.nextLine();
			ln++;
			if(str.equals("3942"))
			{
				System.out.println(ln);
				count++;
				FileAction.writeFile(toPath+"/"+count+".txt", totStr);
			}
			else if(str.contains("Atoms. Timestep"))
			{
				totStr="";
			}
			else
			{
				if(!str.isEmpty())
				{
					if(str.charAt(0)=='2')
					{
						totStr+=str+"\r\n";
					}
				}
			}
		}
		count++;
		FileAction.writeFile(toPath+"/"+count+".txt", totStr);
		JOptionPane.showMessageDialog(null, "分隔文件完毕！");
		
	}
}

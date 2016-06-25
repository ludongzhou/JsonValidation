package meizi.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * http://blog.csdn.net/stormbjm/article/details/19545941
 */
public class FileToolkit {
	public static void main(String[] args) {
		String str = readStringFromFile("_aliases.json");
		System.out.println(str);
	}
	
	public static String readStringFromFile(String FILE_IN)	
	{
	    String str="";
	    File file=new File(FILE_IN);
	    try {
	        FileInputStream in=new FileInputStream(file);
	        // size  涓哄瓧涓茬殑闀垮害 锛岃繖閲屼竴娆℃�ц瀹�
	        int size=in.available();
	        byte[] buffer=new byte[size];
	        in.read(buffer);
	        in.close();
	        str=new String(buffer,"UTF-8");
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	    return str;
	}

}

package code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageEn {
	 public static void lockImage(String srcPath,String destPath){
	        //srcPath是被复制的文件路径，destPath是复制的新文件存储路径
	        FileInputStream fis=null;
	        FileOutputStream fos=null;
	        try {
	            fis = new FileInputStream(new File(srcPath));
	            fos = new FileOutputStream(new File(destPath));
	            byte[] buffer = new byte[20];
	            int len;
	            while ((len = fis.read(buffer)) != -1) {
	                for (int i = 0; i < len; i++) {
	                    buffer[i] = (byte) (buffer[i] ^ 5);
	                }
	                
	                fos.write(buffer, 0, len);
	            }
	        }catch (IOException e){
	            e.printStackTrace();
	        }finally{
	            if(fos!=null){
	                try{
	                    fos.close();
	                }catch(IOException e){
	                    e.printStackTrace();
	                }
	            }
	            if(fis!=null){
	                try{
	                    fis.close();
	                }catch(IOException e){
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
}

package code;
import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import sun.misc.BASE64Encoder;

public class DES {
	public static String DES_Encrypt(String content,String mod,String pass){		
	try {
			byte[] keyBytes = pass.getBytes();
			byte[] contentBytes = content.getBytes();
			DESKeySpec keySpec=new DESKeySpec(keyBytes);
			SecretKeyFactory keyFactory=SecretKeyFactory.getInstance("DES");			
			SecretKey key=keyFactory.generateSecret(keySpec);		
			
			Cipher cipher=Cipher.getInstance("DES/"+mod+"/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(keySpec.getKey()));			
			byte[] result=cipher.doFinal(contentBytes);
			 String DES_encode = new String(new BASE64Encoder().encode(result));
			return DES_encode;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception:"+e.toString());
		}
		return null;
	}
	public static String DES_ECB_Encrypt(String content,String mod,String pass){		
		try {
				byte[] keyBytes = pass.getBytes();
				byte[] contentBytes = content.getBytes();
				DESKeySpec keySpec=new DESKeySpec(keyBytes);
				SecretKeyFactory keyFactory=SecretKeyFactory.getInstance("DES");			
				SecretKey key=keyFactory.generateSecret(keySpec);		
				
				Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
				cipher.init(Cipher.ENCRYPT_MODE, key);			
				byte[] result=cipher.doFinal(contentBytes);
				String DES_encode = new String(new BASE64Encoder().encode(result));
				return DES_encode;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("exception:"+e.toString());
			}
			return null;
		}


}

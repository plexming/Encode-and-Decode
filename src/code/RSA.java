package code;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;


public class RSA {
	private static Map<Integer, String> keyMap = new HashMap<Integer, String>();
	public static void keyPairGen() throws NoSuchAlgorithmException {  
		// KeyPairGenerator���������ɹ�Կ��˽Կ�ԣ�����RSA�㷨���ɶ���  
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");  
		// ��ʼ����Կ������������Կ��СΪ96-1024λ  
		keyPairGen.initialize(1024,new SecureRandom());  
		// ����һ����Կ�ԣ�������keyPair��  
		KeyPair keyPair = keyPairGen.generateKeyPair();  
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // �õ�˽Կ  
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // �õ���Կ  
		String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));  
		// �õ�˽Կ�ַ���  
		String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));  
		// ����Կ��˽Կ���浽Map

		keyMap.put(0,publicKeyString);  
		keyMap.put(1,privateKeyString);
		
	
	} 
	public static String GetPublickey() {
		return keyMap.get(0);
	}
	public static String GetPrivatekey() {
		return keyMap.get(1);
	}
	public static String encrypt( String str, String publicKey ) throws Exception{
		//base64����Ĺ�Կ
		byte[] decoded = Base64.decodeBase64(publicKey);
		RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
		//RSA����
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
		return outStr;
	}
	public static String decrypt(String str, String privateKey) throws Exception{
		//64λ������ܺ���ַ���
		byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
		//base64�����˽Կ
		byte[] decoded = Base64.decodeBase64(privateKey);  
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));  
		//RSA����
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		String outStr = new String(cipher.doFinal(inputByte));
		return outStr;
	}


}

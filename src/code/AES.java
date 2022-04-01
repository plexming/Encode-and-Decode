package code;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Base64;
public class AES {

	private static final String default_key = "12345678";
    static final Base64.Decoder decoder = Base64.getDecoder();
    static final Base64.Encoder encoder = Base64.getEncoder();
    static final String charset = "utf-8";
    static final String AES = "AES";
    
    public static String encodeBase64(String content){
        String encode = encode(content);//AES����
        if(encode == null) return null;//����ʧ�ܷ��ؿ�
        try {
            String s = encoder.encodeToString(encode.getBytes(charset));//Base64����
            return s;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encode(String content){
        return encode(default_key, content);
    }
    
    public static String encode(String encodeRules, String content){
        try {
            //1.������Կ��������ָ��ΪAES�㷨,�����ִ�Сд
            KeyGenerator keygen = KeyGenerator.getInstance(AES);
            //2.����ecnodeRules�����ʼ����Կ������
            //����һ��128λ�����Դ,���ݴ�����ֽ�����
//            keygen.init(128, new SecureRandom(encodeRules.getBytes()));
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(encodeRules.getBytes());
            keygen.init(128, random);
            //3.����ԭʼ�Գ���Կ
            SecretKey original_key = keygen.generateKey();
            //4.���ԭʼ�Գ���Կ���ֽ�����
            byte [] raw = original_key.getEncoded();
            //5.�����ֽ���������AES��Կ
            SecretKey key = new SecretKeySpec(raw, AES);
            //6.����ָ���㷨AES�Գ�������
            Cipher cipher = Cipher.getInstance(AES);
            //7.��ʼ������������һ������Ϊ����(Encrypt_mode)���߽��ܽ���(Decrypt_mode)�������ڶ�������Ϊʹ�õ�KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //8.��ȡ�������ݵ��ֽ�����(����Ҫ����Ϊutf-8)��Ȼ��������������ĺ�Ӣ�Ļ�����ľͻ����Ϊ����
            byte [] byte_encode = content.getBytes(charset);
            //9.�����������ĳ�ʼ����ʽ--���ܣ������ݼ���
            byte [] byte_AES = cipher.doFinal(byte_encode);
            //10.�����ܺ������ת��Ϊ�ַ���
            //������Base64Encoder�л��Ҳ�����
            //����취��
            //����Ŀ��Build path�����Ƴ�JRE System Library������ӿ�JRE System Library�����±�����һ�������ˡ�
            String AES_encode = new String(new BASE64Encoder().encode(byte_AES));
            //11.���ַ�������
            return AES_encode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//����ʧ�ܷ��ؿ�
    }
    public static String decodeBase64(String content){
        try {
            String s = new String(decoder.decode(content), charset);//Base64����
            String decode = decode(s);//AES����
            return decode;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;//����ʧ�ܷ��ؿ�
    }
    public static String decode(String content){
        return decode(default_key, content);
    }
    public static String decode(String encodeRules, String content){
        try {
            //1.������Կ��������ָ��ΪAES�㷨,�����ִ�Сд
            KeyGenerator keygen = KeyGenerator.getInstance(AES);
            //2.����ecnodeRules�����ʼ����Կ������
            //����һ��128λ�����Դ,���ݴ�����ֽ�����
//            keygen.init(128, new SecureRandom(encodeRules.getBytes()));
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(encodeRules.getBytes());
            keygen.init(128, random);
            //3.����ԭʼ�Գ���Կ
            SecretKey original_key = keygen.generateKey();
            //4.���ԭʼ�Գ���Կ���ֽ�����
            byte [] raw = original_key.getEncoded();
            //5.�����ֽ���������AES��Կ
            SecretKey key = new SecretKeySpec(raw, AES);
            //6.����ָ���㷨AES�Գ�������
            Cipher cipher = Cipher.getInstance(AES);
            //7.��ʼ������������һ������Ϊ����(Encrypt_mode)���߽���(Decrypt_mode)�������ڶ�������Ϊʹ�õ�KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            //8.�����ܲ����������ݽ�����ֽ�����
            byte [] byte_content = new BASE64Decoder().decodeBuffer(content);
            /*
             * ����
             */
            byte [] byte_decode = cipher.doFinal(byte_content);
            String AES_decode = new String(byte_decode,charset);
            return AES_decode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//����ʧ�ܷ��ؿ�
    }
}

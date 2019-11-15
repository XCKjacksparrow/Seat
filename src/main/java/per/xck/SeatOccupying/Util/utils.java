package per.xck.SeatOccupying.Util;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class utils {
    public static String MD5encode(String source) {
        if(source == null || source == ""){
            return null;
        }
        MessageDigest messageDigest = null;

        try {
            // 得到一个信息摘要器
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] encode = messageDigest.digest(source.getBytes());
        StringBuffer hexString = new StringBuffer();
        // 把每一个byte 做一个与运算 0xff;
        for (byte anEncode : encode) {
            // 与运算
            String hex = Integer.toHexString(0xff & anEncode);// 加盐
            if (hex.length() == 1) {
                hexString.append("0");
            }
            hexString.append(hex);
        }
        // 标准的md5加密后的结果
        return hexString.toString();
    }



    public static String get(String url){
        try{
            URL urlObj = new URL(url);
            URLConnection connection = urlObj.openConnection();
            InputStream is = connection.getInputStream();
            byte[] b= new byte[1024];
            int len;
            StringBuilder sb  =new StringBuilder();
            while((len=is.read(b))!=-1){
                sb.append(new String(b,0,len));
            }
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

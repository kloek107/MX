package api.mx.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class EncryptionService {

  private static String SALT = "92jka8d12kjsd8907a2kj3";

  private static String bytesToHex(byte[] hash) {
    StringBuffer hexString = new StringBuffer();
    for (int i = 0; i < hash.length; i++) {
      String hex = Integer.toHexString(0xff & hash[i]);
      if(hex.length() == 1) hexString.append('0');
      hexString.append(hex);
    }
    return hexString.toString();
  }

  public String hash(String message){
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] encodedhash = digest.digest((SALT + message).getBytes(StandardCharsets.UTF_8));
      return bytesToHex(encodedhash);
    } catch (Exception e){
      throw new RuntimeException(e);
    }
  }
}



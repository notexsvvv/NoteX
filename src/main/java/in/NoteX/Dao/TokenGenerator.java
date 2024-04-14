package in.NoteX.Dao;
import in.NoteX.Dao.UserDaoImpl;

import java.security.SecureRandom;
import java.math.BigInteger;

public class TokenGenerator {

    // Define the length of the token
    private static final int TOKEN_LENGTH = 16;

    // Generate a random token
    public static String generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[TOKEN_LENGTH];
        secureRandom.nextBytes(tokenBytes);
        return new BigInteger(1, tokenBytes).toString(16);
    }

    public static String setToken(String username) {
    	
        String token = generateToken();
        System.out.println("Generate token in token generate " +token);
        boolean outcome =UserDaoImpl.setTokenforLogin(username, token);
        if(outcome) { return token;}
        else {
			return null;
		}
    }
    
	/*
	 * public static boolean isTokenSet(String username) { String string
	 * =TokenGenerator.setToken(username); System.out.print( "is token set "
	 * +string); if(string==null) { return false; } else { return true; } }
	 */
}
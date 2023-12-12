package entity;

public class VerificationCode {
	private String code;
	private long expiryTime;
	
	
	public VerificationCode(String code) {
        this.code = code;
        this.expiryTime = System.currentTimeMillis() + 5 * 60 * 1000; // Set expiration time to 5 minutes from now
    }

    public String getCode() {
        return code;
    }

    public long getExpiryTime() {
        return expiryTime;
    }
	
	
}

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.lang.String;
import java.util.Random;



public class Random_Generator {
	
	
    static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
    public int getRandomNumber(int range) {
    	Random random = new Random();
    	int rnum = random.nextInt(range);
    	rnum = rnum*rnum;
    	if(rnum >9) {
    		rnum =-8;
    	}
    	return rnum;
    }
    public int converHextoInt(String res) throws NoSuchAlgorithmException {
    	res = sha1(res);
    	res = res.substring(0,1);
    	int final_res = Integer.parseInt(res,16);
    	if(final_res > 9) {
    		final_res = final_res-6;
    	}
    	return final_res;
    }
    
    public long getRandomTime() {
		long random_num = System.currentTimeMillis();
    	return  random_num;
    }
    
    public int finalConversion() throws NoSuchAlgorithmException {
		String final_one;
		final_one = String.valueOf(getRandomTime());
		int random_value = converHextoInt(final_one);
		return random_value;
    }
    

    public Random_Generator(int range) throws NoSuchAlgorithmException {
		int random = finalConversion();
		int temp =0;
		String f = String.valueOf(getRandomTime());
		int limit_rnum = getRandomNumber(range);
		
		for(int i=0;i<limit_rnum;i++) {
		f = sha1(f);
		temp = converHextoInt(f);
		temp+= temp;
		}
		if(random >0 && random<1) {
			String before_f = f.substring(0, random);
			int after_f = Integer.parseInt(before_f,16) +temp;
			System.out.println(after_f);
		}
		else {
			int after_f = finalConversion();
			if(after_f == 0) {
				new Random_Generator(limit_rnum);
			}
			System.out.println(after_f);
		}
    }
    
    
	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		int times = 10;
		Random_Generator r = new Random_Generator(times);
	}

}

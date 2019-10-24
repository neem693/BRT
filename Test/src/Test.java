import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	static final String RANDOM_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789";

	public static String getRandomSecure(int length) {
		if (length == 0) {
			return null;
		}
		SecureRandom random = new SecureRandom();
		char[] char_array = new char[length];
		for (int i = 0; i < length; i++) {
			char_array[i] = RANDOM_CHAR.charAt(random.nextInt(RANDOM_CHAR.length()));
		}

		return new String(char_array);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = ".*\\.(jpg|png)$";

		Pattern pattern = Pattern.compile(exp);
		System.out.println(pattern.matcher("wefwe.jpg").matches());
		System.out.println(pattern.matcher("wefwe.jpeg").matches());
		System.out.println(pattern.matcher("wefw.png").matches());
		System.out.println(pattern.matcher("wewefwffwe.jpee").matches());
		System.out.println(pattern.matcher("wefe.jpg").matches());
		System.out.println(pattern.matcher("wefwe.gif").matches());
		System.out.println(pattern.matcher("wefwe.eeee").matches());
		
		System.out.println(getRandomSecure(10));
		System.out.println("이거 안깨지냐 씨발놈아");
		
		String ext = "wew...e..f.wff..___we.jpee".split(".*\\.")[1];
		System.out.println(ext);
		
		String tokenKey = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJuZWVtNjkzIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTU3MTkyMDEyMSwidXNlcklkIjoyMSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9DT01NT05fVVNFUiJdLCJqdGkiOiI3MWE3MzA2NS02OTYzLTRkZGYtYTdkZi02OTM1MjQ4MDIxMDgiLCJjbGllbnRfaWQiOiJiMWQzRjM0RzZUaDdqZCJ9.dZCGuUHqYCusp2W0Ce3RfAzI9kZ72I9CCx6KX5ZAGKf9ksi2llXry67cjeXR_k2uSSw_06yaamXERk6pzziLhY0IDe-uJdDEA66lDJfSwYTejXkbzhTXlXaafce02lpypoKdLaH3VzQytT_0PVoV1EEp-LSKcA8f_JRGiIrIHzUJZRhmUy92tFG7J7SUADzkeEz83s_LVA7rHcLzrRZcIVEIiVCF3WHyaAnpYUFAVy7ViYhU0MhCNj2OIvMU8fiLpmtHxw5pXv5djfusfZtrT2VbOxY0BJ1ET-Da_UQUzgMcFVTy2E2so9Ib8ZyDloY7-97JTczfzi7EZ7mXNxx3UA";
		String payload = tokenKey.split("\\.")[1];
		payload = new String(Base64.getDecoder().decode(payload));
		Map result = null;
		try {
			result = new ObjectMapper().readValue(payload, HashMap.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//{user_name=neem693, scope=[read, write], exp=1571920121, userId=21, authorities=[ROLE_COMMON_USER], jti=71a73065-6963-4ddf-a7df-693524802108, client_id=b1d3F34G6Th7jd}
		String user_name = result.get("user_name").toString();
		String userId = result.get("userId").toString();
		List<String> authorities = (List<String>)result.get("authorities");
		
		System.out.println(result);
		
		


	}

}

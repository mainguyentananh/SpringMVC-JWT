import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {
	public static void main(String[] args) {
		BCryptPasswordEncoder t = new BCryptPasswordEncoder();
		System.out.println(t.encode("admin"));
	}
}

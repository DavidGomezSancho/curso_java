package ejemplo05beans.beans6;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LanzadorSpring {
	public static ApplicationContext context;

	static {
		context = new ClassPathXmlApplicationContext("beans6.xml");
	}
	public static void main(String[] args) {
		
	}
}

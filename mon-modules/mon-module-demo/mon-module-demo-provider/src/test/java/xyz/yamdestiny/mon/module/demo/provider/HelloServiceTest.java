package xyz.yamdestiny.mon.module.demo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloServiceTest {

	public static void main(String[] args) throws Exception {
		// Prevent to get IPV6 address,this way only work in debug mode
		// But you can pass use -Djava.net.preferIPv4Stack=true,then it work well
		// whether in debug mode or not
		System.setProperty("java.net.preferIPv4Stack", "true");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "META-INF/spring/dubbo-provider.xml" });
		context.start();

		System.in.read(); // press any key to exit
		
		context.close();
	}

}

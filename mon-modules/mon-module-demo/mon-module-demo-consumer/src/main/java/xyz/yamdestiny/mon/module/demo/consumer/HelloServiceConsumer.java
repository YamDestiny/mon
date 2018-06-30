package xyz.yamdestiny.mon.module.demo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.yamdestiny.mon.module.demo.HelloService;

public class HelloServiceConsumer {

	public static void main(String[] args) {
		// Prevent to get IPV6 address,this way only work in debug mode
		// But you can pass use -Djava.net.preferIPv4Stack=true,then it work well
		// whether in debug mode or not
		System.setProperty("java.net.preferIPv4Stack", "true");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "META-INF/spring/dubbo-consumer.xml" });
		context.start();
		HelloService helloService = (HelloService) context.getBean("helloService"); // get remote service proxy

		while (true) {
			try {
				Thread.sleep(1000);
				String hello = helloService.sayHello("world"); // call remote method
				System.out.println(hello); // get result

			} catch (Throwable throwable) {
				throwable.printStackTrace();
			}
		}
	}

}

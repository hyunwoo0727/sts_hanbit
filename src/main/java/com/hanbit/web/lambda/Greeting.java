package com.hanbit.web.lambda;

public class Greeting {
	interface GreetingService{
		public void greet(String name);
	}
	public void sayHello(){
			// 내부 클래스 인터페이스 구현 방법 1
			class EnglishGreeting implements GreetingService{
				@Override
				public void greet(String name){
					System.out.println("Hello"+name);
				}
			}
			GreetingService engGreeting = new EnglishGreeting();
			
			// 내부 클래스 인터페이스 구현 방법 2
			GreetingService korGreeting = new GreetingService() {
				
				@Override
				public void greet(String name) {
					System.out.println("안녕하세요"+name);
					
				}
			};
			engGreeting.greet("Tom");
			korGreeting.greet("한효주");
	}
}

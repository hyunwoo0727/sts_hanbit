package com.hanbit.web.lambda;

public class InnterTest {
	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.InnerInstance i = o.new InnerInstance();
		
		Outer.StaticInner osi = new Outer.StaticInner();
		
		System.out.println(i.iv);
		System.out.println(i.SV);
		System.out.println(osi.cv);
	}
}
class Outer{
	class InnerInstance{
		int iv = 100;
		final static int SV = 200;
	}
		static class StaticInner{
			int cv = 300;
	}
}

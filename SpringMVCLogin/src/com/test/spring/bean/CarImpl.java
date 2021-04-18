package com.test.spring.bean;

public class CarImpl implements Car {

	@Override
	public Car engine() {
		System.out.println("Hello I am here..");		
		return new CarImpl();
	}

}

package com.codemistri.Step1;

import java.util.stream.IntStream;

public class Test {
	public static void main(String[] args) {
//		convert a list of duplicate values into map | using java 8
//		 
//		example {1,2,1,3,2,4,5,6,4}  = {1,2},{2,2},{3,1},{4,2},{5,1},{6,1}

		IntStream.iterate(2, x -> x +2).limit(10).forEach(System.out::println);

	}

}

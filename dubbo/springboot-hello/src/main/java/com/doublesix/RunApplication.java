package com.doublesix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 需要放在所在需要处理的类的父目录
 * @author Administrator
 *
 */
@SpringBootApplication
public class RunApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(RunApplication.class, args);
	}

}

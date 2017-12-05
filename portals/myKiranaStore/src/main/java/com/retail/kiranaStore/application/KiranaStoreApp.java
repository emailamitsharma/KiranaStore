package com.retail.kiranaStore.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import com.retail.kiranaStore.configuration.JpaConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.retail.kiranaStore"})
@ActiveProfiles(profiles="mysqlDB")
public class KiranaStoreApp {

	public static void main(String[] args) {
		SpringApplication.run(KiranaStoreApp.class, args);
	}
}

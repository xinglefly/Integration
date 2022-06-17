package com.spring.monitoradmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class MonitorAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorAdminApplication.class, args);
	}

}

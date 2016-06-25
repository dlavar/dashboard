package com.ge.power.findashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;




@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class FinDashBoardApplication extends SpringBootServletInitializer {
	private static JdbcTemplate jdbcTemplate;
	
    public static void main(String[] args) {
    	Object[] obj = {
    			FinDashBoardApplication.class,
    			};
    SpringApplication.run(obj,args);
    
    
  
    }
    public static JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
   
}



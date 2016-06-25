package com.ge.power.findashboard.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class RunDetails {
	@Getter @Setter public String message;
	@Getter @Setter public String source;
	@Getter @Setter public String month;
	@Getter @Setter public String date;
	@Getter @Setter public String quater;
	@Getter @Setter public String runstatus;	
}

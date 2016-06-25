package com.ge.power.findashboard.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface FileUploadCommonValidations {
	public  Boolean validateFile(byte[] byteArray,List<String>countryStateList) throws  IOException;
}



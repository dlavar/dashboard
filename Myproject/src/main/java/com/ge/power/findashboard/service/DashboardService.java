package com.ge.power.findashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.power.findashboard.dao.DashboardDAO;
import com.ge.power.findashboard.vo.UserVO;

@Service
public class DashboardService {

	@Autowired 
	private DashboardDAO dashboardDAO;

	public List<UserVO> userDetails() {
		// TODO Auto-generated method stub
		return dashboardDAO.userDetails();
	}

}

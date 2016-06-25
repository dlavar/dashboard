
package com.ge.power.findashboard.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.ge.power.findashboard.dao.DashboardDAO;
import com.ge.power.findashboard.dao.impl.commons.GenericDAO;
import com.ge.power.findashboard.vo.UserVO;

/**
 * DashboardDAOImpl DAO implementation 
 * 
 * @author Telosys Tools
 *
 */
@Repository
public class DashboardDAOImpl extends GenericDAO<UserVO> implements DashboardDAO {

	private static final String SQL_USER_ROLES = "select * from USER_MASTER";

	@Override
	public List<UserVO> userDetails() {
		List<UserVO> actDetailsList=  getJdbcTemplate().query(SQL_USER_ROLES, new BeanPropertyRowMapper<UserVO>(UserVO.class));
		return  actDetailsList;
	}

	@Override
	protected String getSqlSelect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSqlSelectF() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSqlInsert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSqlUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSqlDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSqlCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSqlCountAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] getValuesForInsert(UserVO bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] getValuesForUpdate(UserVO bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] getValuesForPrimaryKey(UserVO bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RowMapper<UserVO> getRowMapper(UserVO bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RowMapper<UserVO> getRowMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

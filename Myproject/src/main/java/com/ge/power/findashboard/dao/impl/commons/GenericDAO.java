
package com.ge.power.findashboard.dao.impl.commons;

import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.ge.power.findashboard.FinDashBoardApplication;

/**
 * Generic abstract class for basic DAO based on Spring JdbcTemplate
 * 
 * @author Telosys Tools
 *
 * @param <T>
 */
public abstract class GenericDAO<T> {
	
	/*@Autowired
	protected
	JdbcTemplate jdbcTemplate;*/
	/**
	 * The DataSource providing the connections (injected by Spring)
	 
	*/
//	@Resource(name="dataSource")
//	public DataSource dataSource;
	
	/**
	 * The auto-incremented column name if any (null if none)
	 */
	private final String  lastInsertIdQuery = "SELECT LAST_INSERT_ID()" ;
	private final String  autoIncrColumnName ;
	
	/**
	 * The columns types for each value to be inserted with an auto-incremented key (null if no auto-incremented column)
	 */
	private final int[]   insertJdbcTypes ;
	
	/**
	 * Constructor for a standard table (without auto-incremented column)
	 */
	protected GenericDAO() {
		super();
		this.autoIncrColumnName = null ;
		this.insertJdbcTypes = null ;
	}

	/**
	 * Constructor for a table with an auto-incremented key
	 * @param autoIncrColumnName
	 * @param insertJdbcTypes
	 */
	protected GenericDAO(String autoIncrColumnName, int[] insertJdbcTypes) {
		super();
		this.autoIncrColumnName = autoIncrColumnName ;
		this.insertJdbcTypes = insertJdbcTypes ;
	}

	/**
	 * Returns the SQL SELECT REQUEST to be used to retrieve the bean data from the database
	 * @return
	 */
	protected abstract String  getSqlSelect();
	protected abstract String  getSqlSelectF();
	
	/**
	 * Returns the SQL INSERT REQUEST to be used to insert the bean in the database
	 * @return
	 */
	protected abstract String  getSqlInsert();
	
	/**
	 * Returns the SQL UPDATE REQUEST to be used to update the bean in the database
	 * @return
	 */
	protected abstract String  getSqlUpdate();
	
	/**
	 * Returns the SQL DELETE REQUEST to be used to delete the bean from the database
	 * @return
	 */
	protected abstract String  getSqlDelete();
	
	/**
	 * Returns the SQL COUNT REQUEST to be used to check if the bean exists in the database
	 * @return
	 */
	protected abstract String  getSqlCount();
	
	/**
	 * Returns the SQL COUNT REQUEST to be used to count all the beans present in the database
	 * @return
	 */
	protected abstract String  getSqlCountAll();
		
	/**
	 * Returns the values to be used in the SQL INSERT PreparedStatement
	 * @param bean
	 * @return
	 */
	protected abstract Object[] getValuesForInsert(T bean) ; 
	
	/**
	 * Returns the values to be used in the SQL UPDATE PreparedStatement
	 * @param bean
	 * @return
	 */
	protected abstract Object[] getValuesForUpdate(T bean) ; 
	
	/**
	 * Returns the values to be used as Primary Key in a SQL WHERE clause in a PreparedStatement
	 * @param bean
	 * @return
	 */
	protected abstract Object[] getValuesForPrimaryKey(T bean);
	
	/**
	 * Returns a RowMapper for the given bean
	 * @param bean
	 * @return
	 */
	protected abstract RowMapper<T>  getRowMapper(T bean);
	
	/**
	 * Returns a RowMapper for a new bean instance
	 * @return
	 */
	protected abstract RowMapper<T>  getRowMapper();
	
    //-----------------------------------------------------------------------------------------
	private void log(String msg) {
		//System.out.println("[DAO LOG] : " + msg );
	}
	
    //-----------------------------------------------------------------------------------------
	/**
	 * Returns an instance of Spring 'JdbcTemplate' for the current DataSource
	 * @return
	 */

	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {

		return FinDashBoardApplication.getJdbcTemplate();
		
	}
	
	
    //-----------------------------------------------------------------------------------------
	/**
	 * Loads the given bean from the database using its current primary key (SQL SELECT)<br>
	 * If found the given bean is populated 
	 * @param bean
	 * @return true if found and loaded, false if not found
	 */
	protected boolean doSelect(T bean) {
 
		log("Select using a bean instance : " + bean );
		Object[] primaryKey = getValuesForPrimaryKey(bean);
		log("Select using a bean instance : Primary Key = " + toString(primaryKey) );
		RowMapper<T> rowMapper = getRowMapper(bean) ;
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		//--- Try to find the record. NB : Spring throws "EmptyResultDataAccessException" if not found
		try {
			T beanFound = jdbcTemplate.queryForObject(getSqlSelect(), primaryKey, rowMapper);
			if ( beanFound != bean ) {
				throw new RuntimeException("Unexpected instance returned by JdbcTemplate");
			}
			return true ;
		} catch (EmptyResultDataAccessException e) {
			// Nothing to do, just return "not found"
			return false;
		}
	}
	
	public List<Map<String, Object>> doSelectF(Object[] foreignKey) {
		log("Select by Primary Key : " + toString(foreignKey) );
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		try {
			return jdbcTemplate.queryForList(getSqlSelectF(), foreignKey);
		} catch (EmptyResultDataAccessException e) {
			// Nothing to do, just return null
			return null;
		}
	}
	
    //-----------------------------------------------------------------------------------------
	/**
	 * Loads a bean from the database using the given primary key (SQL SELECT)<br>
	 * @param primaryKey
	 * @return the bean found or null if not found
	 */
	protected T doSelect(Object[] primaryKey) {
		log("Select by Primary Key : " + toString(primaryKey) );
		RowMapper<T> rowMapper = getRowMapper() ;
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		//--- Try to find the record. NB : Spring throws "EmptyResultDataAccessException" if not found
		try {
			return jdbcTemplate.queryForObject(getSqlSelect(), primaryKey, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//-----------------------------------------------------------------------------------------
	/**
	 * Inserts the given bean in the database (SQL INSERT)
	 * @param bean
	 */
	protected int doInsert(T bean) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate(); 
		//--- Execute INSERT
		int result = jdbcTemplate.update(getSqlInsert(), getValuesForInsert(bean) );
		if ( result != 1 ) {
			throw new RuntimeException("Unexpected return value after INSERT : " + result + " (1 expected) ");
		}
		return jdbcTemplate.queryForObject(lastInsertIdQuery, Integer.class);
	}	

	//-----------------------------------------------------------------------------------------
	/**
	 * Returns a 'PreparedStatementCreator' usable with a 'KeyHolder' for an insert with an auto-incremented key
	 * @param bean
	 * @return
	 */
	private PreparedStatementCreator getPreparedStatementCreator(final T bean) {
		//log("getPreparedStatementCreator : auto incr col = " + autoIncrColumnName  );
		//log("getPreparedStatementCreator : sql insert = " + getSqlInsert() );
		PreparedStatementCreatorFactory factory = new PreparedStatementCreatorFactory(getSqlInsert(), this.insertJdbcTypes) ;
		
		factory.setGeneratedKeysColumnNames(new String[]{autoIncrColumnName});
		//log("before newPreparedStatementCreator : values for insert = " + toString(getValuesForInsert(bean)));
		PreparedStatementCreator psc = factory.newPreparedStatementCreator(getValuesForInsert(bean));
		//log("after newPreparedStatementCreator ");
		return psc ;
	}
	//-----------------------------------------------------------------------------------------
	/**
	 * Inserts the given bean in the database (SQL INSERT) with an auto-incremented key
	 * @param bean
	 * @return the value of the generated key
	 */
	protected long doInsertAutoIncr(final T bean) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate(); 
		// GeneratedKeyHolder : the default implementation of the KeyHolder interface, to be used for holding auto-generated keys 
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		
		int result = jdbcTemplate.update(getPreparedStatementCreator(bean), keyHolder );

		if ( result != 1 ) {
			throw new RuntimeException("Unexpected return value after INSERT : " + result + " (1 expected) ");
		}
		
		//--- Retrieve the generated value
		Number key = keyHolder.getKey(); // Single numeric generated key
		if ( key != null ) {
			return key.longValue();
		}
		else {
			throw new RuntimeException("Cannot retrive generated key after INSERT : KeyHolder returns null");
		}
	}	
	//-----------------------------------------------------------------------------------------
	/**
	 * Inserts the given bean in the database (SQL INSERT) with an auto-incremented column (usually the primary key)
	 * @param bean
	 * @return the generated value for the auto-incremented column
	 */
	protected Long doInsertAutoIncrOLD(T bean ) {
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate(); 
		// GeneratedKeyHolder : the default implementation of the KeyHolder interface, to be used for holding auto-generated keys 
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		
		//--- FORM 2 with only the KeyHolder
		int result = jdbcTemplate.update(getSqlInsert(), getValuesForInsert(bean), keyHolder, new String[]{autoIncrColumnName} );

		if ( result != 1 ) {
			throw new RuntimeException("Unexpected return value after INSERT : " + result + " (1 expected) ");
		}
		
		//--- Retrieve the generated value
		Number key = keyHolder.getKey(); // Single numeric generated key
		if ( key != null ) {
			return key.longValue();
		}
		else {
			throw new RuntimeException("Cannot retrive generated key after INSERT : KeyHolder returns null");
		}
	}	

	//-----------------------------------------------------------------------------------------
	/**
	 * Updates the given bean in the database (SQL UPDATE)
	 * @param bean the bean to be updated
	 * @return the JDBC return code (i.e. the row count affected by the UPDATE operation : 0 or 1 )
	 */
	protected int doUpdate(T bean) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate(); 
		//--- Execute UPDATE
		int result = jdbcTemplate.update(getSqlUpdate(), getValuesForUpdate(bean));
		if ( result != 0 && result != 1 ) {
			throw new RuntimeException("Unexpected return value after UPDATE : " + result + " (0 or 1 expected) ");
		}
		return result;
	}	
	//-----------------------------------------------------------------------------------------
	/**
	 * Deletes the given bean in the database (SQL DELETE)
	 * @param bean the bean to be deleted (containing the Primary Key)
	 * @return the JDBC return code (i.e. the row count affected by the DELETE operation : 0 or 1 )
	 */
	protected int doDelete(T bean) {
		return doDelete( getValuesForPrimaryKey(bean) ) ;
	}
	
	//-----------------------------------------------------------------------------------------
	/**
	 * Deletes the record having with the given Primary Key
	 * @param primaryKey the Primary Key values 
	 * @return the JDBC return code (i.e. the row count affected by the DELETE operation : 0 or 1 )
	 */
	protected int doDelete(Object[] primaryKey) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate(); 
		//--- Execute DELETE
		int result = jdbcTemplate.update(getSqlDelete(), primaryKey);
		if ( result != 0 && result != 1 ) {
			throw new RuntimeException("Unexpected return value after DELETE : " + result + " (0 or 1 expected) ");
		}
		return result ;
	}

	//-----------------------------------------------------------------------------------------
	/**
	 * Checks if the given bean exists in the database (SQL SELECT COUNT(*) WHERE PRIMARY_KEY = ... )
	 * @param bean the bean containing the Primary Key
	 * @return
	 */
	protected boolean doExists(T bean) {
		return doExists( getValuesForPrimaryKey(bean) );
	}
	
	//-----------------------------------------------------------------------------------------
	/**
	 * Checks if the given bean exists in the database (SQL SELECT COUNT(*) WHERE PRIMARY_KEY = ... )
	 * @param primaryKey the Primary Key values
	 * @return
	 */
	protected boolean doExists(Object[] primaryKey) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate(); 
		long count = jdbcTemplate.queryForObject(getSqlCount(), primaryKey, Long.class);
		return count > 0 ;
	}

	//-----------------------------------------------------------------------------------------
	/**
	 * Counts all the occurrences in the table ( SQL SELECT COUNT(*) )
	 * @return
	 */
	protected long doCountAll() {
		JdbcTemplate jdbcTemplate = getJdbcTemplate(); 
		return jdbcTemplate.queryForObject(getSqlCountAll(), Long.class);
	}
	
	//-----------------------------------------------------------------------------------------
	/**
	 * Formats an array of objects in a String ready for printing
	 * @param objects
	 * @return
	 */
	protected String toString(Object[] objects) {
		if ( objects != null ) {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			int i = 0 ;
			for ( Object o : objects ) {
				if ( i > 0 ) {
					sb.append("|");
				}
				sb.append(o.toString());
				i++;
			}
			sb.append("]");
			return sb.toString();
		}
		else {
			return "null" ;
		}
	}

}

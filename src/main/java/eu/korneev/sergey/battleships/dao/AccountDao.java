package eu.korneev.sergey.battleships.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import eu.korneev.sergey.battleships.models.AccountModel;
import eu.korneev.sergey.battleships.models.RegistrationModel;



@Service
public class AccountDao {
	
	
	
	private JdbcTemplate jdbcTemplate;
	
	 @Resource(name="dataSource")
	 public void setDataSource(DataSource dataSource) {
		 jdbcTemplate=new JdbcTemplate(dataSource);
	 }
	 
	 
	 
	 public List<AccountModel> getAccountLoginInfo(String userName) throws SQLException{
		 
		 Object [] objects = new Object[1];
		  String sql = "select name , passwordhashcode from accounts where name = ? ";
		  objects[0]=userName;
		  RowMapper<AccountModel> mapper = new RowMapper<AccountModel>() {  
		         public AccountModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	 AccountModel person = new AccountModel();
		        	 person.setUserName(rs.getString("name"));
		        	 person.setPasswordHashCode(rs.getString("passwordhashcode"));
		        	 return person;
		         	}
		     };
		  return jdbcTemplate.query(sql, mapper ,objects);

		 }
	 

	public synchronized boolean register(RegistrationModel model) {
		try{
			ArrayList<Object> list= new ArrayList<Object>();
			String query = "insert into accounts (name, passwordhashcode) values (?, ?)";
			
			list.add(model.getUserName());
			list.add(model.getPassWord().hashCode());
			System.out.println(list);
			//new PreparedStatementCreatorFactory(query).newPreparedStatementCreator(list.toArray());
			return jdbcTemplate.update(query,list.toArray())==1;
	
		}
		catch(DuplicateKeyException ex){
			return false;
		}
	
		

	}
	
		

	
}

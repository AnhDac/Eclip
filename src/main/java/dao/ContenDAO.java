package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Content;

public class ContenDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/dbcontent?useSSL=false";
	private String jdbcUsername="root";
	private String jdbcPassword="D@c12345";
	
	private static final String INSERT_CONTENT_SQL = "INSERT INTO content" +"(title,brief,datecreate) VALUES" +"(?,?,?);";
	private static final String SELECT_CONTENT_BY_ID = "SELECT * FROM content where id = ?;";
	private static final String SELECT_ALL_CONTENT = "SELECT * FROM content;";
	private static final String DELETE_CONTENT_BY_ID = "DELETE FROM content WHERE ID =?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return connection;
	}
	
	//Insert Content
	public void insertContent(Content content) throws SQLException {
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTENT_SQL)) 
		{
			preparedStatement.setInt(1, content.getId());
			preparedStatement.setString(2, content.getTitle());
			preparedStatement.setString(3, content.getBrief());
			preparedStatement.setDate(3, content.getDatecreate());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			//printSQLException(e);
			e.printStackTrace();
		}
		
	}
	
	//Delete Content
	public boolean deleteContent(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CONTENT_BY_ID);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	//Select all content
		public List<Content> selectAllContents() {

			// using try-with-resources to avoid closing resources (boiler plate code)
			List<Content> contents = new ArrayList<>();
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();

					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTENT);) {
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String brief = rs.getString("brief");
					Date date = rs.getDate("datecreate");
					contents.add(new Content(id, title, brief, date));
				}
			} catch (SQLException e) {
				e.printStackTrace();//(e);
			}
			return contents;
		}
	
}

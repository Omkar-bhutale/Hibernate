package in.omkar.idgenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmployeeIdGenrater implements IdentifierGenerator {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		Integer id = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql:///college", "root", "Sanskruti");
				Statement statement = connection.createStatement();) {
			String selectQuery = "select * from idinfo";
			if (statement != null) {
				try (ResultSet resultSet = statement.executeQuery(selectQuery)) {
					if (resultSet != null && resultSet.next()) {
						id = resultSet.getInt(1);
					}
				}

			}
			
			//i had missed this case
			// Update idinfo table (assuming an update column named 'lastid')
			String updateQuery = "update idinfo set lastid = lastid + 1";
			int updatedCount = statement.executeUpdate(updateQuery);

			// Check update result and handle potential conflicts
			if (updatedCount != 1) {
				throw new HibernateException(
						"Failed to update idinfo table. Expected 1 row updated, but got " + updatedCount);
			}else {
				System.out.println("last id is updated");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

}

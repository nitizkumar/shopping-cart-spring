package com.learnithardway.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.h2.Driver;
import org.springframework.stereotype.Repository;

@Repository
public class WineDaoImpl implements WineDao {

public List<WineDetail> getListOfWines() {
	ArrayList<WineDetail> listOfWine = new ArrayList<>();
	try {
		DriverManager.registerDriver(new Driver());
		try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				Statement stmt = connection.createStatement();
				ResultSet resultSet = stmt.executeQuery("SELECT WINE_ID,WINE_NAME,PRICE FROM WINE_DETAIL")) {

			while (resultSet.next()) {
				WineDetail detail = new WineDetail();
				detail.setId(resultSet.getInt("WINE_ID"));
				detail.setName(resultSet.getString("WINE_NAME"));
				detail.setPrice(resultSet.getDouble("PRICE"));
				listOfWine.add(detail);
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return listOfWine;
}
}

package com.qa.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.databases.Item;

public class MysqlItemDao implements Dao<Item>{
	//private Connection connection;
	public static final Logger LOGGER = Logger.getLogger(MysqlItemDao.class);

	Item itemFromResultSet(ResultSet resultSet) throws SQLException {
		Float cost = resultSet.getFloat("cost_of_item");
		String name = resultSet.getString("name_of_item");
		return new Item(cost, name);
	}
	
	public Item readLatest() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root", "root12");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT FROM Items ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return itemFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Item create(Item item) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root", "root12")){
		Statement statement = connection.createStatement();
		statement.executeUpdate("insert into items(name_of_item, cost_of_item) values(' " + item.getCost() + "'," + item.getName() + ");");
		return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public ArrayList<Item> readAll() {
		ArrayList<Item> items = new ArrayList<Item>();
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root" ,"root12");
				
			Statement itemstatement = connection.createStatement();
			ResultSet resultSet = itemstatement.executeQuery("select * from items");
			while (resultSet.next()) {
				Long id = resultSet.getLong("item_id");
				String itemname = resultSet.getString("name_of_item");
				Float cost = resultSet.getFloat("cost_of_item");
				Item item = new Item(id, cost, itemname);
				items.add(item);
			}
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		} 
		return items;
	}

	public Item update(Item item) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root", "root12")){
			Statement statement = connection.createStatement();
			statement.executeUpdate("update items set name_of_item = '" + item.getName() + "', set cost_of_item = " + item.getCost() + "  where item_id=" + item.getId() + ";");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
			}
		return item;
	}

	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root", "root12")){
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from items where item_id=" + id + ";");
		} catch (Exception e) {
		
		}
		
	}
	}

	


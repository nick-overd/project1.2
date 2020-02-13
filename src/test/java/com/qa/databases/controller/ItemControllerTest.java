package com.qa.databases.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.database.controller.ItemController;
import com.qa.database.services.ItemServices;
import com.qa.databases.Item;
@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	
	/**
	 *  The thing I want to fake functionality for
	 */
	@Mock
	private ItemServices itemServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the item controller
	 */
	@Spy
	@InjectMocks
	private ItemController itemController;

	@Test
	public void readAllTest() {
		ItemController itemController = new ItemController(itemServices);
		List<Item> items = new ArrayList<>();
		items.add(new Item( 100F, "yasha"));
		items.add(new Item( 100F, "kaya"));
		items.add(new Item( 100F, "sange"));
		Mockito.when(itemServices.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
	}

	@Test
	public void createTest() {
		String name = "yasha";
		String cost = "100";
		Mockito.doReturn(cost, name).when(itemController).getInput();
		Item item = new Item(100f, name);
		Item savedItem = new Item(1L, 100f, name);
		Mockito.when(itemServices.create(item)).thenReturn(savedItem);
		assertEquals(savedItem, itemController.create());
	}

	@Test
	public void updateTest() {
		String id = "1";
		String cost = "100";
		String name = "yasha";
		Mockito.doReturn(id, cost, name).when(itemController).getInput();
		Item item = new Item(1l, 100f, "yasha");
		Mockito.when(itemServices.update(item)).thenReturn(item);
		assertEquals(item, itemController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
	}
	
}
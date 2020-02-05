package com.example.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ServletContext application;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("")
	public String index(Model model) {
		List<Item> itemList = new LinkedList<>();
		Item item1 = new Item();
		item1.setName("手帳ノート");
		item1.setPrice(1000);
		itemList.add(item1);
		
		Item item2 = new Item();
		item2.setName("文房具セット");
		item2.setPrice(1500);
		itemList.add(item2);
		
		Item item3 = new Item();
		item3.setName("ファイル");
		item3.setPrice(2000);
		itemList.add(item3);
		
		application.setAttribute("itemList", itemList);
		
		LinkedList<Item> itemListInCart = (LinkedList<Item>)session.getAttribute("itemListInCart");
		if(Objects.equals(itemListInCart, null)) {
			itemListInCart = new LinkedList<>();
			session.setAttribute("itemListInCart", itemListInCart);
		}
		Integer totalPriceInCart = 0;
		for(Item i: itemListInCart) {
			totalPriceInCart += i.getPrice();
		}
		model.addAttribute("totalPriceInCart", totalPriceInCart);
		
		return "item-and-cart";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/in-cart")
	public String inCart(int indexOfItemList, Model model) {
		LinkedList<Item> itemList = (LinkedList<Item>)application.getAttribute("itemList");
		Item selectedItem = itemList.get(indexOfItemList);
		LinkedList<Item> itemListInCart = (LinkedList<Item>)session.getAttribute("itemListInCart");
		itemListInCart.add(selectedItem);
		session.setAttribute("itemListInCart", itemListInCart);
		return index(model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	public String delete(int indexOfItemList, Model model) {
		LinkedList<Item> itemListInCart = (LinkedList<Item>)session.getAttribute("itemListInCart");
		itemListInCart.remove(indexOfItemList);
		session.setAttribute("itemListInCart", itemListInCart);
		return index(model);
	}
	
}

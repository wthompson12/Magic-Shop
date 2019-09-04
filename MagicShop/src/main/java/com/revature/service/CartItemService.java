package com.revature.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.CartItem;
import com.revature.beans.Human;
import com.revature.data.CartItemDAO;
import com.revature.data.CartItemHibernate;

public class CartItemService {
	@Autowired
	private static CartItemDAO cid = new CartItemHibernate();
	
	public Set<CartItem> getCart(Human human) {
		// TODO Auto-generated method stub
		return cid.getCart(human);
	}

}
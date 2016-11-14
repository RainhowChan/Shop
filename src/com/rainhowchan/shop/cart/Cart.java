package com.rainhowchan.shop.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private Map<Integer,CartItem> map=new HashMap<Integer,CartItem>();
	private Double total;
	
	public void addCart(CartItem cartItem){
		Integer pid = cartItem.getProduct().getPid();
		CartItem preCartItem = map.get(pid);
		if(preCartItem!=null){
			cartItem.setCount(preCartItem.getCount()+cartItem.getCount());
		}else{
			map.put(pid, cartItem);
		}
		total+=cartItem.getSubtotal();
	}
	
	public void removeCart(Integer id){
		CartItem cartItem = map.remove(id);
		total-=cartItem.getSubtotal();
	}
	
	public void clearCart(){
		map.clear();
		total=0d;
	}
	
}

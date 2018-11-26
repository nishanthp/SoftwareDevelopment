package com.java.patterns;

import java.util.ArrayList;

/**
 * Each action in this pattern is encapsulated within an object, thereby making
 * each object a command.
 * 
 * @author prakasni
 *
 */
public class CommandPatternDemo {
	public static void main(String[] args) {
		BuyStock buyCommand = new BuyStock(new Stock("infy"));
		SellStock sellCommand = new SellStock(new Stock("infy"));

		StockBroker broker = new StockBroker();
		broker.takeOrders(buyCommand);
		broker.takeOrders(sellCommand);

		broker.placeOrder();
	}
}

class StockBroker {
	private ArrayList<Order> orders = new ArrayList<>();

	public void takeOrders(Order order) {
		orders.add(order);
	}

	public void placeOrder() {
		for (Order order : orders) {
			order.execute();
		}
	}
}

interface Order {
	public void execute();
}

class BuyStock implements Order {
	Stock stock;

	public BuyStock(Stock s) {
		this.stock = s;
	}

	@Override
	public void execute() {
		this.stock.buy();

	}

}

class SellStock implements Order {
	Stock stock;

	public SellStock(Stock s) {
		this.stock = s;
	}

	@Override
	public void execute() {
		this.stock.sell();

	}

}

class Stock {
	String name;

	public Stock(String stockName) {
		this.name = stockName;
	}

	public void buy() {
		System.out.println("Bought " + this.name + " stock.");
	}

	public void sell() {
		System.out.println("Sold " + this.name + " stock.");
	}
}
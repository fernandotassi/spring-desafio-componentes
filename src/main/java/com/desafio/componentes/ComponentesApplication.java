package com.desafio.componentes;

import java.util.Locale;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.desafio.entities.Order;
import com.desafio.services.*;;

@SpringBootApplication
@ComponentScan({"com.desafio"})
public class ComponentesApplication implements CommandLineRunner
{
	@Autowired
	private OrderService orderService;

	@Autowired
	private ShippingService shippingService;

	@Autowired
	private Order order;

	public static void main(String[] args) 
        {
		SpringApplication.run(ComponentesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		int code = scan.nextInt();
		double basic = scan.nextDouble();
		double discount = scan.nextDouble();
		order = new Order(code, basic, discount);
		System.out.println();
        System.out.println("Pedido código " + order.getCode());
		System.out.println("Valor total: " + 
		    String.format("%.2f",(orderService.total(order) + shippingService.shipment(order))));
		scan.close();	
	}
}

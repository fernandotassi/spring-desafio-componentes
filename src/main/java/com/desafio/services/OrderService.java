package com.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafio.entities.Order;

@Service
public class OrderService 
{
    @Autowired
    private Order order;

    public double total(Order order)
    {
        return order.getBasic() - order.getBasic() * order.getDiscount() / 100;       
    }

}

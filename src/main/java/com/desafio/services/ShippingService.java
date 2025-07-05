package com.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafio.entities.Order;

@Service
public class ShippingService 
{
    @Autowired
    private Order order;

    public double shipment(Order order)
    {
        if(order.getBasic() < 100.)
          return 20.;
        if(order.getBasic() < 200.)
          return 12.;
        else  
          return 0.;
    }
}

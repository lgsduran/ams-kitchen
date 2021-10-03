package br.com.mesttra.amsKitchen.amqp;

import java.util.List;

import br.com.mesttra.amsKitchen.entity.KitchenItem;
import br.com.mesttra.amsKitchen.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KitchenRequestMessage {

    private List<KitchenItem> items;

    private String orderId;
    
    private OrderStatus barStatus;

}

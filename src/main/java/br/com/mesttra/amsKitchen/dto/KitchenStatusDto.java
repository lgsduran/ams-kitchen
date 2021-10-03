package br.com.mesttra.amsKitchen.dto;

import br.com.mesttra.amsKitchen.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class KitchenStatusDto {
	
	private OrderStatus barStatus;

}

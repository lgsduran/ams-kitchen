package br.com.mesttra.amsKitchen.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;


@EntityScan
@NoArgsConstructor
@Data
@Document(collection = "KitchenItem")
public class KitchenItem {

    @Id
    private String id;

    private String name;

    private Integer quantity;

    private String note;


}

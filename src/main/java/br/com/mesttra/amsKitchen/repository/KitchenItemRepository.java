package br.com.mesttra.amsKitchen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mesttra.amsKitchen.amqp.KitchenRequestMessage;

public interface KitchenItemRepository extends MongoRepository<KitchenRequestMessage, String> {

}

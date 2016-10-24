package com.company;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Troy on 10/23/16.
 */
public interface MessageRepository extends CrudRepository<Message,Integer> {
}

package com.third.solrspring.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.third.solrspring.model.Order;

public interface Repository extends SolrCrudRepository<Order, Long>{

	Order findByOrderid(Long orderid);

}

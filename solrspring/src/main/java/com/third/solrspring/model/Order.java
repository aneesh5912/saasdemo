package com.third.solrspring.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "Order")
public class Order {
	
	@Id
	@Field
	private long orderid;
	@Field
	private String productName;
	@Field
	private String customerName;
	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
//	public Order(long orderid, String productName, String customerName) {
//		super();
//		this.orderid = orderid;
//		this.productName = productName;
//		this.customerName = customerName;
//	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", productName=" + productName + ", customerName=" + customerName + "]";
	}
	
	
	
	
	
	

}

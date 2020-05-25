package com.solrj.demo1.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.solrj.demo1.model.Person;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

@RestController
public class Controller {
	
	
	
	
	/*@PostConstruct
	public void addPerson()throws IOException,
	SolrServerException
	{
		SolrClient server = new HttpSolrClient.Builder("http://localhost:8983/solr/person").build();
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("name", "Aneesh");
		doc.addField("age", 22);
		server.add(doc);
		server.commit();
	}
	*/
	
	
	@PostMapping("/person")
	  	public String createPerson(@RequestBody Person person)throws IOException,
		SolrServerException 
	{
		SolrClient server = new HttpSolrClient.Builder("http://localhost:8983/solr/person").build();
		SolrInputDocument doc = new SolrInputDocument();
		String description = "Person Created";
		doc.addField("name", person.getName());
		doc.addField("age",person.getAge());
		server.add(doc);
		server.commit();
		return description;
	 }
	
	 @GetMapping("/person/{searchName}")
	 public void readPerson(@PathVariable String searchName)throws IOException,
		SolrServerException 
	 {
		 
		 SolrClient server = new HttpSolrClient.Builder("http://localhost:8983/solr/person").build();
		 SolrQuery solrQuery = new SolrQuery();
		 
		 //System.out.println("Check1!!!");
		 
	        solrQuery.setQuery("*:*");
	        solrQuery.addFilterQuery("name:"+searchName);
	        solrQuery.setStart(0);
	        solrQuery.setRows(10);
	        
	        //System.out.println("Check2!!!");

	        QueryResponse queryResponse = server.query(solrQuery);
	        SolrDocumentList solrDocs = queryResponse.getResults();
	        Iterator<SolrDocument> iterator = solrDocs.iterator();
	        while (iterator.hasNext()) {
	            SolrDocument solrDocument = iterator.next();
	            int docAge = (int)solrDocument.getFieldValue("age");
	            String docName = (String) solrDocument.getFieldValue("name");
	            System.out.println("Name:"+docName+"Age:"+docAge);
	            
	        }
	        //System.out.println("Check3!!!");
	 }
	 
	 
	 @DeleteMapping("/person/delete/{searchName}")
	 public String deletePerson(@PathVariable String searchName)throws IOException,
		SolrServerException  
	 {
		 SolrClient server = new HttpSolrClient.Builder("http://localhost:8983/solr/person").build();
		 String description = "Person Deleted";
		 SolrInputDocument doc = new SolrInputDocument();
	        server.deleteByQuery("name:"+searchName);
	        server.commit();
		 
		 
		 return description;
	 }
	 
	 
	 @GetMapping("/person/getAll")
	 public void readAll()throws IOException,
		SolrServerException
	 {
		 SolrClient server = new HttpSolrClient.Builder("http://localhost:8983/solr/person").build();
		 SolrQuery solrQuery = new SolrQuery();
		 solrQuery.setQuery("*:*");
		 solrQuery.setStart(0);
	     solrQuery.setRows(10);
	     QueryResponse queryResponse = server.query(solrQuery);
	        SolrDocumentList solrDocs = queryResponse.getResults();
	        Iterator<SolrDocument> iterator = solrDocs.iterator();
	        while (iterator.hasNext()) {
	            SolrDocument solrDocument = iterator.next();
	            int docAge = (int)solrDocument.getFieldValue("age");
	            String docName = (String) solrDocument.getFieldValue("name");
	            System.out.println("Name:"+docName+"Age:"+docAge);
	            
	        }
	 }
		 

}

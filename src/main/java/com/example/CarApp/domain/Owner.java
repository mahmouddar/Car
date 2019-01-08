package com.example.CarApp.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Owner {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long ownerid;
  private String firstname, lastname;
  
	

@OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnore
      private List<Car> cars;




  
  public Owner() {}
  

  public Owner(String firstname, String lastname) {
    super();
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public long getOwnerid() {
    return ownerid;
  }
  public void setOwnerid(long ownerid) {
    this.ownerid = ownerid;
  }
  public String getFirstname() {
    return firstname;
  }
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }
  public String getLastname() {
    return lastname;
  }
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public List<Car> getCars() {
	    return cars;
	  }

	  public void setCars(List<Car> cars) {
	    this.cars = cars;
	  }
}


package com.MiniRedditt.domain;

import java.util.HashSet;
import java.util.Set;

import com.MiniRedditt.security.Authority;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User
{
  private Long id;
  private String username;
  private String password;
  private String name;
  Set<Authority> authorities= new HashSet<>();
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", authorities="
			+ authorities + "]";
}
@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
  public Set<Authority> getAuthorities() {
	return authorities;
}
public void setAuthorities(Set<Authority> authorities) {
	this.authorities = authorities;
}
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  public Long getId()
  {
    return id;
  }
  public void setId(Long id)
  {
    this.id = id;
  }
  public String getUsername()
  {
    return username;
  }
  public void setUsername(String username)
  {
    this.username = username;
  }
  public String getPassword()
  {
    return password;
  }
  public void setPassword(String password)
  {
    this.password = password;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
 
 
}
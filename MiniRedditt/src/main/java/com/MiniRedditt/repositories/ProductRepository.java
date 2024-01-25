package com.MiniRedditt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MiniRedditt.domain.Product;
//crud ops
public interface ProductRepository extends JpaRepository<Product,Long> {

}

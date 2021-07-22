package com.example.ABC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ABC.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{

}

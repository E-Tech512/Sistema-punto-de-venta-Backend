package com.proyecto01.proyecto01.Repository;

import com.proyecto01.proyecto01.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}

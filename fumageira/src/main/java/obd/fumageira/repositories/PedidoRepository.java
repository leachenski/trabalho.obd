package obd.fumageira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import obd.fumageira.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
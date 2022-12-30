package br.com.sdconecta.estagio.api;

import br.com.sdconecta.estagio.model.Pedido;
import br.com.sdconecta.estagio.model.status.StatusPedido;
import br.com.sdconecta.estagio.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class OfertaRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("{status}")
    public List<Pedido> getPedidosAguardando(@PathVariable("status") String status){
        return pedidoRepository.findByStatusPedido(
                StatusPedido.valueOf( status.toUpperCase()),
                PageRequest.of(0,5,
                        Sort.by("id").descending())
        );
    }

}

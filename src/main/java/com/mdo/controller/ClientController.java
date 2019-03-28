package com.mdo.controller;

import com.mdo.model.Client;
import com.mdo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping(value = "/addClient")
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @PostMapping(value = "/editClient")
    public void editClient(@RequestBody Client client) {
        clientService.editClient(client);
    }

    @DeleteMapping(value = "/deleteClient")
    public void deleteClient(@RequestBody Client client) {
        clientService.deleteClient(client);
    }

    @GetMapping(value = "/getClientById/{clientId}")
    public Client getClientById(@PathVariable Integer clientId) {
        Client client = clientService.getClientById(clientId);
        System.out.println(client);
        return client;
    }

    @GetMapping(value = "/getAllClients")
    public List<Client> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        System.out.println(clients);
        return clients;
    }

}

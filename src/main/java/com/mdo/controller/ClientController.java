package com.mdo.controller;

import com.mdo.model.Client;
import com.mdo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/getAllClients", method = RequestMethod.GET)
    public List<Client> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        System.out.println(clients);
        return clients;
    }

}

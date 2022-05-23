package com.itis.controllers;

import com.itis.dto.OrderCartDto;
import com.itis.dto.ProductQLDto;
import com.itis.models.Client;
import com.itis.models.Order;
import com.itis.repositories.OrderRepository;
import com.itis.service.CartMethodsService;
import com.itis.service.CartPersistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private CartPersistService cartPersistService;
    private OrderRepository orderRepository;
    private CartMethodsService cartMethodsService;

    @RequestMapping(method = RequestMethod.GET)
    public String getPage(Model model, HttpSession session) {
        Client client = (Client) session.getAttribute("client");
        Order order = cartPersistService.persistCart(client);
        model.addAttribute("order", OrderCartDto.from(order));
        model.addAttribute("pr_links", ProductQLDto.from(order.getWares()));
        return "cart";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public void addProductToCart(@RequestParam("q") Long quantity,
                                 @RequestParam("id") Long productId,
                                 HttpServletResponse resp,
                                 HttpSession session) throws IOException {
        Client client = (Client) session.getAttribute("client");
        cartMethodsService.addProduct(client, quantity, productId);
        resp.getWriter().write("success");

    }

    @RequestMapping(value = "/changeQuantity", method = RequestMethod.POST)
    public String changeProductQuanity(@RequestParam("q") Long quanity,
                                       @RequestParam("linkId") Long productQLinkId,
                                       HttpServletResponse resp) {
        cartMethodsService.changeProductQuantity(quanity, productQLinkId);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/removeItem", method = RequestMethod.POST)
    public String removeFromCart(@RequestParam("linkId") Long productQLinkId) {
        cartMethodsService.delete(productQLinkId);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public String buy(@RequestParam("client_id") Long clientId) {
        cartMethodsService.buy(clientId);
        return "redirect:/cart";
    }
}

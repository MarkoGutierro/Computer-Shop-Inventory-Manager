package com.example.demo.controllers; //package containing controllers

//import necessary annotations
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.demo.repositories.ProductRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.domain.Product;
import java.util.Optional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller//annotation to specify the class is a controller
public class BuyNowController {

    @Autowired
    private ProductRepository productRepository; //object with methods allowing for interaction with the database

    @PostMapping("/buyProduct") //buy product requests sent here
    public String buyProduct(@RequestParam long productId, RedirectAttributes redirectAttributes) {

        Optional<Product> optionalProduct = productRepository.findById(productId); //was product found in database or not

        if(optionalProduct.isPresent()){ //if the product was found
            Product product = optionalProduct.get(); //safe to create an object
            if(product.getInv() > 0){ //decrement inventory by 1 if product inventory is above 0
                product.setInv(product.getInv() - 1);
                productRepository.save(product); //update existing product record
                redirectAttributes.addFlashAttribute("message", "Purchase of \"" + product.getName() + "\" successful!");
            }
            else{ //display message when product is out of stock
                redirectAttributes.addFlashAttribute("message", "Product out of stock!");
            }
        }
        else{ //display message when the product is not found
            redirectAttributes.addFlashAttribute("message", "Product not found!");
        }
        return "redirect:/mainscreen"; //reload the page w/ updated info
    }
}



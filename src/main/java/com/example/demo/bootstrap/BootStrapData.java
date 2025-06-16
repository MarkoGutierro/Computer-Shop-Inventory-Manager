package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (outsourcedPartRepository.count() == 0) {
            //Create CPU object, set properties, and save to repository
            OutsourcedPart cpu = new OutsourcedPart();
            cpu.setCompanyName("Marko's Computer Shop");
            cpu.setName("CPU");
            cpu.setInv(5);
            cpu.setPrice(249.99);
            cpu.setId(100L);
            cpu.setMinInv(0);
            cpu.setMaxInv(1000);
            outsourcedPartRepository.save(cpu);

            //Create SSD object, set properties, and save to repository
            OutsourcedPart ssd = new OutsourcedPart();
            ssd.setCompanyName("Marko's Computer Shop");
            ssd.setName("SSD");
            ssd.setInv(15);
            ssd.setPrice(100.00);
            ssd.setId(200L);
            ssd.setMinInv(0);
            ssd.setMaxInv(1000);
            outsourcedPartRepository.save(ssd);

            //Create RAM object, set properties, and save to repository
            OutsourcedPart ram = new OutsourcedPart();
            ram.setCompanyName("Marko's Computer Shop");
            ram.setName("RAM");
            ram.setInv(3);
            ram.setPrice(69.00);
            ram.setId(300L);
            ram.setMinInv(0);
            ram.setMaxInv(1000);
            outsourcedPartRepository.save(ram);

            //Create GPU object, set properties, and save to repository
            OutsourcedPart gpu = new OutsourcedPart();
            gpu.setCompanyName("Marko's Computer Shop");
            gpu.setName("GPU");
            gpu.setInv(500);
            gpu.setPrice(449.49);
            gpu.setId(400L);
            gpu.setMinInv(0);
            gpu.setMaxInv(1000);
            outsourcedPartRepository.save(gpu);

            //Create Computer Case object, set properties, and save to repository
            OutsourcedPart computerCase = new OutsourcedPart();
            computerCase.setCompanyName("Marko's Computer Shop");
            computerCase.setName("Computer Case");
            computerCase.setInv(7);
            computerCase.setPrice(49.99);
            computerCase.setId(500L);
            computerCase.setMinInv(0);
            computerCase.setMaxInv(1000);
            outsourcedPartRepository.save(computerCase);
        }

        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("CPU"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());

        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        //Create product objects, set properties, and save to repository
        if (productRepository.count() == 0) {
            Product gamingComputer = new Product("Gaming Computer", 1000.0, 15);
            Product miniComputer = new Product("Mini Computer", 800.0, 5);
            Product homeOfficeComputer = new Product("Home Office Computer", 650.0, 25);
            Product workStationComputer = new Product("Work Station Computer", 4000.0, 6);
            Product budgetComputer = new Product("Budget Computer", 250.0, 10);
            productRepository.save(gamingComputer);
            productRepository.save(miniComputer);
            productRepository.save(homeOfficeComputer);
            productRepository.save(workStationComputer);
            productRepository.save(budgetComputer);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());
    }
}

package Spring.springMvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public boolean saveProduct(Product p) {
        productRepo.save(p);
        return true;
    }

    public List<Product> getProducts() {
        return productRepo.findAll();
    }
}


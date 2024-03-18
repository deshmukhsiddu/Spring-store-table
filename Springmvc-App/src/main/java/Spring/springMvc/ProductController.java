package Spring.springMvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/loadForm")
    public ModelAndView loadForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/saveProduct")
    public ModelAndView saveProduct(@ModelAttribute("product") Product p) {
        productService.saveProduct(p);
        return new ModelAndView("redirect:/getAllProducts");
    }

    @GetMapping("/getAllProducts")
    public ModelAndView getAllProducts() {
        List<Product> products = productService.getProducts();
        ModelAndView modelAndView = new ModelAndView("data");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}

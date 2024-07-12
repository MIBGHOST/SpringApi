package com.springapi.Service;

import com.springapi.model.Product;
import com.springapi.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(101, "iphone", 50000),
//            new Product(102, "mouse", 5000),
//            new Product(103, "mac", 500000)
//    ));


    public List<Product> getAllProducts() {
//        return products;
        return productRepo.findAll();
    }

    public Optional<Product> getById(String prodId) {
//        return products.stream()
//                .filter(p -> p.getProdId() == prodId)
//                .findFirst().get();
        if(prodId!=null){
            return productRepo.findById(prodId);
        }else{
            return null;
        }

    }

    public Product addAProduct(Product product, MultipartFile imageFile) throws IOException {
//        return products.add(product);

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

        return productRepo.save(product);
    }

    public Product updateProd(Product product) {
//        return products.stream()
//                .filter(p -> p.getProdId() == product.getProdId())
//                .findFirst()
//                .map(newProduct -> {newProduct.setProdId(product.getProdId());
//                                    newProduct.setName(product.getName());
//                                    newProduct.setPrice(product.getPrice());
//                                    return true;
//                }).orElse(false);
        return productRepo.save(product);
    }

    public void deleteProductByID(String prodId) {
//        return products.removeIf(product -> product.getProdId()==prodId);
//        Product product =  products.stream()
//                .filter(p -> p.getProdId() == prodId)
//                .findFirst()
//                .orElse(null);
//        if(products != null){
//            products.remove(product);
//        }
//        return product;
                productRepo.deleteById(prodId);
    }
}

package com.example.apelsin_app.service;

import com.example.apelsin_app.dto.ProductDto;
import com.example.apelsin_app.entity.Attachment;
import com.example.apelsin_app.entity.AttachmentContent;
import com.example.apelsin_app.entity.Category;
import com.example.apelsin_app.entity.Product;
import com.example.apelsin_app.repository.AttachmentContentRepository;
import com.example.apelsin_app.repository.AttachmentRepository;
import com.example.apelsin_app.repository.CategoryRepository;
import com.example.apelsin_app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    final
    ProductRepository productRepository;
    final
    CategoryRepository categoryRepository;
    final
    AttachmentRepository attachmentRepository;
    final AttachmentContentRepository attachmentContentRepository;


    @SneakyThrows
    public void save(ProductDto dto) {

        Integer categoryId = dto.getCategory_id();

        Optional<Category> byId = categoryRepository.findById(categoryId);

        Category category = byId.get();
        Product product = new Product();
        product.setCategory(category);
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescreption(dto.getDescreption());
        if (!dto.getPhoto().isEmpty()) {
            Attachment attachment = new Attachment();
            attachment.setName(dto.getPhoto().getOriginalFilename());
            attachment.setSize(dto.getPhoto().getSize());
            attachment.setContent_type(dto.getPhoto().getContentType());
            Attachment save = attachmentRepository.save(attachment);
            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setAttachment(attachment);
            attachmentContent.setBytes(dto.getPhoto().getBytes());
            attachmentContentRepository.save(attachmentContent);
            product.setPhoto(attachment);
        }
        productRepository.save(product);
    }

    @SneakyThrows
    public void edit(Long id, ProductDto dto) {
        Optional<Product> byId = productRepository.findById(id);
        Product product = byId.get();
        Optional<Category> byId1 = categoryRepository.findById(dto.getCategory_id());
        Category category = byId1.get();

        Product product1 = product;
        product1.setName(dto.getName());
        product1.setPrice(dto.getPrice());
        product1.setDescreption(dto.getDescreption());
        product1.setCategory(byId1.get());
        if (dto.getPhoto().isEmpty()) {
            product1.setPhoto(null);
        } else {
            if (product.getPhoto() == null) {


                Attachment attachment = new Attachment();
                attachment.setName(dto.getPhoto().getOriginalFilename());
                attachment.setSize(dto.getPhoto().getSize());
                attachment.setContent_type(dto.getPhoto().getContentType());
                Attachment save = attachmentRepository.save(attachment);
                AttachmentContent attachmentContent = new AttachmentContent();
                attachmentContent.setBytes(dto.getPhoto().getBytes());
                attachmentContent.setAttachment(save);
                product.setPhoto(attachment);
            }else {
                Optional<Attachment> optionalAttachment = attachmentRepository.findById(product.getPhoto().getId());
                if (optionalAttachment.isEmpty()) return;
                Attachment attachment = optionalAttachment.get();
                attachment.setName(dto.getPhoto().getOriginalFilename());
                attachment.setSize(dto.getPhoto().getSize());
                attachment.setContent_type(dto.getPhoto().getContentType());
                Attachment save = attachmentRepository.save(attachment);
                Optional<AttachmentContent> optionalAttachmentContent =
                        attachmentContentRepository.findByAttachment_id(save.getId());
                AttachmentContent attachmentContent;
                if (optionalAttachmentContent.isEmpty()) {
                    attachmentContent = new AttachmentContent();
                } else {
                    attachmentContent = optionalAttachmentContent.get();
                }
                attachmentContent.setBytes(dto.getPhoto().getBytes());
                attachmentContentRepository.save(attachmentContent);
            }

        }
        product.setCategory(category);
        Product save = productRepository.save(product);
    }

    public HttpEntity<?> getPhoto(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Product product = optionalProduct.get();
        if(product.getPhoto()==null){
            return ResponseEntity.status(302)
                    .header("Location", "/assets/icons/not-image.png")
                    .build();
        }
        Attachment attachment = product.getPhoto();
        Optional<AttachmentContent> optionalAttachmentContent =
                attachmentContentRepository.findByAttachment_id(attachment.getId());
        if(optionalAttachmentContent.isEmpty()){
            return ResponseEntity.status(302)
                    .header("Location", "/assets/icons/not-image.png").build();
        }
        return ResponseEntity.ok().header("Content-Type",attachment.getContent_type())
                .body(optionalAttachmentContent.get().getBytes());
    }

}

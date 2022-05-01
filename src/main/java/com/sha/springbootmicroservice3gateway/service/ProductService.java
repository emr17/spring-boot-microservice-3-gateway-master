package com.sha.springbootmicroservice3gateway.service;

import com.google.gson.JsonElement;
import com.sha.springbootmicroservice3gateway.request.IProductServiceRequest;
import com.sha.springbootmicroservice3gateway.util.RetrofitUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * @author sa
 * @date 18.04.2021
 * @time 14:08
 */
//logları yazdırmak için lombok
@Slf4j
@Service
public class ProductService implements IProductService
{
    //retrofitconfigurationda oluşturduğumuz bean nesnesi productServiceRequest
    @Autowired
    private IProductServiceRequest productServiceRequest;

    @Override
    public JsonElement saveProduct(JsonElement requestBody)
    {
        return RetrofitUtils.executeInBlock(productServiceRequest.saveProduct(requestBody));
    }

    @Override
    public void deleteProduct(Long productId)
    {
        RetrofitUtils.executeInBlock(productServiceRequest.deleteProduct(productId));
    }

    @Override
    public List<JsonElement> getAllProducts()
    {
        return RetrofitUtils.executeInBlock(productServiceRequest.getAllProducts());
    }
}

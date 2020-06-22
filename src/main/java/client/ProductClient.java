package client;

import com.google.gson.Gson;
import data.QueryPool;
import endPoints.HeaderBuilder;
import endPoints.ProductService;
import entities.ProductList;
import entities.ProductResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class ProductClient {

    public Response getProduct(){
        baseURI = "http://makeup-api.herokuapp.com";
        HeaderBuilder headerBuilder = new HeaderBuilder();
        Map<String,String> headers = headerBuilder.withDefault();
        QueryPool queryPool = new QueryPool();
        Map<String,String> query = queryPool.productQuery();

        Response response = RestAssured.given().log().all()
                .headers(headers).queryParams(query).get(ProductService.PRODUCT);

        Gson gson = new Gson();
        gson.fromJson(response.getBody().asString(), ProductResponse[].class);
        return response;
    }


}

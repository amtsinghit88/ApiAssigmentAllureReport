
import client.ProductClient;
import com.google.gson.JsonObject;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ReporterUtil;

public class ProductTest extends TestBase{


    @Test(groups = {"smoke"})
    @Description("find product type under product json")
    @Story("product.json")
    public void findProductDetails(){
        ProductClient productClient = new ProductClient();
        Response response = productClient.getProduct();
        Assert.assertEquals(response.getStatusCode(),200);
        findProductInteralDetails(response.getBody());

    }

    private void findProductInteralDetails(ResponseBody body) {
        JSONArray jsonArray = new JSONArray(body.asString());
        for(int i=0;i<jsonArray.length();i++){
            int count=0;

            JSONArray jsonArray1 = new JSONArray(jsonArray.getJSONObject(i).get("product_colors").toString());

            for(int j=0;j<jsonArray1.length();j++){

                //JSONObject jsonObject1 = new JSONObject(jsonArray1.getJSONObject(j));

                if(jsonArray1.getJSONObject(j).get("colour_name").toString().toLowerCase().contains("black")){
                    count++;
                }
            }

            if(count>0){
                ReporterUtil.log(jsonArray.getJSONObject(i).get("name").toString()+" "+
                        jsonArray.getJSONObject(i).get("price").toString()+" "+
                jsonArray.getJSONObject(i).get("rating").toString());
                ReporterUtil.log("Total number of produuct"+count);
            }

        }

    }


}

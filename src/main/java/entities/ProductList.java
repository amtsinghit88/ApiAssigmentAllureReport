package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

    @Getter
    @Setter
    public class ProductList {

        private String id;
        private String brand;
        private String name;
        private String price;
        private String price_sign;
        private String currency;
        private String image_link;
        private String product_link;
        private String website_link;
        private String description;
        private String rating;
        private String category;
        private String product_type;
        private String[] tag_list;
        private String created_at;
        private String updated_at;
        private String product_api_url;
        private String api_featured_image;
        private List<ProductColor> product_colors;
    }

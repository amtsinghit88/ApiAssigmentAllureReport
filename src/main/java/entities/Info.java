package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @JsonIgnoreProperties(ignoreUnknown = true) @JsonInclude(JsonInclude.Include.NON_NULL)
public class Info {
    private Integer statusCode;
    private String status;
    private String message;

    @Override
    public String toString() {
        return "Info{" +
                "code=" + statusCode +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

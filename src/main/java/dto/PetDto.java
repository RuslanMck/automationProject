package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
// @Jacksonized генерирует 2 констуктора, с параметрами и без
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetDto {

//    private long id;
    private String name;
    private String status;
}

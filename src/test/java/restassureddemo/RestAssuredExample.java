package restassureddemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.PetDto;
import dto.PetOrderDto;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAssuredExample {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private  RequestSpecification requestSpecification;

    private String petId;
    private String petOrderId;

    private PetDto petDto;

    @BeforeClass
    private void setup(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build();

        petDto = PetDto
                .builder()
                .status("available")
                .name("Barsik")
                .build();
    }


    @SneakyThrows
    private String createPet(){
       return  RestAssured
               .given()
               .spec(requestSpecification)
               .body(new ObjectMapper().writeValueAsString(petDto))
               .when()
               .post("/pet")
               .then() //проверки
               .statusCode(200)
               .extract()
               .body()
               .jsonPath()
               .getString("id");
    }


    @Test
    @SneakyThrows
    public void getCreatedPet() {

        petId = createPet();

        JsonPath jsonResponsePet = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/pet/" + petId)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        PetDto responsePet = new ObjectMapper().readValue(jsonResponsePet.prettify(), PetDto.class);

        Assert.assertEquals(petDto, responsePet);

    }

    @Test
    @SneakyThrows
    public void placeOrder(){

        petId = createPet();

        PetOrderDto requestPetOrder = PetOrderDto.builder().petId(Long.valueOf(petId)).quantity(1).build();

        petOrderId = RestAssured
                .given()
                .spec(requestSpecification)
                .body(new ObjectMapper().writeValueAsString(requestPetOrder))
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getString("id");

        JsonPath jsonResponseOrder = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/store/order/" + petOrderId)
                .then()
                .statusCode(200)
                .extract()
                .jsonPath();

        PetOrderDto responsePetOrder = new ObjectMapper().readValue(jsonResponseOrder.prettify(), PetOrderDto.class);

        Assert.assertEquals(requestPetOrder, responsePetOrder);

        System.out.println("petId from request = " + requestPetOrder.getPetId() + "\n"
                + "petId from response = " + responsePetOrder.getPetId());
    }
}
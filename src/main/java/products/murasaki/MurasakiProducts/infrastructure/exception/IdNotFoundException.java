package products.murasaki.MurasakiProducts.infrastructure.exception;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException (String message){
        super(message);
    }
}

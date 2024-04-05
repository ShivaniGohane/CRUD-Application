package SUNBASE_.Assignment.CRUD_Application.Exceptions;

public class CustomerAlreadyExist extends RuntimeException{
    public CustomerAlreadyExist(String str){
        super(str);
    }
}

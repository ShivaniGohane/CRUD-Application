package SUNBASE_.Assignment.CRUD_Application.Controller;


import SUNBASE_.Assignment.CRUD_Application.Dto.RequestDto.CustomerRequestDto;
import SUNBASE_.Assignment.CRUD_Application.Dto.ResponseDTO.CustomerResponseDto;
import SUNBASE_.Assignment.CRUD_Application.Exceptions.CustomerAlreadyExist;
import SUNBASE_.Assignment.CRUD_Application.Exceptions.CustomerNotFound;
import SUNBASE_.Assignment.CRUD_Application.Service.CustomerService;
import SUNBASE_.Assignment.CRUD_Application.Service.RemoteAPICall;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;

    RemoteAPICall remoteAPICall = new RemoteAPICall();


    @PostMapping("/create")
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto customerRequestDto, @RequestParam boolean SyncDb ){

        try {
            CustomerResponseDto customerResponseDto =customerService.createCustomer(customerRequestDto,SyncDb);
            return new ResponseEntity<>(customerResponseDto, HttpStatus.CREATED);
        }
        catch (CustomerAlreadyExist e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{email}")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable String email,@RequestBody CustomerRequestDto customerRequestDto){
        try{
            CustomerResponseDto customerResponseDto = customerService.udapteCustomer(email,customerRequestDto);
            return new ResponseEntity<>(customerResponseDto,HttpStatus.ACCEPTED);
        }catch (CustomerNotFound e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<Page<CustomerResponseDto>> getAllCustomers(@RequestParam int pageNo, @RequestParam int rowsCount, @RequestParam(required = false)String sortBy, @RequestParam(required = false) String searchBy){

        Page<CustomerResponseDto> customerList = customerService.getAllCustomers(pageNo, rowsCount, sortBy, searchBy);
        return new ResponseEntity<>(customerList, HttpStatus.FOUND);

    }

    @GetMapping("/get/{email}")
    public ResponseEntity<CustomerResponseDto> getCustomerWithId(@PathVariable String email){

        try{
            CustomerResponseDto customerResponseDto = customerService.getCustomerWithId(email);
            return new ResponseEntity<>(customerResponseDto, HttpStatus.FOUND);
        }catch (CustomerNotFound e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/searchBy")
    public ResponseEntity<List<CustomerResponseDto>> searchBySpecificType(@RequestParam String searchBy,@RequestParam String searchQuery){
        List<CustomerResponseDto>   searchedResult = customerService.searchBySpecificType(searchBy,searchQuery);
        return new ResponseEntity<>(searchedResult,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteCustomer(@RequestParam String email){
        try{
            String result =customerService.deleteCustomer(email);
            return new ResponseEntity(result,HttpStatus.ACCEPTED);
        }catch (CustomerNotFound e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/sync")
    public ResponseEntity<Object[]> getTokenFromApi(){
        Object[] customerObject =remoteAPICall.getTokenFromApi();
        return new ResponseEntity<>(customerObject,HttpStatus.ACCEPTED);
    }
}

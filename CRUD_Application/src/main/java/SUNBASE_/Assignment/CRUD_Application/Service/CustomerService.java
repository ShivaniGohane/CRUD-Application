package SUNBASE_.Assignment.CRUD_Application.Service;


import SUNBASE_.Assignment.CRUD_Application.Dto.RequestDto.CustomerRequestDto;
import SUNBASE_.Assignment.CRUD_Application.Dto.ResponseDTO.CustomerResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CustomerService {

    CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto , boolean SyncDb);

    CustomerResponseDto udapteCustomer(String email , CustomerRequestDto customerRequestDto);


    String deleteCustomer(String email);

    CustomerResponseDto getCustomerWithId(String email);

    List<CustomerResponseDto> searchBySpecificType(String searchBy, String searchQuery);

    Page<CustomerResponseDto> getAllCustomers(int pageNo, int rowsCount, String sortBy, String searchBy);
}
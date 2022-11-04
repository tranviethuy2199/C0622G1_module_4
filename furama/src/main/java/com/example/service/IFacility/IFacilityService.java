package com.example.service.IFacility;

import com.example.model.customer.Customer;
import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    // show danh sách customer
    List<Facility> findAll();

    // tìm customer theo id
    Facility findById(Integer id);

    // lưu khi add customer
    void save(Facility facility);

    // xóa customer
    void remove(Facility facility);

    // phân trang
    Page<Facility> findAll(Pageable pageable);

    //tìm theo tên
//    List<Facility> findCustomerByName(String CustomerName);
}

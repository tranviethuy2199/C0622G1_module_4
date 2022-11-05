package com.example.controller;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.model.facility.Facility;
import com.example.model.facility.RentType;
import com.example.model.facility.StandardRoom;
import com.example.service.IFacility.IFacilityService;
import com.example.service.IFacility.IRentTypeService;
import com.example.service.IFacility.IStandardRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IStandardRoomService standardRoomService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/facility")
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable) {
        Page<Facility> facilities = facilityService.findAll(pageable);
        List<StandardRoom> standardRooms = standardRoomService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/facility/list");
        modelAndView.addObject("facilities", facilities);
        modelAndView.addObject("standardRooms", standardRooms);
        modelAndView.addObject("rentTypes", rentTypes);
        return modelAndView;
    }

    @GetMapping("/facility/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/facility/create");
        List<StandardRoom> standardRooms = standardRoomService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        modelAndView.addObject("facilities", new Facility());
        modelAndView.addObject("standardRooms", standardRooms);
        modelAndView.addObject("rentTypes", rentTypes);
        return modelAndView;
    }

    @PostMapping("/facility/create")
    public ModelAndView createBlog(@ModelAttribute("facility") Facility facility) {
        facilityService.save(facility);
        List<StandardRoom> standardRooms = standardRoomService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/facility/create");
        modelAndView.addObject("facilities", facility);
        modelAndView.addObject("standardRooms", standardRooms);
        modelAndView.addObject("rentTypes", rentTypes);
        modelAndView.addObject("message", "facility created successfully");
        return modelAndView;
    }

    @GetMapping("/facility/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable int id) {
        Facility facility = facilityService.findById(id);
        List<StandardRoom> standardRooms = standardRoomService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        if (facility != null) {
            ModelAndView modelAndView = new ModelAndView("/facility/edit");
            modelAndView.addObject("facilities", facility);
            modelAndView.addObject("standardRooms", standardRooms);
            modelAndView.addObject("rentTypes", rentTypes);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/facility/delete{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Facility facility = facilityService.findById(id);
        List<StandardRoom> standardRooms = standardRoomService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        if (facility != null) {
            ModelAndView modelAndView = new ModelAndView("/facility/delete");
            modelAndView.addObject("facilities", facility);
            modelAndView.addObject("standardRooms", standardRooms);
            modelAndView.addObject("rentTypes", rentTypes);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/facility/delete{id}")
    public String delete(@ModelAttribute("facility") Facility facility) {
        facilityService.remove(facility);
        return "redirect:facility";
    }

    @GetMapping("/facility/view{id}")
    public ModelAndView view(@PathVariable int id) {
        Facility facility = facilityService.findById(id);

        if (facility != null) {
            ModelAndView modelAndView = new ModelAndView("/view");
            modelAndView.addObject("facility", facility);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

//    @GetMapping("/find")
//    public ModelAndView find(@RequestParam String CustomerName) {
//        List<Facility> facilities = facilityService.findCustomerByName(CustomerName);
//        ModelAndView modelAndView = new ModelAndView("/facility/index");
//        modelAndView.addObject("facilities", facilities);
//        return modelAndView;
//    }

}

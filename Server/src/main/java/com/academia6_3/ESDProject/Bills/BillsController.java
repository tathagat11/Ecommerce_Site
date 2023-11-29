package com.academia6_3.ESDProject.Bills;

import com.academia6_3.ESDProject.OtherObjects.BillsDTO;
import com.academia6_3.ESDProject.Students.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bills")
public class BillsController {

    private final BillsService billsService;

    @Autowired
    public BillsController(BillsService billsService) {
        this.billsService = billsService;
    }

    @PostMapping(path = "/addBills")
    public void addBills(@RequestBody BillsDTO billsDTO) {
        billsService.addBills(billsDTO);
    }

    @GetMapping(path = "/getbillroll/{rollNo}")
    public ResponseEntity<List<Bills>> getBillsByRoll(@PathVariable Integer rollNo){
        return new ResponseEntity<>(billsService.getBillsByRoll(rollNo), HttpStatus.OK);
    }

}

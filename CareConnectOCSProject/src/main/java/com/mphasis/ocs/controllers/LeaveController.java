package com.mphasis.ocs.controllers;

 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 

import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Leave;
import com.mphasis.ocs.services.LeaveService;

 

 


@RestController
public class LeaveController {
    @Autowired
    LeaveService leaveService;

 

    @RequestMapping(value="/addleave/{fromdate}/{todate}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public String addLeave(@RequestBody Leave l,@PathVariable("fromdate")String fromDate,@PathVariable("todate")String toDate) throws BusinessException {
        Map<String,String> response=new HashMap<>();
        fromDate=fromDate.replace("-","/");
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
         Date fromDate1=null;
        try {
            fromDate1 = formatter1.parse(fromDate);
                    } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        toDate=toDate.replace("-","/");
        SimpleDateFormat formatter2=new SimpleDateFormat("dd/MM/yyyy");
         Date toDate2=null;
        try {
            toDate2 = formatter1.parse(toDate);
            
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        l.setFromDate(fromDate1);
        l.setToDate(toDate2);
        l.setLeaveStatus("pending");
        String s=leaveService.insertLeave(l);
        return s;

 

    }
    @RequestMapping(value="/updateleave",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
    public void updateLeave1(@RequestBody Leave l) {
        Map<String,String> response=new HashMap<>();
        leaveService.updateLeave(l);
    }

 


    @RequestMapping(value="/getleavebyid/{lid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Leave getLeaveById1(@PathVariable("lid")String lid) {
        Map<String,String> response=new HashMap<>();
        Leave l=null;
        l=leaveService.getLeaveById(lid);
        System.out.println(l);
        return l;

 

    }

 


    @RequestMapping(value="/getleavesbystatus",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Leave> getLeaveByStatus1() {

 

        List<Leave> leaves=null;
        Map<String,String> response=new HashMap<>();
        try {
            leaves=leaveService.getLeavesByStatus("pending");

 

        }catch(BusinessException e) {
            e.printStackTrace();

 

        }
        return leaves;
    }

 

    @RequestMapping(value="/getleavesbydoctor",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Leave> getLeaveByDoctor(@RequestBody Doctor doctor){
        List<Leave> leaves1=null;

 

        try {
            leaves1=leaveService.getLeavesByDoctor(doctor);

 

        }catch(BusinessException e) {
            e.printStackTrace();

 

        }
        return leaves1;

 

    }
    @RequestMapping(value="/checkandreqleave/{did}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public int  checkAndReqLeave(@PathVariable("did")String did) {
       
       return leaveService.checkAndReqLeave(did);
    }
}
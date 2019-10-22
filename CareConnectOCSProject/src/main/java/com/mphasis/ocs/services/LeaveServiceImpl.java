package com.mphasis.ocs.services;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.ocs.daos.DoctorDao;
import com.mphasis.ocs.daos.LeaveDao;
import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Appointment;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Leave;
@Service
public class LeaveServiceImpl implements LeaveService {
	@Autowired
	private LeaveDao leaveDao;
	@Autowired
	private DoctorDao doctorDao;
	public String insertLeave(Leave l) {
       return leaveDao.insertLeave(l);
	}

	public void updateLeave(Leave l)  {
leaveDao.updateLeave(l);
	}

	public List<Leave> getLeavesByStatus(String status) throws BusinessException {
		List<Leave> leaves=leaveDao.getLeavesByStatus(status);
		if(leaves.isEmpty()) {
			throw new BusinessException("No leaves available");
		}
		return leaves;
	}

	public List<Leave> getLeavesByDoctor(Doctor doctor) throws BusinessException {
		List<Leave> leaves=leaveDao.getLeavesByDoctor(doctor);
		if(leaves.isEmpty()) {
			throw new BusinessException("No leaves available");
		}
		return leaves;
	}

	public Leave getLeaveById(String lid)  {
	 Leave leave=leaveDao.getLeaveById(lid);
		
		return leave;
	}
	public int checkAndReqLeave(String did)
    {
        int flag=0;
        Doctor d=doctorDao.getDoctorById(did);
        System.out.println(d+"Hloooooo");
        List<Leave> leaves=(List<Leave>) leaveDao.getLeavesByDoctor(d);
        System.out.println(leaves);
//        LocalDate today = LocalDate.now();
//        
//        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//         System.out.println(formattedDate+"in service for current date");
//        // s.replace("-","/");
//            SimpleDateFormat formatter2=new SimpleDateFormat("dd/MM/yyyy");
//             Date date1=null;
//            try {
//                date1 = formatter2.parse(formattedDate);
//                System.out.println(date1+"hlooooooooooooooo");
//            } catch (ParseException e1) {
//                // TODO Auto-generated catch block
//                e1.printStackTrace();
//            }
        String pattern="mm-dd-yyyy";
        SimpleDateFormat formatter=new SimpleDateFormat(pattern);
        String date=formatter.format(new Date());
    
        SimpleDateFormat formatter1=new SimpleDateFormat(pattern);
        Date date2=null;
		try {
			date2 = formatter1.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(date2);
        if(leaves.isEmpty())
        {
            System.out.println("allow him"+"hloooooooooo");
            return 1;
        }
        else
        {
        	 for (Leave leave : leaves) {
           	  System.out.println(leave.getToDate()+"leave date format");
             }
            for (Leave leave : leaves) {

                if(((leave.getToDate()).equals(date2))||((leave.getToDate()).after(date2)))
                {
                
          System.out.println("in date comparision");
                    flag=1;
                }
            }
            
        }
      if(flag==0)
          return 1;
      else
          return 0;
    }

}

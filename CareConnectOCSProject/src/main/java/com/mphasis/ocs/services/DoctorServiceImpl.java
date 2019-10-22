package com.mphasis.ocs.services;



import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.mphasis.ocs.daos.DoctorDao;
import com.mphasis.ocs.daos.PatientDao;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Patient;
import com.mphasis.ocs.exceptions.BusinessException;



@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	PatientDao patientDao;



	public void insertDoctor(Doctor d)throws BusinessException {
		if(d.getDname().matches("[A-Za-z]{3,20}")) {
			if(d.getPassword().matches(("[A-Za-z]{1,20}")/*&&("[0-9]{1,3}")*/)) {
				doctorDao.insertDoctor(d);
			}else {
				throw new BusinessException("password has to be in alphabates");
			}
		}
		else {
			throw new BusinessException("The name should contain only alphabets");
		}
	}



	public void updatedoctor(Doctor d) throws BusinessException {
		if(d.getDname().matches("[A-Za-z]{3,20}")) {
			if(d.getPassword().matches(("[A-Za-z]{1,20}")/*&&("[0-9]{1,3}")*/)) {
				doctorDao.updatedoctor(d);
			}else {
				throw new BusinessException("not updated");
			}
		}
		else {
			throw new BusinessException("The name should contain only alphabets");
		}
	}




	public void deletedoctor(String did)throws BusinessException {
		doctorDao.deletedoctor(did);

	}



	public List<Doctor> getAll() {
		return doctorDao.getAll();
	}



	public Doctor getDoctorById(String did)throws BusinessException {
		Doctor doctor=doctorDao.getDoctorById(did);
		if(doctor==null)
		{
			throw new BusinessException("no doctor available");
		}
		return doctor;

	}



	public Doctor login(String did, String password)throws BusinessException {
		Doctor doctor=doctorDao.login(did, password);
		if(doctor==null)
		{
			throw new BusinessException("invalid credentails");
		}
		return doctor;
	}



	public List<Doctor> getDoctorsByLocSym(String pid) {
        List<Doctor> doctors=doctorDao.getAll();
        List<Doctor> doctors1=new ArrayList<Doctor>();
        Patient p=patientDao.getPatientById(pid);
        for (Doctor doctor : doctors) {
           
             List<String> specializations=doctor.getSpecializations();
            for (String  spec :specializations) {
if((p.getSymptom().contains(spec)) && ((doctor.getLocation().getAreaName()).contains(p.getAreaName())))
{
     doctors1.add(doctor);
}
        break;
                    //List<Leave> leaves=(List<Leave>) leaveDao.getLeavesByDoctor(doctor);
                  }
        }
        return doctors1;
    }


	}




import { Component, OnInit } from '@angular/core';
import { OcsServiceService } from '../ocs-service.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Patient } from '../patient';

@Component({
  selector: 'app-patienthomepage',
  templateUrl: './patienthomepage.component.html',
  styleUrls: ['./patienthomepage.component.css']
})
export class PatienthomepageComponent implements OnInit {

  constructor(private _ocsServiceService:OcsServiceService,private _router:Router,private _activatedRoute:ActivatedRoute) { }

  patient:Patient
  pid:string;
  i:Number;
  adate:string;
  check=false;
  
  logout(){
    this._router.navigateByUrl('/homepage');
  }

  ngOnInit() {
   this.pid=this._activatedRoute.snapshot.paramMap.get("pid");
   
    this._ocsServiceService.getPatientByid(this.pid).subscribe(
      patient =>{
      this.patient=patient;
      },
      error =>
      {
        alert(error);
      }
    );
  }
 
  reqAppointment()
  {
    
    this._ocsServiceService.checkandReqAppointment(this.pid).subscribe(data =>
      { 
        this.i = data;console.log(data);  
      
        if(this.i === 1 ){
          this.check=true;
        }
     else if(this.i===2)
      {
            alert('you already have an appointment ,check in appointments information');
            this._router.navigate(['/patienthomepage/',this.pid]);
      }
      });
  }

  addsymptom()
  {
      this._router.navigate(['/updatepatient/',this.pid,this.adate]);

  }

  patientappointments()
  {
    this._ocsServiceService.getAppointmentsByPatient(this.pid).subscribe(
      data => {
       this._router.navigate(['/patientappointments/',this.patient.pid]);
      },
      error =>
      {
        alert(error);
      }
    );
  }
 
}

import { Component, OnInit } from '@angular/core';
import { OcsServiceService } from '../ocs-service.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Patient } from '../patient';
import { Appointment } from '../appointment';

@Component({
  selector: 'app-patientappointments',
  templateUrl: './patientappointments.component.html',
  styleUrls: ['./patientappointments.component.css']
})
export class PatientappointmentsComponent implements OnInit {
 
  pid:String;
  patient:Patient;
  appointments:Appointment[];
  constructor(private _ocsService:OcsServiceService,private _router:Router,private _activatedRoute:ActivatedRoute) { }

  logout(){
    this._router.navigateByUrl('/homepage');
  }

  ngOnInit() {
    this.pid=this._activatedRoute.snapshot.paramMap.get("pid");
    console.log(this.pid);
    this._ocsService.getPatientByid(this.pid).subscribe(
      patient =>{
      this.patient=patient;
      },
      error =>
      {
        alert(error);
      }
    );
this._ocsService.getAppointmentsByPatient(this.pid).subscribe(
  appointments =>{
    this.appointments=appointments;
  },
  error =>
  {
    alert(error);
  }
);
  }

}

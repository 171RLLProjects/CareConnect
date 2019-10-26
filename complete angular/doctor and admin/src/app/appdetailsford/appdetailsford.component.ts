import { Component, OnInit } from '@angular/core';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Appointment } from '../appointment';
import { Doctor } from '../doctor';

@Component({
  selector: 'app-appdetailsford',
  templateUrl: './appdetailsford.component.html',
  styleUrls: ['./appdetailsford.component.css']
})
export class AppdetailsfordComponent implements OnInit {

  private doctor=new Doctor;
  constructor( private _ocsService:OcsService,private _router:Router,private _activatedRouter:ActivatedRoute) { }

  private did:string;
  private appointments:Appointment[]; 
 
  ngOnInit() {
    this.did=this._activatedRouter.snapshot.paramMap.get('did');
    this._ocsService.getDoctorById(this.did).subscribe(doctor => { this.doctor = doctor;});
    console.log(this.doctor);
    this._ocsService.getAppointmentsByDoctor(this.did).subscribe(appointments => {this.appointments = appointments;});
    
    console.log(this.did);
   
     
  }

}

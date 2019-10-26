import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient';
import { OcsServiceService } from '../ocs-service.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {

  id:string;
  patient =new Patient;


  constructor(private _ocsServive:OcsServiceService,private _router:Router,private _activatedRoute:ActivatedRoute) { }

  ngOnInit() {
  }

  addPatient()
  {
    this.patient={
      "pid":this.patient.pid,
      "pname":this.patient.pname,
      "gender":this.patient.gender,
      "age":this.patient.age,
      "phnNo":this.patient.phnNo,
      "email":this.patient.email,
      "streetName":this.patient.streetName,
      "areaName":this.patient.areaName,
      "city":this.patient.city,
      "pincode":this.patient.pincode,
      "symptom":this.patient.symptom,
      "password":this.patient.password,
      "history":null
    };
    this._ocsServive.addPatient(this.patient).subscribe(
      data => {
        
        this.patient=data
        console.log(data);
        
        
       
        },
      
        
      );
      alert('registration is successfull, your id is:'+ this.patient.pid + 'use it to login');

      //alert('registration is successfull, your id is:'+ this.id + 'use it to login');
    }
  }


import { Component, OnInit } from '@angular/core';
import { Leave } from '../leave';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Doctor } from '../doctor';
import { Location } from '../location';
 
@Component({
  selector: 'app-addleave',
  templateUrl: './addleave.component.html',
  styleUrls: ['./addleave.component.css']
})
export class AddleaveComponent implements OnInit {
  leave= new Leave;
  doctor: Doctor;
  location:Location;
  fromDate:string;
  toDate:string;
 
  private did:string;
 
  constructor(private _ocsservice: OcsService, private router: Router,private _activatedRouter: ActivatedRoute) { }
 
  ngOnInit() {
   
  
    this.did=this._activatedRouter.snapshot.paramMap.get("did");
    
      this. _ocsservice.getDoctorById(this.did).subscribe(doctor =>
        {
      this.doctor= doctor;
      
        });
      
  }
  
  
    addLeave(){
 
    this.leave ={
    
       'lid':'',
     'fromDate': null,
     'toDate': null,
     'leaveStatus':"pending",
     'doctor':{
 
      'did': this.doctor.did,
      'dname': this.doctor.dname,
      'password': this.doctor.password,
      'specializations':this.doctor.specializations,
 
      'location':{
 
        'locid':this.doctor.location.locid,
       'streetName': this.doctor.location.streetName,
       'areaName': this.doctor.location.areaName,
       'city': this.doctor.location.city,
       'pincode':this.doctor.location.pincode ,
      }
    }
    
    };
    
      this._ocsservice.insertLeave(this.leave,this.fromDate,this.toDate ).subscribe();
      
        
      this.router.navigate(['/getleavesbydoctor/',this.did]);
         
          
      
     }
    }
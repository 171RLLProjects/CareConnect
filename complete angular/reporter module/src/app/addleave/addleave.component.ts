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
  fromDate: string;
  todate: string;
  did:string;

  constructor(private _ocsservice: OcsService, private router: Router,private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.leave.lid=this.activatedRoute.snapshot.paramMap.get('lid');
    if(this.leave.lid !== null){
    this.fromDate = this.activatedRoute.snapshot.paramMap.get('fromDate');
    this.leave.fromDate = new Date(this.fromDate);
    this.todate=this.activatedRoute.snapshot.paramMap.get('toDate');
    this.leave.toDate =new Date(this.fromDate);
    
      this. _ocsservice.getDoctorById(this.did).subscribe(doctor =>
        {
      this.doctor= doctor;
      
        });
    }
  }
  
  
    addLeave(){

    this.leave ={
    
       'lid':this.leave.lid,
     'fromDate': this.leave.fromDate, 
     'toDate': this.leave.toDate,
     leaveStatus:"pending",
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
    
    
      this._ocsservice.insertLeave(this.leave).subscribe(
      
          data => {
      this.router.navigate(['/leaves']);
          },
          error => {
            alert(error);
          });
      
     }
    }
    
    

  

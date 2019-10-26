import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';

import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '../location';
import { OcsService } from '../ocs.service';
@Component({
  selector: 'app-adddoctor',
  templateUrl: './adddoctor.component.html',
  styleUrls: ['./adddoctor.component.css']
})
export class AdddoctorComponent implements OnInit {
 
 // did:string;
  doctor =new Doctor;
  location=new Location;
  locations:Location[];
  locid:string;
  spec1:string;
  spec2:string;
  spec3:string;
  check=false;
  
  constructor(private _ocsService:OcsService,private _router:Router,private _activatedRoute:ActivatedRoute) { }
 
  ngOnInit() {
    this.doctor.did=this._activatedRoute.snapshot.paramMap.get("did");
    if(this.doctor.did!==null)
    {
    this._ocsService.getDoctorById(this.doctor.did).subscribe(data => {
    this.doctor = data;
    this.location=this.doctor.location;
    this.spec1=this.doctor.specializations[0];
    this.spec2=this.doctor.specializations[1];
    this.spec3=this.doctor.specializations[2];
    console.log(this.location.areaName);
    
    });
}
this._ocsService.getAllLocations().subscribe(
  locations =>{
    this.locations=locations;
  },
  error =>
  {
    alert(error);
  });
}
  addSpecialization()
  {
 
    this.check=true;
  }
 
  addDoctor()
  {
    
   
   this.doctor = 
   {
     'did':this.doctor.did,
     'dname':this.doctor.dname,
     'password':this.doctor.password,
     'location':
     {
       'locid':this.locid,
       'streetName':'',
       'areaName':'',
       'city':'',
       'pincode':123,
     },
     'specializations':[this.spec1,this.spec2,this.spec3]

   };
   console.log(this.doctor);   
        if(this.doctor.did===null)
        {
         
          this._ocsService.addDoctor(this.doctor).subscribe();
      
          this._router.navigate(['/viewdoctors']);
        
        }
        else
        {
    //       this.doctor = 
    // {
    //   'did':this.doctor.did,
    //   'dname':this.doctor.dname,
    //   'password':this.doctor.password,
    //   'location':
    //   {
    //     'locid':this.location.locid,
    //     'streetName':this.location.streetName,
    //     'areaName':this.location.areaName,
    //     'city':this.location.city,
    //     'pincode':this.location.pincode,
    //   },
    //   'specializations':[this.spec1,this.spec2,this.spec3]
 
    // };
          this._ocsService.updateDoctor(this.doctor).subscribe();
              this._router.navigate(['/viewdoctors']);
            
        }
 
  }
 
}
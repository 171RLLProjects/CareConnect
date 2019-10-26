import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { OcsServiceService } from '../ocs-service.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '../location';

@Component({
  selector: 'app-adddoctor',
  templateUrl: './adddoctor.component.html',
  styleUrls: ['./adddoctor.component.css']
})
export class AdddoctorComponent implements OnInit {

  doctor =new Doctor;
  location=new Location;
  locations:Location[];
  locid:String;
  check=false;
  constructor(private _ocsService:OcsServiceService,private _router:Router,private _activatedRoute:ActivatedRoute) { }

  ngOnInit() {

this._ocsService.getAllLocations().subscribe(
  locations =>{
    this.locations=locations;
  },
  error =>
  {
    alert(error);
  });

  }
  addspecialization()
  {

    this.check=true;
  }

  adddoctor()
  {
    this.doctor = 
    {
      'did':this.doctor.did,
      'dname':this.doctor.dname,
      'password':this.doctor.password,
      'location':
      {
        'locid':this.location.locid,
        'streetName':this.location.streetName,
        'areaName':this.location.areaName,
        'city':this.location.city,
        'pincode':this.location.pincode,
      },
      'specializations':[this.doctor.specializations[0],this.doctor.specializations[1],this.doctor.specializations[2]]

    };
    this._ocsService.addDoctor(this.doctor).subscribe(
      data => {
        this._router.navigate(['/']);
      },
      error =>
      {
        alert(error);
      });

  }

}

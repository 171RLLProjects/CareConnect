import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';
import { OcsServiceService } from '../ocs-service.service';
 
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
 
  constructor(private _ocsService:OcsServiceService,private _router:Router,private _activatedRouter:ActivatedRoute){}
  ngOnInit(){}
  
  title = 'CARECONNECT';
 
  reporterLogin(){
 
    this._router.navigate[('/reporterlogin')];
  }
  doctorLogin(){
    
    this._router.navigateByUrl('/doctorlogin');
  }
  adminLogin(){
    this._router.navigateByUrl('adminlogin');
  }
  register(){
    this._router.navigateByUrl('addpatient');
  }
  patientLogin(){
    this._router.navigateByUrl('patientlogin');
  }
}
import { Component, OnInit } from '@angular/core';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private _ocsService:OcsService,private _router:Router,private _activatedRouter:ActivatedRoute){}
  ngOnInit(){}
  
  title = 'CARECONNECT';


  reporterLogin(){

    this._router.navigate[('/reporterlogin')];
  }
  doctorLogin(){
    console.log("hlooooo");
    this._router.navigateByUrl('/doctorlogin');
  }
  adminLogin(){
    this._router.navigateByUrl('adminlogin');
  }
  register(){

  }
  patientLogin(){

  }
}

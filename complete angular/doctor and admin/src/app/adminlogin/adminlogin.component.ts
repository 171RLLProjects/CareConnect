import { Component, OnInit } from '@angular/core';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Doctor } from '../doctor';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import { first } from 'rxjs/operators';
import { Admin } from '../admin';
@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

 userId:string;
 password:string;
 admin:Admin;
 loginForm: FormGroup;
  submitted = false;
  invalidLogin = false;
  
  constructor(private formBuilder: FormBuilder,private _ocsService:OcsService,private _router:Router,private _activatedRouter:ActivatedRoute) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      userId: ['', Validators.required],
      password: ['', Validators.required]
    });
  }
adminLogin(){

  this.submitted = true;
  if (this.loginForm.invalid) {
    return;
  }
  this._ocsService.adminLogin(this.userId, this.password)
  .pipe(first())
  .subscribe(
      data => {
        this.admin = data;
           console.log(this.admin.aname);
          this._router.navigate(['/adminhomepage/',this.admin.aname]);
      },
      error => {
        this.invalidLogin = true;
      });
  // }else{
  //   console.log('componenet called '+this.userId);
  //     this._ocsService.doctorLogin(this.userId,this.password)
  //     .subscribe(doctor => { this.doctor = doctor;
  //     console.log('inseide method'+this.doctor.did)});
  
  // if(this.doctor.did!==null){
  //   console.log(this.doctor.did);
  //    this._router.navigate(['/appdetailsford',this.doctor.did]);
     
    
  // }else {
  //   this.invalidLogin = true;
  // }
}
}
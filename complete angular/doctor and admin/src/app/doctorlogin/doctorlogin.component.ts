import { Component, OnInit } from '@angular/core';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Doctor } from '../doctor';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import { first } from 'rxjs/operators';
@Component({
  selector: 'app-doctorlogin',
  templateUrl: './doctorlogin.component.html',
  styleUrls: ['./doctorlogin.component.css']
})
export class DoctorloginComponent implements OnInit {

 userId:string;
 password:string;
 doctor:Doctor;
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
doctorLogin(){

  this.submitted = true;
  if (this.loginForm.invalid) {
    return;
  }
  this._ocsService.doctorLogin(this.userId, this.password)
  .pipe(first())
  .subscribe(
      data => {
        this.doctor = data;
        
          this._router.navigate(['/doctorhomepage',this.doctor.did]);
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
  




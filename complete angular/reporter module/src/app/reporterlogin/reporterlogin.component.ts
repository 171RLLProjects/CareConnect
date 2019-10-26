import { Component, OnInit } from '@angular/core';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import { first } from 'rxjs/operators';
import { Reporter } from '../reporter';
import { longStackSupport } from 'q';
@Component({
  selector: 'app-reporterlogin',
  templateUrl: './reporterlogin.component.html',
  styleUrls: ['./reporterlogin.component.css']
})
export class ReporterloginComponent implements OnInit {
 
 userId:string;
 password:string;
 reporter:Reporter;
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
 
reporterLogin(){
 
  this.submitted = true;
  if (this.loginForm.invalid) {
    return;
  }
  this._ocsService.ReporterLogin(this.userId, this.password)
  .pipe(first())
  .subscribe(
      data => {
        this.reporter = data;
        console.log('login called');
          this._router.navigate(['/updateleave']);
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

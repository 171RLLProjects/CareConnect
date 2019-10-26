import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { OcsServiceService } from '../ocs-service.service';
import { first } from 'rxjs/operators';
import { Patient } from '../patient';

@Component({
  selector: 'app-patient-login',
  templateUrl: './patient-login.component.html',
  styleUrls: ['./patient-login.component.css']
})
export class PatientLoginComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private _router: Router,private _ocsService:OcsServiceService) { }

  pid:string;
  password:string;
  loginForm: FormGroup;
  patient:Patient;
  submitted = false;
  invalidLogin = false;
  
  patientLogin() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    
    this._ocsService.patientLogin(this.pid,this.password)
    .pipe(first()).subscribe(
  data =>{
this.patient=data,
this._router.navigate(['/patienthomepage/',this.patient.pid]);
  },
  error =>
  {
    this.invalidLogin=true;
  }
    );
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      pid: ['', Validators.required],
      password: ['', Validators.required]
    });
  }



}



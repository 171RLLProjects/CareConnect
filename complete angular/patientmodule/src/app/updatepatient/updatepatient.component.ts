import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient';
import { OcsServiceService } from '../ocs-service.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-updatepatient',
  templateUrl: './updatepatient.component.html',
  styleUrls: ['./updatepatient.component.css']
})
export class UpdatepatientComponent implements OnInit {
patient =new Patient;
pid:String;
patient1:Patient;
symptom:string
  adate: string;
  constructor(private _ocsService:OcsServiceService,private _router:Router,private _activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.adate=this._activatedRoute.snapshot.paramMap.get('pid');
    console.log(this.adate+'adate');
    this.pid=this._activatedRoute.snapshot.paramMap.get('adate');
    console.log(this.pid+'pid')
    this._ocsService.getPatientByid(this.pid).subscribe(
      patient1=>{
        this.patient=patient1;
        },
      error =>
      {
        alert(error);
      });
  }

  logout(){
    this._router.navigateByUrl('/homepage');
  }

  updatePatient()
  {
    this.patient={
      "pid":this.patient.pid,
      "pname":this.patient.pname,
      "gender":this.patient.gender,
      "age":this.patient.age,
      "phnNo":this.patient.phnNo,
      "email":this.patient.email,
      "streetName":this.patient.streetName,
      "areaName":this.patient.areaName,
      "city":this.patient.city,
      "pincode":this.patient.pincode,
      "symptom":this.symptom,
      "password":this.patient.password,
      "history":null
    };
 this._ocsService.updatePatient(this.patient).subscribe(
  data =>{
 this._router.navigate(['/suggestdoctors',this.pid,this.adate]);
  },
  error =>
  {
    alert(error);
  });

  }

 // getdoctors()
  //{
 //   this._ocsService.getDoctorsByLocAndSym(this.patient.pid).subscribe(
  //    data => {
  //     this._router.navigate(['/suggestdoctors',this.patient.pid]);
  //    },
  //    error =>
  ///    {
   //     alert(error);
   //   }
   // );
 // }
}

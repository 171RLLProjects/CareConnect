import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Doctor } from '../doctor';
import { OcsServiceService } from '../ocs-service.service';
import { Patient } from '../patient';

@Component({
  selector: 'app-choosedoctor',
  templateUrl: './choosedoctor.component.html',
  styleUrls: ['./choosedoctor.component.css']
})
export class ChoosedoctorComponent implements OnInit {

  adate:string;
  pid:string;
  did:string;
  doctor:Doctor;
  constructor(private _ocsService:OcsServiceService,private _router:Router,
    private _activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.adate=this._activatedRoute.snapshot.paramMap.get('adate');
    console.log(this.adate);
    this.pid=this._activatedRoute.snapshot.paramMap.get('pid');
    console.log(this.pid);
    this.did=this._activatedRoute.snapshot.paramMap.get('did');
    console.log(this.did);
    this._ocsService.getDoctorById(this.did).subscribe(
      doctor =>{
        this.doctor=doctor;
      },
      error =>{
        alert(error);
      }
    );
  }
  logout(){
    this._router.navigateByUrl('/homepage');
  }
  confirm()
  {
    this._ocsService.addAppointment(this.adate,this.pid,this.did).subscribe(
     
      error =>{
        alert(error);
      }
    );
    alert("your appointment is successfull,check in view appointments");
   
  }
 // previous()
 // {
 //   this._router.navigate(['/suggestdoctors']);
  //}
}

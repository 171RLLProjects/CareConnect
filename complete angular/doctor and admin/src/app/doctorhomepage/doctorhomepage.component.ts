import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Doctor } from '../doctor';

@Component({
  selector: 'app-doctorhomepage',
  templateUrl: './doctorhomepage.component.html',
  styleUrls: ['./doctorhomepage.component.css']
})
export class DoctorhomepageComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,private _ocsService:OcsService,private _router:Router,private _activatedRouter:ActivatedRoute) { }
    private did:string; 
    i:number;
    doctor=new Doctor;
    
  ngOnInit() {
   
    this.did=this._activatedRouter.snapshot.paramMap.get("did");
   this._ocsService.getDoctorById(this.did).subscribe(doctor=>{
     this.doctor=doctor;
   });
    console.log(this.did);
  }
  logout(){
    this._router.navigateByUrl('/homepage');
  }
  checkAndReqLeave(){
    console.log('check and req leave called');
    this._ocsService.checkAndRequestLeave(this.did).subscribe(j => { this.i = j;
    
    console.log(this.i);
    if(this.i===0){
      this._router.navigate(['/addleave',this.did]);
    }
    else{
      alert('you have already applied for a leave, check in leaves information');
    }
  }
    );
  }


}

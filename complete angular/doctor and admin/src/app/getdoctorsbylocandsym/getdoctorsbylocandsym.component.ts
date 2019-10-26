import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-getdoctorsbylocandsym',
  templateUrl: './getdoctorsbylocandsym.component.html',
  styleUrls: ['./getdoctorsbylocandsym.component.css']
})
export class GetdoctorsbylocandsymComponent implements OnInit {

  pid:string;
  adate:String;
  constructor(private doctor:Doctor,private doctors:Doctor[],private _ocsService:OcsService,private _router:Router,
    private _activatedRouter:ActivatedRoute) { }

  ngOnInit() {
    this.adate=this._activatedRouter.snapshot.paramMap.get('adate');

    this._ocsService.getDoctorsByLocAndSym(this.pid).subscribe(doctors => {

      this.doctors=doctors});


  }

  doctorDetails(did:string){
    this._router.navigate(['/choosedoctor/',did,this.adate]);
  }

}

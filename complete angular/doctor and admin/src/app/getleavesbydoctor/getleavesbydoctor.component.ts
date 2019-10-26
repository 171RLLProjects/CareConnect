import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Appointment } from '../appointment';
import { Leave } from '../leave';

@Component({
  selector: 'app-getleavesbydoctor',
  templateUrl: './getleavesbydoctor.component.html',
  styleUrls: ['./getleavesbydoctor.component.css']
})
export class GetleavesbydoctorComponent implements OnInit {

  leaves:Leave[];
  did:string;
  constructor(private formBuilder: FormBuilder,private _ocsService:OcsService,private _router:Router,private _activatedRouter:ActivatedRoute) { }

  ngOnInit() {

    this.did=this._activatedRouter.snapshot.paramMap.get("did");
    console.log(this.did);
    this._ocsService.getLeavesByDoctor(this.did).subscribe(leaves => { 
      this.leaves = leaves;});

  }

}

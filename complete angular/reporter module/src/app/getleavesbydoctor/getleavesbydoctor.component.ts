import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { OcsService } from '../ocs.service';
import { Leave } from '../leave';
import { Doctor } from '../doctor';

@Component({
  selector: 'app-getleavesbydoctor',
  templateUrl: './getleavesbydoctor.component.html',
  styleUrls: ['./getleavesbydoctor.component.css']
})
export class GetleavesbydoctorComponent implements OnInit {
  leaves:Leave[];
  doctor:Doctor;
  did:string;
  constructor(private _ocsservice: OcsService, private router: Router,private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this._ocsservice.getDoctorById(this.did).subscribe(doctor => {
      this.doctor = doctor
      console.log(this.doctor);
    });
    this. _ocsservice.getLeavesByDoctor(this.doctor).subscribe(leaves =>
      {
        this.leaves=leaves;
      });

  }

}

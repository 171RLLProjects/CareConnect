import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { OcsServiceService } from '../ocs-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-doctor',
  templateUrl: './view-doctor.component.html',
  styleUrls: ['./view-doctor.component.css']
})
export class ViewDoctorComponent implements OnInit {
doctors:Doctor[];
  constructor(private _ocsService:OcsServiceService,private _router:Router) { }

  ngOnInit() {
    this._ocsService.getAllDoctors().subscribe(
      doctors => { this.doctors = doctors;}
 
     );
  }

  delete(doc:Doctor): void
  {
this._ocsService.deleteDoctor(doc.did).subscribe(
  data => {
    this.doctors=this.doctors.filter(u => u !== doc);
  });

  }

  edit(doc:Doctor): void {
    console.log('doctor edit called');
    this._router.navigate(['/adddoctor/', doc]);
  }

}

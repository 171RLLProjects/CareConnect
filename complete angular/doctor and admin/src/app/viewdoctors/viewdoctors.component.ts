import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { Router } from '@angular/router';
import { OcsService } from '../ocs.service';

@Component({
  selector: 'app-viewdoctors',
  templateUrl: './viewdoctors.component.html',
  styleUrls: ['./viewdoctors.component.css']
})
export class ViewdoctorsComponent implements OnInit {

  spec1:string;
  spec2:string;
  spec3:string;
  doctors:Doctor[];
  constructor(private _ocsService:OcsService,private _router:Router) { }
 
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

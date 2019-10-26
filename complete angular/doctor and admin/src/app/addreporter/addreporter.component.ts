import { Component, OnInit } from '@angular/core';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Reporter } from '../reporter';
 
@Component({
  selector: 'app-addreporter',
  templateUrl: './addreporter.component.html',
  styleUrls: ['./addreporter.component.css']
})
export class AddreporterComponent implements OnInit {
  reporter=new Reporter;
 
  constructor(private _ocsservice: OcsService, private _router: Router,private _activatedRoute: ActivatedRoute) { }
 
  ngOnInit() {
   
    this.reporter.rname=this._activatedRoute.snapshot.paramMap.get('rname');
    this.reporter.password=this._activatedRoute.snapshot.paramMap.get('password');
  }
  addReporter(){
    
this.reporter ={
 
  'rid':this.reporter.rid,
 'rname': this.reporter.rname, 
 'password': this.reporter.password
 
};
 
  this._ocsservice.addReporter(this.reporter).subscribe(
  
      data => {
  alert("successfully added");
  this._router.navigate(['/adminhomepage']);
      },
      error => {
        alert(error);
      });
  
 }
}
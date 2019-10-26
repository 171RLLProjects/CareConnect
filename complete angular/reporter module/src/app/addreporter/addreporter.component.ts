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

  constructor(private _ocsservice: OcsService, private router: Router,private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
   
    this.reporter.rname=this.activatedRoute.snapshot.paramMap.get('rname');
    this.reporter.password=this.activatedRoute.snapshot.paramMap.get('password');
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
      },
      error => {
        alert(error);
      });
  
 }
}


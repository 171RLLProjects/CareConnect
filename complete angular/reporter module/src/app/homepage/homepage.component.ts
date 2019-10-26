
import { Component, OnInit } from '@angular/core';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Reporter } from '../reporter';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private _ocsservice: OcsService, private router: Router,private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    }
    ReporterLogin1(){
      this.router.navigateByUrl('/reporterlogin');

    }
  }


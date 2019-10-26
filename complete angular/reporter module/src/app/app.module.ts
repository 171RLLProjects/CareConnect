import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{ HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { ReporterloginComponent } from './reporterlogin/reporterlogin.component';
import { OcsService } from './ocs.service';
import { AddreporterComponent } from './addreporter/addreporter.component';
import { AddleaveComponent } from './addleave/addleave.component';
import { UpdateLeaveComponent } from './updateleave/updateleave.component';
import { GetleavesbydoctorComponent } from './getleavesbydoctor/getleavesbydoctor.component';
import{ RouterModule ,Routes} from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomepageComponent } from './homepage/homepage.component';

//import { ViewreporterComponent } from './viewreporter/viewreporter.component';

const appRoute: Routes = [
  {path: 'addleave', component:AddleaveComponent},
  {path: 'addreporter', component:AddreporterComponent},
  {path:'getleavesbydoctor', component:GetleavesbydoctorComponent},
  {path:'reporterlogin', component:ReporterloginComponent},
  {path:'updateleave', component:UpdateLeaveComponent},
  {path: 'homepage',component:HomepageComponent}

  //{path:'viewreporter', component:ViewreporterComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    ReporterloginComponent,
    AddreporterComponent,
    AddleaveComponent,
    UpdateLeaveComponent,
    GetleavesbydoctorComponent,
    HomepageComponent,
  
  ],
  imports: [ReactiveFormsModule,FormsModule,BrowserModule,RouterModule.forRoot(appRoute),HttpClientModule
   ],
  providers: [OcsService],
  bootstrap: [AppComponent]
})
export class AppModule { }

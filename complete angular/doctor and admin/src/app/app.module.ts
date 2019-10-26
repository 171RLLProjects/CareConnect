import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { DoctorloginComponent } from './doctorlogin/doctorlogin.component';
import { OcsService } from './ocs.service';
import { HttpClientModule } from '@angular/common/http';
import { AppdetailsfordComponent } from './appdetailsford/appdetailsford.component';
import { ReqappointmentComponent } from './reqappointment/reqappointment.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { DoctorhomepageComponent } from './doctorhomepage/doctorhomepage.component';

import { AdminhomepageComponent } from './adminhomepage/adminhomepage.component';
import { GetdoctorsbylocandsymComponent } from './getdoctorsbylocandsym/getdoctorsbylocandsym.component';
import { ChoosedoctorComponent } from './choosedoctor/choosedoctor.component';
import { AddleaveComponent } from './addleave/addleave.component';
import { GetleavesbydoctorComponent } from './getleavesbydoctor/getleavesbydoctor.component';
import { AddreporterComponent } from './addreporter/addreporter.component';
import { HomepageComponent } from './homepage/homepage.component';
import { AdddoctorComponent } from './adddoctor/adddoctor.component';
import { ViewdoctorsComponent } from './viewdoctors/viewdoctors.component';
import { AddlocationComponent } from './addlocation/addlocation.component';
import { ViewlocationsComponent } from './viewlocations/viewlocations.component';
import { ViewappforadminComponent } from './viewappforadmin/viewappforadmin.component';
import { componentFactoryName } from '@angular/compiler';
const appRoute: Routes = [
  { path: 'home', component: AppComponent },
  { path: 'doctorlogin', component: DoctorloginComponent },
  { path: 'appdetailsford/:did', component: AppdetailsfordComponent },
  { path: 'doctorhomepage/:did', component: DoctorhomepageComponent },
  { path: 'addleave/:did', component: AddleaveComponent },
  { path: 'getleavesbydoctor/:did', component: GetleavesbydoctorComponent },
  { path: 'adminlogin', component: AdminloginComponent },
  { path: 'adminhomepage/:aname', component: AdminhomepageComponent },
  { path: 'addreporter', component: AddreporterComponent },
  { path: 'homepage', component: HomepageComponent },
  { path: 'adddoctor', component:AdddoctorComponent},
  { path: 'viewdoctors', component:ViewdoctorsComponent },
  { path: 'addlocation', component:AddlocationComponent},
  {path: 'viewlocations', component:ViewlocationsComponent},
  {path: 'viewappointments', component:ViewappforadminComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    DoctorloginComponent,
    AppdetailsfordComponent,
    ReqappointmentComponent,
    AdminloginComponent,
    DoctorhomepageComponent,
    GetleavesbydoctorComponent,
    AdminhomepageComponent,
    GetdoctorsbylocandsymComponent,
    ChoosedoctorComponent,
    AddleaveComponent,
    GetleavesbydoctorComponent,
    AddreporterComponent,
    HomepageComponent,
    AdddoctorComponent,
    ViewdoctorsComponent,
    AddlocationComponent,
    ViewlocationsComponent,
    ViewappforadminComponent
  ],
  imports: [
    ReactiveFormsModule, FormsModule, BrowserModule, RouterModule.forRoot(appRoute), HttpClientModule
  ],
  providers: [OcsService],
  bootstrap: [AppComponent]
})
export class AppModule {





}

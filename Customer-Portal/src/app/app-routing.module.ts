import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCustomerComponent } from './components/add-customer/add-customer.component';
import { CustomerDetailsComponent } from './components/customer-details/customer-details.component';
import { CustomerListComponent } from './components/customer-list/customer-list.component';
import { DeleteCustomerComponent } from './components/delete-customer/delete-customer.component';
import { HomeComponent } from './components/home/home.component';
import { UpdateCustomerComponent } from './components/update-customer/update-customer.component';


const routes:Routes=[
  {path:"",component:HomeComponent},
  {path:"home",component:HomeComponent},
  {path:"customer-list",component:CustomerListComponent},
  {path:"create",component:AddCustomerComponent},
  {path:'customer/:id',component:CustomerDetailsComponent},
  {path:"update/:id",component:UpdateCustomerComponent},
  {path:"delete/:id",component:DeleteCustomerComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

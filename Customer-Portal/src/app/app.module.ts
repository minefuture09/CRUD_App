import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http"
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerDetailsComponent } from './components/customer-details/customer-details.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { NamePipePipe } from './pipes/name-pipe.pipe';
import { AgePipePipe } from './pipes/age-pipe.pipe';
import { DobPipePipe } from './pipes/dob-pipe.pipe';
import { AddCustomerComponent } from './components/add-customer/add-customer.component';
import { UpdateCustomerComponent } from './components/update-customer/update-customer.component';
import { DeleteCustomerComponent } from './components/delete-customer/delete-customer.component';
import { CustomerListComponent } from './components/customer-list/customer-list.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { SearchPipe } from './pipes/search.pipe';


@NgModule({
  declarations: [
    AppComponent,
    CustomerDetailsComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    SidebarComponent,
    NamePipePipe,
    AgePipePipe,
    DobPipePipe,
    AddCustomerComponent,
    UpdateCustomerComponent,
    DeleteCustomerComponent,
    CustomerListComponent,
    SearchPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [AppRoutingModule,AddCustomerComponent,CustomerListComponent,HomeComponent]
})
export class AppModule { }

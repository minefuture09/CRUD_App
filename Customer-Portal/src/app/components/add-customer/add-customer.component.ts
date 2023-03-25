import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  customer!:Customer;
  constructor(private service:CustomerService,private router:Router) { }

  ngOnInit(): void {
  }

  

  addCustomer(customer:Customer){
   
    this.service.addCustomer(customer).subscribe(customer=>{this.router.navigate(["/customer-list"])});
   

  }
  
}

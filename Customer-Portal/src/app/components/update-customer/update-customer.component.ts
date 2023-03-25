import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  customer:Customer=new Customer();
  constructor(private service:CustomerService,private activatedRouter:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
  
    this.activatedRouter.params.subscribe(paramsData=>{
      this.service.getDeatils(paramsData['id']).subscribe(data=>this.customer=data);
    })


  }
  updateCustomer(){
   
    this.service.updateCustomer(this.customer.id,this.customer).subscribe(customer=>
      this.router.navigate(["/customer",customer.id]))
   
  }
 

}

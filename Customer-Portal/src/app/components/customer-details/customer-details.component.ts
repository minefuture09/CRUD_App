import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/model/customer';

import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {


  customer:Customer = new Customer();
  constructor(private service :CustomerService,private activatedRouter:ActivatedRoute) {
    
   }
  
  ngOnInit(): void {
    this.activatedRouter.params.subscribe(paramData=>{

      
      this.service.getDeatils(paramData['id']).subscribe(data=>this.customer=data);
   
    })
    
    
  }

}

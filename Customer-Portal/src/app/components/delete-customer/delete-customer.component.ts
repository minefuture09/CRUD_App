import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {
  
  constructor(private service:CustomerService) { }

  ngOnInit(): void {
  }
  deleteCustomer(id:number):any{
    this.service.deleteCustomer(id);
  }
}

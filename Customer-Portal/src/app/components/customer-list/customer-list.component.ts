import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

 public searchValue:any ="";
  customers!:Customer[];
  constructor(private service:CustomerService,private router:Router) { }

  ngOnInit(): void {
    this.service.getAllCustomers().subscribe(data=>this.customers=data);
  }

reloadCurrentRoute() {
  let currentUrl = this.router.url;
  this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
      this.router.navigate([currentUrl]);
  });
}
  deleteCustomer(id:number){
    let flag = confirm("Are you sure?");
    
    if(flag==true){

      this.service.deleteCustomer(id).subscribe(customer=>this.router.navigate(["/customer-list"]));
      
      window.location.reload();
   
      
    }
    
  
  }

  updateCustomer(id:number,c:Customer){

    this.service.updateCustomer(id,c).subscribe(customer=>this.router.navigate(["/update/"+id]));

  }
  
}

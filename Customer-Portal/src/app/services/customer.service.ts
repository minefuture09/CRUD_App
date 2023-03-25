import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Customer } from '../model/customer';
const baseUrl = "http://localhost:8086/";
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customer!: Customer;


  constructor(private http: HttpClient) {

  }

  getDeatils(id: number): Observable<Customer> {



    return this.http.get(baseUrl + "customer/" + id).pipe(map(data => data as Customer));
  }

  addCustomer(customer: Customer): Observable<Customer> {
    return this.http.post(baseUrl+"customer/",customer).pipe(map(data => data as Customer));
  }
  updateCustomer(id: number, customer: Customer): Observable<Customer> {
    
    return this.http.put(baseUrl+"customer/"+id,customer ).pipe(map(data => data as Customer));
  }
  deleteCustomer(id:number): Observable<any> {
  
    return this.http.delete(baseUrl+id);
  }

  getAllCustomers(): Observable<Customer[]> {
    return this.http.get(baseUrl+"customers").pipe(map(data => data as Customer[]));
  }

}
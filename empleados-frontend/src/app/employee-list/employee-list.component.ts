import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[];

  constructor(private employeeService: EmployeeService,
              private router: Router) {}

    ngOnInit(): void {
      this.getEmployees();
    }

    private getEmployees(){
      this.employeeService.getEmployeesList().subscribe(data => {
        console.log("getEmployees: ",JSON.stringify(data));
        this.employees = data;
        console.log("lista: ",JSON.stringify(this.employees));
      });
    }

    employeeDetails(id: number){
      this.router.navigate(['employee-details', id]);
    }

    updateEmployee(id: number){
      this.router.navigate(['update-employee', id]);
    }

    deleteEmployee(id: number){
      this.employeeService.deleteEmployee(id).subscribe( data => {
        console.log(data);
        this.getEmployees();
      })
    }

}
